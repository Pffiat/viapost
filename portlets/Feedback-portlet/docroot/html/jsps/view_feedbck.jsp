<%@page import="com.meera.db.service.FeedbackLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.meera.db.model.Feedback"%>
<%@ include file="init.jsp"%>
<%
long feedbackId=ParamUtil.getLong(request,"assetEntryVersionId");
Feedback feedback=null;
if(feedbackId>0){
 feedback=FeedbackLocalServiceUtil.getFeedback(feedbackId);
}
%>
<c:if test='<%=feedback!=null%>'>
<h2><%=feedback.getFeedbackSubject()%></h2>
<br/>

<div>
<%=feedback.getFeedbackText()%>
</div>
</c:if>