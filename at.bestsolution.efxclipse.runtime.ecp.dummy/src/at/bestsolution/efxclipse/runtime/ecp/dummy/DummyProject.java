package at.bestsolution.efxclipse.runtime.ecp.dummy;

import java.util.Collection;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.core.ECPProvider;
import org.eclipse.emf.ecp.core.ECPRepository;
import org.eclipse.emf.ecp.core.util.ECPElement;
import org.eclipse.emf.ecp.core.util.ECPModelContext;
import org.eclipse.emf.ecp.core.util.ECPProperties;
import org.eclipse.emf.edit.domain.EditingDomain;

public class DummyProject implements ECPProject {
	
	Resource resource;
	String name;
	
	DummyWorkspace workspace = DummyWorkspace.INSTANCE;

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public String getType() {
		return ECPProject.TYPE;
	}

	@Override
	public int compareTo(ECPElement arg0) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public ECPModelContext getContext() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public ECPProvider getProvider() {
		return DummyWorkspace.INSTANCE.getProvider();
	}

	@Override
	public ECPRepository getRepository() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public ECPProperties getProperties() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public boolean isOpen() {
		return true;
	}

	@Override
	public void open() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public void close() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public boolean canDelete() {
		return false;
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public EditingDomain getEditingDomain() {
		return workspace.getEditingDomain();
	}

	@Override
	public Object getAdapter(Class adapter) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public EList<Object> getElements() {
		EList<? extends Object> contents = ECollections.unmodifiableEList(resource.getContents());
		return (EList<Object>) contents;
	}

	@Override
	public void saveModel() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isModelDirty() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteElements(Collection<Object> objects) {
		throw new UnsupportedOperationException();
	}

}
