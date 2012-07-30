/*
* generated by Xtext
*/
grammar InternalCssExtDsl;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package at.bestsolution.efxclipse.tooling.css.cssext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package at.bestsolution.efxclipse.tooling.css.cssext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.bestsolution.efxclipse.tooling.css.cssext.services.CssExtDslGrammarAccess;

}

@parser::members {

 	private CssExtDslGrammarAccess grammarAccess;
 	
    public InternalCssExtDslParser(TokenStream input, CssExtDslGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "CssExtension";	
   	}
   	
   	@Override
   	protected CssExtDslGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleCssExtension
entryRuleCssExtension returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCssExtensionRule()); }
	 iv_ruleCssExtension=ruleCssExtension 
	 { $current=$iv_ruleCssExtension.current; } 
	 EOF 
;

// Rule CssExtension
ruleCssExtension returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getCssExtensionAccess().getImportsImportParserRuleCall_0_0()); 
	    }
		lv_imports_0_0=ruleImport		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCssExtensionRule());
	        }
       		add(
       			$current, 
       			"imports",
        		lv_imports_0_0, 
        		"Import");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getCssExtensionAccess().getPackageDefPackageDeclarationParserRuleCall_1_0()); 
	    }
		lv_packageDef_1_0=rulePackageDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCssExtensionRule());
	        }
       		set(
       			$current, 
       			"packageDef",
        		lv_packageDef_1_0, 
        		"PackageDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleImport
entryRuleImport returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getImportRule()); }
	 iv_ruleImport=ruleImport 
	 { $current=$iv_ruleImport.current; } 
	 EOF 
;

// Rule Import
ruleImport returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='import' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
	    }
		lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getImportRule());
	        }
       		set(
       			$current, 
       			"importedNamespace",
        		lv_importedNamespace_1_0, 
        		"QualifiedNameWithWildCard");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleValidID
entryRuleValidID returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getValidIDRule()); } 
	 iv_ruleValidID=ruleValidID 
	 { $current=$iv_ruleValidID.current.getText(); }  
	 EOF 
;

// Rule ValidID
ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); } 
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current.getText(); }  
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
    }
    this_ValidID_0=ruleValidID    {
		$current.merge(this_ValidID_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }
(((
	'.' 
)=>
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
    }
)
    { 
        newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
    }
    this_ValidID_2=ruleValidID    {
		$current.merge(this_ValidID_2);
    }

    { 
        afterParserOrEnumRuleCall();
    }
)*)
    ;





// Entry rule entryRuleQualifiedNameWithWildCard
entryRuleQualifiedNameWithWildCard returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); } 
	 iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard 
	 { $current=$iv_ruleQualifiedNameWithWildCard.current.getText(); }  
	 EOF 
;

// Rule QualifiedNameWithWildCard
ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
    }
    this_QualifiedName_0=ruleQualifiedName    {
		$current.merge(this_QualifiedName_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
    }

	kw='*' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_1_1()); 
    }
)?)
    ;





// Entry rule entryRulePackageDeclaration
entryRulePackageDeclaration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPackageDeclarationRule()); }
	 iv_rulePackageDeclaration=rulePackageDeclaration 
	 { $current=$iv_rulePackageDeclaration.current; } 
	 EOF 
;

// Rule PackageDeclaration
rulePackageDeclaration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='package' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getRuleCSSRuleSetParserRuleCall_3_0()); 
	    }
		lv_rule_3_0=ruleCSSRuleSet		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
	        }
       		set(
       			$current, 
       			"rule",
        		lv_rule_3_0, 
        		"CSSRuleSet");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_4='}' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4());
    }
)
;





// Entry rule entryRuleCSSRuleSet
entryRuleCSSRuleSet returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCSSRuleSetRule()); }
	 iv_ruleCSSRuleSet=ruleCSSRuleSet 
	 { $current=$iv_ruleCSSRuleSet.current; } 
	 EOF 
;

// Rule CSSRuleSet
ruleCSSRuleSet returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getCSSRuleSetAccess().getRulesCSSRuleAssignmentParserRuleCall_0()); 
	    }
		lv_rules_0_0=ruleCSSRuleAssignment		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCSSRuleSetRule());
	        }
       		add(
       			$current, 
       			"rules",
        		lv_rules_0_0, 
        		"CSSRuleAssignment");
	        afterParserOrEnumRuleCall();
	    }

)
)+
;





// Entry rule entryRuleCSSRuleId
entryRuleCSSRuleId returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCSSRuleIdRule()); }
	 iv_ruleCSSRuleId=ruleCSSRuleId 
	 { $current=$iv_ruleCSSRuleId.current; } 
	 EOF 
;

// Rule CSSRuleId
ruleCSSRuleId returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getCSSRuleIdAccess().getNameIDTerminalRuleCall_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCSSRuleIdRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)
;





