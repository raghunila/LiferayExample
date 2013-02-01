<%-- 
    Document   : configuration
    Created on : Jan 17, 2013, 1:54:25 PM
    Author     : rnila
--%>

<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@include file="/init.jsp" %>

<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm"> <input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" /> 
    <aui:input name="<%= Constants.CMD%>" type="hidden" value="<%= Constants.UPDATE%>" />    
    <aui:input type="checkbox" name="book_name" label="Name" value="<%=book_name%>"> </aui:input>
    <aui:input type="checkbox" name="book_author" label="Author" value="<%=book_author%>"> </aui:input>
    <aui:input type="checkbox" name="book_isbn" label="ISBN" value="<%=book_isbn%>"> </aui:input>
    <aui:input type="checkbox" name="book_summary" label="Summary" value="<%=book_summary%>"> </aui:input>
    <input type="button" value="Save" onClick="submitForm(document.<portlet:namespace/>fm);">
</form>