<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<jsp:useBean class="java.lang.String" id="addNameURL" scope="request" />

<portlet:defineObjects />
<portlet:actionURL name="welcomePage" var="addBookURL"/>
<form
    id="<portlet:namespace />form"
    action="<%= addBookURL.toString()%>"
    method="post">
    <table>
        <tr>
            <td>Welcome Message</td>
            <td><input type="text" name="message"></td>
        </tr>
    </table>
    <input type="submit" id="nameButton" title="Add Name" value="Submit">
</form>