// Entry rule entryRuleCSSRuleRef
entryRuleCSSRuleRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCSSRuleRefRule()); }
	 iv_ruleCSSRuleRef=ruleCSSRuleRef 
	 { $current=$iv_ruleCSSRuleRef.current; } 
	 EOF 
;

// Rule CSSRuleRef
ruleCSSRuleRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='<' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getCSSRuleRefAccess().getLessThanSignKeyword_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getCSSRuleRefRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getCSSRuleRefAccess().getRefCSSRuleIdCrossReference_1_0()); 
	}

)
)	otherlv_2='>' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getCSSRuleRefAccess().getGreaterThanSignKeyword_2());
    }
)
;





// Entry rule entryRuleCSSRuleAssignment
entryRuleCSSRuleAssignment returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCSSRuleAssignmentRule()); }
	 iv_ruleCSSRuleAssignment=ruleCSSRuleAssignment 
	 { $current=$iv_ruleCSSRuleAssignment.current; } 
	 EOF 
;

// Rule CSSRuleAssignment
ruleCSSRuleAssignment returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getCSSRuleAssignmentAccess().getCSSRuleAssignmentAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getCSSRuleAssignmentAccess().getIdCSSRuleIdParserRuleCall_1_0()); 
	    }
		lv_id_1_0=ruleCSSRuleId		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCSSRuleAssignmentRule());
	        }
       		set(
       			$current, 
       			"id",
        		lv_id_1_0, 
        		"CSSRuleId");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='=' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getCSSRuleAssignmentAccess().getEqualsSignKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCSSRuleAssignmentAccess().getRCSSRuleOrExpressionParserRuleCall_3_0()); 
	    }
		lv_r_3_0=ruleCSSRuleOrExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCSSRuleAssignmentRule());
	        }
       		set(
       			$current, 
       			"r",
        		lv_r_3_0, 
        		"CSSRuleOrExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4=';' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getCSSRuleAssignmentAccess().getSemicolonKeyword_4());
    }
)
;





// Entry rule entryRuleCSSRuleOrExpression
entryRuleCSSRuleOrExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCSSRuleOrExpressionRule()); }
	 iv_ruleCSSRuleOrExpression=ruleCSSRuleOrExpression 
	 { $current=$iv_ruleCSSRuleOrExpression.current; } 
	 EOF 
;

// Rule CSSRuleOrExpression
ruleCSSRuleOrExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getCSSRuleOrExpressionAccess().getOrsCSSRuleXorExpressionParserRuleCall_0_0()); 
	    }
		lv_ors_0_0=ruleCSSRuleXorExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCSSRuleOrExpressionRule());
	        }
       		add(
       			$current, 
       			"ors",
        		lv_ors_0_0, 
        		"CSSRuleXorExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='|' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getCSSRuleOrExpressionAccess().getVerticalLineKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCSSRuleOrExpressionAccess().getOrsCSSRuleXorExpressionParserRuleCall_1_1_0()); 
	    }
		lv_ors_2_0=ruleCSSRuleXorExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCSSRuleOrExpressionRule());
	        }
       		add(
       			$current, 
       			"ors",
        		lv_ors_2_0, 
        		"CSSRuleXorExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleCSSRuleXorExpression
entryRuleCSSRuleXorExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCSSRuleXorExpressionRule()); }
	 iv_ruleCSSRuleXorExpression=ruleCSSRuleXorExpression 
	 { $current=$iv_ruleCSSRuleXorExpression.current; } 
	 EOF 
;

// Rule CSSRuleXorExpression
ruleCSSRuleXorExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getCSSRuleXorExpressionAccess().getXorsCSSRulePostfixExpressionParserRuleCall_0_0()); 
	    }
		lv_xors_0_0=ruleCSSRulePostfixExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCSSRuleXorExpressionRule());
	        }
       		add(
       			$current, 
       			"xors",
        		lv_xors_0_0, 
        		"CSSRulePostfixExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='||' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getCSSRuleXorExpressionAccess().getVerticalLineVerticalLineKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCSSRuleXorExpressionAccess().getXorsCSSRulePostfixExpressionParserRuleCall_1_1_0()); 
	    }
		lv_xors_2_0=ruleCSSRulePostfixExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCSSRuleXorExpressionRule());
	        }
       		add(
       			$current, 
       			"xors",
        		lv_xors_2_0, 
        		"CSSRulePostfixExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleCSSRuleBracketExpression
entryRuleCSSRuleBracketExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCSSRuleBracketExpressionRule()); }
	 iv_ruleCSSRuleBracketExpression=ruleCSSRuleBracketExpression 
	 { $current=$iv_ruleCSSRuleBracketExpression.current; } 
	 EOF 
;

