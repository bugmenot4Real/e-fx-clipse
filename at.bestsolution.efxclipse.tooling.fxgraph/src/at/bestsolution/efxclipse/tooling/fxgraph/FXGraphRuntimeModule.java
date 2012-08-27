/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package at.bestsolution.efxclipse.tooling.fxgraph;

import org.eclipse.xtext.generator.OutputConfigurationProvider;

import at.bestsolution.efxclipse.tooling.fxgraph.compiler.FXGraphOutputConfigurationProvider;
import at.bestsolution.efxclipse.tooling.fxgraph.scoping.FXGraphQualifiedNameProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class FXGraphRuntimeModule extends at.bestsolution.efxclipse.tooling.fxgraph.AbstractFXGraphRuntimeModule {
	// contributed by org.eclipse.xtext.generator.generator.GeneratorFragment
	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return at.bestsolution.efxclipse.tooling.fxgraph.generator.FXGraphGenerator.class;
	}
	
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return FXGraphQualifiedNameProvider.class;
	}
	
	public Class<? extends OutputConfigurationProvider> bindOutputConfigurationProvider() {
		return FXGraphOutputConfigurationProvider.class;
	}
}
