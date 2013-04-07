package at.bestsolution.efxclipse.runtime.ecp.dummy;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.core.ECPProvider;
import org.eclipse.emf.ecp.core.ECPRepository;
import org.eclipse.emf.ecp.core.util.ECPElement;
import org.eclipse.emf.ecp.core.util.ECPModelContext;
import org.eclipse.emf.ecp.spi.core.InternalProject;
import org.eclipse.emf.ecp.spi.core.InternalProvider;
import org.eclipse.emf.ecp.spi.core.InternalRepository;
import org.eclipse.emf.ecp.spi.core.util.AdapterProvider;
import org.eclipse.emf.ecp.spi.core.util.InternalChildrenList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

public class DummyProvider implements InternalProvider {

	DummyWorkspace workspace = DummyWorkspace.INSTANCE;

	@Override
	public String getName() {
		return "Dummy Provider";
	}

	@Override
	public String getType() {
		return ECPProvider.TYPE;
	}

	@Override
	public int compareTo(ECPElement arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getAdapter(Class adapter) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getLabel() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<ECPRepository> getRepositories() {
		return Collections.singleton((ECPRepository) workspace.getRepository());
	}

	@Override
	public boolean canAddRepositories() {
		return false;
	}

	@Override
	public boolean hasUnsharedProjectSupport() {
		return false;
	}

	@Override
	public ECPProvider getProvider() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ECPModelContext getModelContext(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLabel(String label) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDescription(String description) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getDescription() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isDisposed() {
		return false;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addDisposeListener(DisposeListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeDisposeListener(DisposeListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public <T> T getAdapter(Object adaptable, Class<T> adapterType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public AdapterProvider getUIProvider() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setUIProvider(AdapterProvider uiProvider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EditingDomain createEditingDomain(InternalProject project) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isSlow(Object parent) {
		return false;
	}

	@Override
	public void fillChildren(ECPModelContext context, Object parent, InternalChildrenList childrenList) {
		ITreeItemContentProvider contentProvider = (ITreeItemContentProvider) DummyWorkspace.INSTANCE.getAdapterFactory().adapt(parent, ITreeItemContentProvider.class);
		if (contentProvider != null)
			childrenList.addChildren(contentProvider.getChildren(parent));
	}

	@Override
	public void handleLifecycle(ECPModelContext context, LifecycleEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public EList<? extends Object> getElements(InternalProject project) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<EPackage> getUnsupportedEPackages(Collection<EPackage> ePackages, InternalRepository repository) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<EObject> getLinkElements(InternalProject project, EObject modelElement, EReference eReference) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void doSave(InternalProject project) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isDirty(InternalProject project) {
		return false;
	}

	@Override
	public void delete(InternalProject project, Collection<EObject> eObjects) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void cloneProject(InternalProject projectToClone, InternalProject targetProject) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean modelExists(InternalProject project) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Notifier getRoot(InternalProject project) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<InternalProject> getOpenProjects() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(InternalProject project, Object object) {
		throw new UnsupportedOperationException();
	}

}