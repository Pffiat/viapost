<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ include file="init.jsp"%>
<portlet:actionURL var="submitFeedBack" windowState="<%=LiferayWindowState.NORMAL.toString()%>" name="submitFeedback">
</portlet:actionURL>
<h1>Feedback</h1>
<fieldset>
    <legend>Mail Form</legend>
<c:if test='<%= SessionMessages.contains(renderRequest.getPortletSession(),"feedback-send-success")%>'>
<liferay-ui:success key="feedback-send-success" message="Feedback has been submited successfully." />
</c:if>
<aui:form action="<%=submitFeedBack%>" method="post" name="feedbackForm">
<aui:layout>
		<aui:column>
			<aui:input 	label="Feedback Subject" name="feedbackSubject" id="feedbackSubject" type="text" style="width:600px;height:20px;"/>
		</aui:column>
</aui:layout>
<aui:layout>
		<aui:column>
			FeedBack:
		</aui:column>
</aui:layout>
<aui:layout>
		<aui:column>
			<liferay-ui:input-editor >
			</liferay-ui:input-editor>
		</aui:column>
</aui:layout>
<aui:layout>
		<aui:column>
			&nbsp;
		</aui:column>
</aui:layout>
<aui:layout>
		<aui:column>
			<aui:button type="submit" value="Send Mail" name="submit"
				></aui:button>
		</aui:column>
</aui:layout>
</aui:form>
</fieldset>

