/*
 * generated by Xtext
 */
package at.bestsolution.efxclipse.tooling.fxgraph.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;

import at.bestsolution.efxclipse.tooling.fxgraph.ui.hover.FXHoverProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class FXGraphUiModule extends at.bestsolution.efxclipse.tooling.fxgraph.ui.AbstractFXGraphUiModule {
	public FXGraphUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return FXHoverProvider.class;
	}
}