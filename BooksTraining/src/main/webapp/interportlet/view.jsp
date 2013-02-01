<%-- 
    Document   : book
    Created on : Jan 17, 2013, 10:36:21 AM
    Author     : rnila
--%>


<%-- 
    Document   : add
    Created on : Jan 16, 2013, 4:27:03 PM
    Author     : rnila
--%>
<%@include file="/init.jsp" %>
<table border="1">
    <% if (!book_name) {
    %>
    <tr>
        <td bgcolor="#99CCFF"><b>Name:</b><font style="color: #C11B17;">*</font></td>
        <td><c:out value="${book.name}"/>
        </td>
    </tr>
    <%                }%>
    <% if (!book_author) {
    %>
    <tr>
        <td bgcolor="#99CCFF" ><b>Author:</b><font style="color: #C11B17;">*</font></td>
        <td><c:out value="${book.author}"/>
        </td>
    </tr>
    <%                }%>
    <% if (!book_isbn) {
    %>
    <tr>
        <td bgcolor="#99CCFF"><b>ISBN:</b><font style="color: #C11B17;">*</font></td>
        <td><c:out value="${book.isbnNumber}"/>
        </td>
    </tr>
    <%                }%>
    <% if (!book_summary) {
    %>
    <tr>
        <td bgcolor="#99CCFF"><b>Summary:</b><font style="color: #C11B17;">*</font></td>
        <td><c:out value="${book.summary}" escapeXml="false" ></c:out>
            </td>
        </tr>
    <%}%>
</table>
