/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package at.bestsolution.efxclipse.runtime.bindings.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import javax.inject.Inject;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.contexts.Context;
import org.eclipse.e4.core.contexts.IEclipseContext;

import at.bestsolution.efxclipse.runtime.bindings.api.EBinding;
import at.bestsolution.efxclipse.runtime.bindings.api.ETriggerSequence;


/**
 * manage tables of bindings that can be used to look up commands from keys.
 */
@SuppressWarnings("restriction")
public class BindingTableManager {
	private static final String BINDING_TABLE_PREFIX = "bindingTable:"; //$NON-NLS-1$

	@Inject
	private IEclipseContext eclipseContext;

	private ContextSet definedTables = ContextSet.EMPTY;

	private String[] activeSchemeIds;

	public void addTable(BindingTable table) {
		String contextId = getTableId(table.getId());
		if (eclipseContext.containsKey(contextId)) {
			return; // it's already there
			//			throw new IllegalArgumentException("Already contains table " + contextId); //$NON-NLS-1$
		}
		eclipseContext.set(contextId, table);
		final List<Context> contexts = definedTables.getContexts();
		if (!contexts.contains(table.getTableId())) {
			// this is only valid because I'm throwing away the old definedTables contextSet
			contexts.add(table.getTableId());
			definedTables = createContextSet(contexts);
		}
	}

	private String getTableId(String id) {
		return BINDING_TABLE_PREFIX + id;
	}

	public void removeTable(BindingTable table) {
		String contextId = getTableId(table.getId());
		if (!eclipseContext.containsKey(contextId)) {
			throw new IllegalArgumentException("Does not contains table " + contextId); //$NON-NLS-1$
		}
		eclipseContext.remove(contextId);
		final List<Context> contexts = definedTables.getContexts();
		if (contexts.contains(table.getTableId())) {
			// this is only valid because I'm throwing away the old definedTables contextSet
			contexts.remove(table.getTableId());
			definedTables = createContextSet(contexts);
		}
	}

	public BindingTable getTable(String id) {
		return (BindingTable) eclipseContext.get(getTableId(id));
	}

	// we're just going through each binding table, and returning a
	// flat list of bindings here
	public Collection<EBinding> getActiveBindings() {
		ArrayList<EBinding> bindings = new ArrayList<EBinding>();
		for (Context ctx : definedTables.getContexts()) {
			BindingTable table = getTable(ctx.getId());
			if (table != null) {
				bindings.addAll(table.getBindings());
			}
		}
		return bindings;
	}

	public ContextSet createContextSet(Collection<Context> contexts) {
		return new ContextSet(contexts);
	}

	public Collection<EBinding> getConflictsFor(ContextSet contextSet,
			ETriggerSequence triggerSequence) {
		Collection<EBinding> matches = new ArrayList<EBinding>();
		for (Context ctx : contextSet.getContexts()) {
			BindingTable table = getTable(ctx.getId());
			if (table != null) {
				final Collection<EBinding> matchesFor = table.getConflictsFor(triggerSequence);
				if (matchesFor != null) {
					matches.addAll(matchesFor);
				}
			}
		}
		return matches.size() == 0 ? null : matches;
	}

	public Collection<EBinding> getAllConflicts() {
		Collection<EBinding> conflictsList = new ArrayList<EBinding>();
		for (Context ctx : definedTables.getContexts()) {
			BindingTable table = getTable(ctx.getId());
			if (table != null) {
				Collection<EBinding> conflictsInTable = table.getConflicts();
				if (conflictsInTable != null) {
					conflictsList.addAll(conflictsInTable);
				}
			}
		}
		return conflictsList;
	}

	public EBinding getPerfectMatch(ContextSet contextSet, ETriggerSequence triggerSequence) {
		EBinding result = null;
		EBinding currentResult = null;
		List<Context> contexts = contextSet.getContexts();
		ListIterator<Context> it = contexts.listIterator(contexts.size());
		while (it.hasPrevious()) {
			Context c = it.previous();
			BindingTable table = getTable(c.getId());
			if (table != null) {
				currentResult = table.getPerfectMatch(triggerSequence);
			}
			if (currentResult != null) {
				if (isMostActiveScheme(currentResult)) {
					return currentResult;
				}
				if (result == null) {
					result = currentResult;
				} else {
					int rc = compareSchemes(result.getSchemeId(), currentResult.getSchemeId());
					if (rc < 0) {
						result = currentResult;
					}
				}
			}
		}
		return result;
	}

