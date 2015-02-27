<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<portlet:defineObjects />


<portlet:actionURL name="addDemande" var="addDemandeUrl">
	<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:actionURL>

<aui:form action="${addDemandeUrl }" name="fm_creationDemande"> 

	<aui:fieldset>
		<aui:input id="numberOfStep" name="numberOfStep" value="1" type="hidden"/>
		<aui:input style="width:80%;" name="demande" label="Demande:"></aui:input>	
		<aui:input style="width:80%;" name="question" label="Question:"></aui:input>		
		
		<aui:input style="width:80%;" name="etape1" label="Etape1:"></aui:input>
		<div id="toComplete1"></div>
		
		<aui:button id="ajoutEtape" value="Ajouter une étape" ></aui:button>
		
		<aui:button type="submit" value="Créer"></aui:button>
    </aui:fieldset>
</aui:form>

<script type="text/javascript">
	AUI().use('aui-base','event','aui-modal', function(A) {
		A.one("#ajoutEtape").on('click', function () {
			var currentEtape = document.getElementById("_createdemande_WAR_viapostportlet_numberOfStep").value;
			
			var currentElementId = 'toComplete'+currentEtape;
			
			currentEtape++;
			document.getElementById('_createdemande_WAR_viapostportlet_numberOfStep').value = currentEtape;
			
			document.getElementById(currentElementId).innerHTML += '<label class="control-label">Etape' + currentEtape 
			+ ':</label> <input style="width:80%;" type="text" style="margin-bottom:30px;" name="_createdemande_WAR_viapostportlet_etape' + currentEtape + '"></input></br> <div id="toComplete' + currentEtape + '"></div>  ';
			
		});
	});
</script>
