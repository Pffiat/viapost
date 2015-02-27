<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<portlet:defineObjects />

	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Origine</th>
				<th>Date</th>
				<th>Demande</th>
				<th>Etat</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="uDemande" items="${userDemandes }">
			<tr>
				<td>STOCK</td>
				<td>${uDemande.getDate() }</td>
				<td>${uDemande.getDemandeId() } pour l'article ${uDemande.getArticle() } </td>
				<td>${uDemande.getStatus() }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>