	/**
	 * @param currentResult
	 * @return
	 */
	private boolean isMostActiveScheme(EBinding currentResult) {
		if (activeSchemeIds == null || activeSchemeIds.length < 2) {
			return true;
		}
		final String mostActive = activeSchemeIds[0];
		return mostActive == null ? false : mostActive.equals(currentResult.getSchemeId());
	}

	public EBinding getBestSequenceFor(ContextSet contextSet,
			ParameterizedCommand parameterizedCommand) {
		ArrayList<EBinding> bindings = (ArrayList<EBinding>) getSequencesFor(contextSet,
				parameterizedCommand);
		if (bindings.size() == 0) {
			return null;
		}
		return bindings.get(0);
	}

	public Collection<EBinding> getSequencesFor(ContextSet contextSet,
			ParameterizedCommand parameterizedCommand) {
		ArrayList<EBinding> bindings = new ArrayList<EBinding>();
		List<Context> contexts = contextSet.getContexts();
		ListIterator<Context> it = contexts.listIterator(contexts.size());
		while (it.hasPrevious()) {
			Context c = it.previous();
			BindingTable table = getTable(c.getId());
			if (table != null) {
				Collection<EBinding> sequences = table.getSequencesFor(parameterizedCommand);
				if (sequences != null) {
					bindings.addAll(sequences);
				}
			}
		}
		Collections.sort(bindings, BindingTable.BEST_SEQUENCE);
		return bindings;
	}

	public Collection<EBinding> getBindingsFor(ContextSet contextSet, ParameterizedCommand cmd) {
		Collection<EBinding> bindings = new ArrayList<EBinding>();
		for (Context ctx : contextSet.getContexts()) {
			BindingTable table = getTable(ctx.getId());
			if (table != null) {
				Collection<EBinding> matches = table.getSequencesFor(cmd);
				if (matches != null) {
					bindings.addAll(matches);
				}
			}
		}
		return bindings;
	}

	public boolean isPartialMatch(ContextSet contextSet, ETriggerSequence sequence) {
		List<Context> contexts = contextSet.getContexts();
		ListIterator<Context> it = contexts.listIterator(contexts.size());
		while (it.hasPrevious()) {
			Context c = it.previous();
			BindingTable table = getTable(c.getId());
			if (table != null) {
				if (table.isPartialMatch(sequence)) {
					return true;
				}
			}
		}
		return false;
	}

	public Collection<EBinding> getPartialMatches(ContextSet contextSet, ETriggerSequence sequence) {
		ArrayList<EBinding> bindings = new ArrayList<EBinding>();
		List<Context> contexts = contextSet.getContexts();
		ListIterator<Context> it = contexts.listIterator(contexts.size());
		while (it.hasPrevious()) {
			Context c = it.previous();
			BindingTable table = getTable(c.getId());
			if (table != null) {
				Collection<EBinding> partialMatches = table.getPartialMatches(sequence);
				if (partialMatches != null) {
					bindings.addAll(partialMatches);
				}
			}
		}
		return bindings;
	}

	/**
	 * @param activeSchemeIds
	 */
	public void setActiveSchemes(String[] activeSchemeIds) {
		this.activeSchemeIds = activeSchemeIds;
		BindingTable.BEST_SEQUENCE.setActiveSchemes(activeSchemeIds);
	}

	/*
	 * Copied from org.eclipse.jface.bindings.BindingManager.compareSchemes(String, String)
	 * 
	 * Returns an in based on scheme 1 < scheme 2
	 */
	private final int compareSchemes(final String schemeId1, final String schemeId2) {
		if (activeSchemeIds == null) {
			return 0;
		}
		if (!schemeId2.equals(schemeId1)) {
			for (int i = 0; i < activeSchemeIds.length; i++) {
				final String schemePointer = activeSchemeIds[i];
				if (schemeId2.equals(schemePointer)) {
					return 1;
				} else if (schemeId1.equals(schemePointer)) {
					return -1;
				}
			}
		}
		return 0;
	}
}
