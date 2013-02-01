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
<portlet:actionURL var="editBookActionUrl">
    <portlet:param name="myaction" value="editBook" />
</portlet:actionURL>
<portlet:renderURL var="homeUrl">
    <portlet:param name="myaction" value="books" />
</portlet:renderURL>
<form:form name="editBookForm" commandName="book" method="post"
           action="${editBookActionUrl}">
    <table>
        <tr align="left">
            <td>
                <a href="${homeUrl}">Home</a>
            </td>
        </tr>
    </table>
    <table>
        <form:hidden path="id"></form:hidden>
        <tr>
            <td>Title:<font style="color: #C11B17;">*</font></td>
            <td><form:input path="name" /></td>
            <td><font style="color: #C11B17;"><form:errors
                    path="name" /></font></td>
        </tr>
        <tr>
            <td>Author:<font style="color: #C11B17;">*</font></td>
            <td><form:input path="author" /></td>
            <td><font style="color: #C11B17;"><form:errors
                    path="author" /></font></td>
        </tr>
        <tr>
            <td>ISBN:<font style="color: #C11B17;">*</font></td>
            <td><form:input path="isbn" readonly="true"/></td>
            <td><font style="color: #C11B17;"><form:errors
                    path="isbn" /></font></td>
        </tr>
        <tr>
                <td>Summary<font style="color: #C11B17;">*</font></td>
                <c:set var="book_summary" value="${book.summary}"/>
            <td>
        <aui:field-wrapper>
            <liferay-ui:input-editor initMethod="initEditor" name="summary"/>
            <script type="text/javascript">
                function <portlet:namespace />initEditor() {
                    return "<%=UnicodeFormatter.toString((String)pageContext.getAttribute("book_summary"))%>";
                }
            </script>
        </aui:field-wrapper>
        <input name="<portlet:namespace />" type="hidden" />
    </td>
    <td><font style="color: #C11B17;"><form:errors
            path="summary" /></font></td>
    <td><font style="color: #C11B17;"><form:errors
            path="isbn" /></font></td>
</tr>
</table>
<table align="right">
    <tr>
        <td><input type="submit" value="Update Book" /></td>
    </tr>
    <tr>
        <td>&nbsp;</td>
    </tr>
</table>
</form:form>
<br></br>