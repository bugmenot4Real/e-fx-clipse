package at.bestsolution.efxclipse.tooling.jdt.ui.internal.buildpath;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.util.ExceptionHandler;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPage;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPageExtension;
import org.eclipse.jdt.ui.wizards.NewElementWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import at.bestsolution.efxclipse.tooling.jdt.core.JavaFXCore;

public class JavaFXContainerWizardPage extends NewElementWizardPage implements IClasspathContainerPage, IClasspathContainerPageExtension {
	private IClasspathEntry fContainerEntryResult;
	private IJavaProject fProject;
	
	
	public JavaFXContainerWizardPage() {
		super("JavaFXContainerPage"); //$NON-NLS-1$
		
		setTitle("JavaFX Library");
		setDescription("JavaFX Library Selection");
//		setImageDescriptor(JavaPluginImages.DESC_WIZBAN_ADD_LIBRARY);

		fContainerEntryResult = JavaCore.newContainerEntry(JavaFXCore.JAVAFX_CONTAINER_PATH);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite= new Composite(parent, SWT.NONE);
		composite.setFont(parent.getFont());

		composite.setLayout(new GridLayout(2, false));
		
		setControl(composite);
	}
	
	public static IJavaProject getPlaceholderProject() {
		String name= "####internal"; //$NON-NLS-1$
		IWorkspaceRoot root= ResourcesPlugin.getWorkspace().getRoot();
		while (true) {
			IProject project= root.getProject(name);
			if (!project.exists()) {
				return JavaCore.create(project);
			}
			name += '1';
		}
	}

	@Override
	public boolean finish() {
		try {
			IJavaProject[] javaProjects= new IJavaProject[] { getPlaceholderProject() };
			IClasspathContainer[] containers= { null };
			JavaCore.setClasspathContainer(fContainerEntryResult.getPath(), javaProjects, containers, null);
		} catch (JavaModelException e) {
			ExceptionHandler.handle(e, getShell(), "JavaFX Container Error", "Error configuring JavaFX Classpath Container");
			return false;
		}
		return true;
	}

	@Override
	public IClasspathEntry getSelection() {
		return fContainerEntryResult;
	}

	
	@Override
	public void setSelection(IClasspathEntry containerEntry) {
//		fContainerEntryResult = containerEntry;
	}

	@Override
	public void initialize(IJavaProject project, IClasspathEntry[] currentEntries) {
		fProject = project;
	}

}
