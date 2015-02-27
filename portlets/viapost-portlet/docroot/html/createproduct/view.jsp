<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />


<portlet:actionURL name="addProduct" var="addProductUrl">
</portlet:actionURL>

<portlet:actionURL name="editProduct" var="editProductUrl">
</portlet:actionURL>



<aui:form action="${addProductUrl}" name="fm_createproduct"> 

	<aui:fieldset>
	
	
		<aui:input name="article" label="numéro du produit:" >
 			<aui:validator name="required"></aui:validator>
			<aui:validator name="custom" errorMessage="name-syntaxe">
				function (val, fieldNode, ruleValue) {
					return /^[\d]+$/.test(val);
				}
			</aui:validator>
		</aui:input>
		<aui:input name="stock" label="stock:" >
 			<aui:validator name="required"></aui:validator>
			<aui:validator name="custom" errorMessage="name-syntaxe">
				function (val, fieldNode, ruleValue) {
					return /^[\d]+$/.test(val);
				}
			</aui:validator>
		</aui:input>
		<aui:input name="seuil" label="seuil du stock:" >
 			<aui:validator name="required"></aui:validator>
			<aui:validator name="custom" errorMessage="name-syntaxe">
				function (val, fieldNode, ruleValue) {
					return /^[\d]+$/.test(val);
				}
			</aui:validator>
		</aui:input>
	
		<aui:button type="submit" value="Envoyer"></aui:button>
	</aui:fieldset>
</aui:form>