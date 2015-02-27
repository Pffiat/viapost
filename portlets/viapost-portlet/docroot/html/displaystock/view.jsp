<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.viapost.stock.model.Product" %>
<%@ page import="com.viapost.stock.service.ProductLocalServiceUtil" %>

<portlet:defineObjects />


<table class="table table-striped">
	<thead>
		<tr>
			<th>Produit</th>
			<th>Stock</th>
			<th>Seuil stock</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="produit" items="${produits }">
		<tr>
			<td> <a class="produit" href="#" data-ref="${produit.getArticleNumber() }"> ${produit.getArticleNumber() } </a></td>
			<td> ${produit.getStock() }</td>
			<td> ${produit.getSeuil_stock() }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<div id="demandePopup" hidden="true">
	
	<portlet:actionURL name="validationUserDemande" var="validationUserDemandeUrl">
	</portlet:actionURL>	
	<aui:form action="${validationUserDemandeUrl}" name="fm_validationUserDemande">
		<aui:fieldset>
			<aui:input id="produitInput" name="produit" type="hidden" value=""></aui:input>
			<aui:input id="questionInput" name="question" type="hidden"></aui:input>
				
			<aui:select id="selectDemandeId" name="workflowDefinition" label="Demande:">	
				<aui:option>Choisir une demande</aui:option>
				<c:forEach var="demande" items="${demandeDTOs}">
					<aui:option value="Single Approver@1">${demande.getQuestion()} </aui:option>
				</c:forEach>		
			</aui:select>
	
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Voici les étapes de votre demande:</th>
					</tr>
				</thead>
				<tbody>		
					<c:forEach var="demande" items="${demandeDTOs}">
						<c:forEach var="line" items="${demande.getEtapes() }">
							<tr class="demandeTr" name="${demande.getQuestion() }" style="display:none;">
								<td> ${line }</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
			
			<aui:button type="submit" value="Valider demande"></aui:button>
		</aui:fieldset>
	</aui:form>
</div>

<script type="text/javascript">
	AUI().use('aui-modal', 'aui-base', 'event', function(A) {
 		var modal = new A.Modal({
			bodyContent : A.one("#demandePopup").html(),
			centered : true,
			headerContent : '<h3>Demande inventaire</h3>',
			modal : true,
			resizable : false,
			visible : false,
			zIndex : 100,
		}).render(); 
		
		//Remove the form template (no duplication otherwise it will never validate the pop-up)
		A.one("#demandePopup").empty();
	
		A.all('.produit').each(function() {
			this.on('click', function(event) {
				
				modal.show();
				document.getElementById("_displaystock_WAR_viapostportlet_produitInput").value = this.getData('ref');
				
			});
			
		});
		 

		A.one('#_displaystock_WAR_viapostportlet_selectDemandeId').on('change', function(A) {
			
			var lines = document.getElementsByClassName('demandeTr'); 
			for(var index = 0; index<lines.length; index++) {
				lines[index].style.display = 'none';
			}
			
			var selected = document.getElementById('_displaystock_WAR_viapostportlet_selectDemandeId').value;
			console.log(selected);
			
			var linesTr = document.getElementsByName(selected );
			for(var index = 0; index<linesTr.length; index++) {	
				console.log(linesTr[index]);
				linesTr[index].style.display = 'table-row';
			}
			
			document.getElementById("_displaystock_WAR_viapostportlet_questionInput").value = selected;
		});
	});
	
</script>