// Rule CSSRuleBracketExpression
ruleCSSRuleBracketExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='[' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getCSSRuleBracketExpressionAccess().getLeftSquareBracketKeyword_0());
    }

    { 
        newCompositeNode(grammarAccess.getCSSRuleBracketExpressionAccess().getCSSRuleOrExpressionParserRuleCall_1()); 
    }
    this_CSSRuleOrExpression_1=ruleCSSRuleOrExpression
    { 
        $current = $this_CSSRuleOrExpression_1.current; 
        afterParserOrEnumRuleCall();
    }
	otherlv_2=']' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getCSSRuleBracketExpressionAccess().getRightSquareBracketKeyword_2());
    }
)
;





// Entry rule entryRuleCSSRulePostfixExpression
entryRuleCSSRulePostfixExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCSSRulePostfixExpressionRule()); }
	 iv_ruleCSSRulePostfixExpression=ruleCSSRulePostfixExpression 
	 { $current=$iv_ruleCSSRulePostfixExpression.current; } 
	 EOF 
;

// Rule CSSRulePostfixExpression
ruleCSSRulePostfixExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getCSSRulePostfixExpressionAccess().getCSSRuleConcatParserRuleCall_0()); 
    }
    this_CSSRuleConcat_0=ruleCSSRuleConcat
    { 
        $current = $this_CSSRuleConcat_0.current; 
        afterParserOrEnumRuleCall();
    }
(
(
(
		lv_c_1_1=	'*' 
    {
        newLeafNode(lv_c_1_1, grammarAccess.getCSSRulePostfixExpressionAccess().getCAsteriskKeyword_1_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCSSRulePostfixExpressionRule());
	        }
       		setWithLastConsumed($current, "c", lv_c_1_1, null);
	    }

    |		lv_c_1_2=	'+' 
    {
        newLeafNode(lv_c_1_2, grammarAccess.getCSSRulePostfixExpressionAccess().getCPlusSignKeyword_1_0_1());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCSSRulePostfixExpressionRule());
	        }
       		setWithLastConsumed($current, "c", lv_c_1_2, null);
	    }

    |		lv_c_1_3=	'?' 
    {
        newLeafNode(lv_c_1_3, grammarAccess.getCSSRulePostfixExpressionAccess().getCQuestionMarkKeyword_1_0_2());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCSSRulePostfixExpressionRule());
	        }
       		setWithLastConsumed($current, "c", lv_c_1_3, null);
	    }

)

)
)?)
;





// Entry rule entryRuleCSSRuleConcat
entryRuleCSSRuleConcat returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCSSRuleConcatRule()); }
	 iv_ruleCSSRuleConcat=ruleCSSRuleConcat 
	 { $current=$iv_ruleCSSRuleConcat.current; } 
	 EOF 
;

// Rule CSSRuleConcat
ruleCSSRuleConcat returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getCSSRuleConcatAccess().getConcCSSRulePrimaryExpressionParserRuleCall_0_0()); 
	    }
		lv_conc_0_0=ruleCSSRulePrimaryExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCSSRuleConcatRule());
	        }
       		add(
       			$current, 
       			"conc",
        		lv_conc_0_0, 
        		"CSSRulePrimaryExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getCSSRuleConcatAccess().getConcCSSRulePrimaryExpressionParserRuleCall_1_0()); 
	    }
		lv_conc_1_0=ruleCSSRulePrimaryExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCSSRuleConcatRule());
	        }
       		add(
       			$current, 
       			"conc",
        		lv_conc_1_0, 
        		"CSSRulePrimaryExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleCSSRuleLiteral
entryRuleCSSRuleLiteral returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getCSSRuleLiteralRule()); } 
	 iv_ruleCSSRuleLiteral=ruleCSSRuleLiteral 
	 { $current=$iv_ruleCSSRuleLiteral.current.getText(); }  
	 EOF 
;

// Rule CSSRuleLiteral
ruleCSSRuleLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getCSSRuleLiteralAccess().getIDTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleCSSRulePrimaryExpression
entryRuleCSSRulePrimaryExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCSSRulePrimaryExpressionRule()); }
	 iv_ruleCSSRulePrimaryExpression=ruleCSSRulePrimaryExpression 
	 { $current=$iv_ruleCSSRulePrimaryExpression.current; } 
	 EOF 
;

// Rule CSSRulePrimaryExpression
ruleCSSRulePrimaryExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getCSSRulePrimaryExpressionAccess().getCSSRuleRefParserRuleCall_0()); 
    }
    this_CSSRuleRef_0=ruleCSSRuleRef
    { 
        $current = $this_CSSRuleRef_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getCSSRulePrimaryExpressionAccess().getCSSRuleBracketExpressionParserRuleCall_1()); 
    }
    this_CSSRuleBracketExpression_1=ruleCSSRuleBracketExpression
    { 
        $current = $this_CSSRuleBracketExpression_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getCSSRulePrimaryExpressionAccess().getCSSRuleLiteralParserRuleCall_2()); 
    }
ruleCSSRuleLiteral
    { 
        afterParserOrEnumRuleCall();
    }
)
;





RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;

