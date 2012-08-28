/*
* generated by Xtext
*/
package at.bestsolution.efxclipse.tooling.css.cssext.ui.labeling;

import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

import at.bestsolution.efxclipse.tooling.css.cssext.cssExtDsl.CSSRuleDefinition;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class CssExtDslDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

	
	String text(CSSRuleDefinition model) {
		return model.getName().getName() + " (description)";
	}
	
	
/*
	//Labels and icons can be computed like this:
	
	String text(IEObjectDescription ele) {
	  return "my "+ele.getName();
	}
	 
    String image(IEObjectDescription ele) {
      return ele.getEClass().getName() + ".gif";
    }	 
*/

}