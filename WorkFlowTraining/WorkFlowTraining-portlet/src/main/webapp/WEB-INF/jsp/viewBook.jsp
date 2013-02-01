<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.xtivia.training.servicebuilder.model.Book"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page  import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%
String currentURL = PortalUtil.getCurrentURL(request);
%>
<portlet:renderURL var="homeUrl">
    <portlet:param name="myaction" value="books" />
</portlet:renderURL>
<table>
    <tr align="left">
        <td>
            <a href="${homeUrl}">Home</a>
        </td>
    </tr>
</table>
<table>
    <tr>
        <td>Title:<font style="color: #C11B17;">*</font></td>
        <td><c:out value="${book.name}"></c:out></td>
    </tr>
    <tr>
        <td>Author:<font style="color: #C11B17;">*</font></td>
        <td><c:out value="${book.author}"></c:out> </td>
    </tr>
    <tr>
        <td>ISBN:<font style="color: #C11B17;">*</font></td>
        <td><c:out value="${isbn}"></c:out></td>
    </tr>
    <tr>
        <td>Summary<font style="color: #C11B17;">*</font></td>
        <td><c:out value="${book_summary}"></c:out></td>
    </tr>
</table>
<br></br>

<liferay-ui:ratings className="<%= Book.class.getName() %>"
                    classPK="${book.id}" type="stars" />

<liferay-ui:panel-container extended="<%= false %>"
    id="sloganCommentsPanelContainer" persistState="<%= true %>">

  <liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
      id="sloganCommentsPanel" persistState="<%= true %>"
      title='<%= LanguageUtil.get(pageContext, "comments") %>'>

    <portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL">
        <portlet:param name="myAction" value="invokeTaglibDiscussion"></portlet:param>
    </portlet:actionURL>
    
    <liferay-ui:discussion className="<%= Book.class.getName() %>"
        classPK="${book.id}"
        formAction="<%= discussionURL %>" formName="fm2"
        ratingsEnabled="<%= true %>" redirect="<%= currentURL %>"
        subject="${book.name}"
        userId="${book.userId}" />
  </liferay-ui:panel>

</liferay-ui:panel-container>