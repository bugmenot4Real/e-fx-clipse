package at.bestsolution.efxclipse.text.jface.reconciler;

import org.eclipse.core.runtime.IProgressMonitor;


/**
 * Extends {@link org.eclipse.jface.text.reconciler.IReconcilingStrategy}
 * with the following functions:
 * <ul>
 * 	<li>usage of a progress monitor</li>
 * 	<li>initial reconciling step: if a reconciler runs as periodic activity in the background, this
 * 		methods offers the reconciler a chance for initializing its strategies and achieving a
 * 		reconciled state before the periodic activity starts.</li>
 * </ul>
 *
 * @since 2.0
 */
public interface IReconcilingStrategyExtension {

	/**
	 * Tells this reconciling strategy with which progress monitor
	 * it will work. This method will be called before any other
	 * method and can be called multiple times.
	 *
	 * @param monitor the progress monitor with which this strategy will work
	 */
	void setProgressMonitor(IProgressMonitor monitor);

	/**
	 * Called only once in the life time of this reconciling strategy.
	 */
	void initialReconcile();
}
