<%@include file="/init.jsp" %>
<%@page import="com.xtivia.training.data.BookAddedEvent"%>
<table border="1" width="200px">
    <tr>
        <td bgcolor="#99CCFF"><b>Book name: </b></td>
        <td><%=renderRequest.getParameter("name")%></td>
    </tr>
    <tr>
        <td bgcolor="#99CCFF"><b>Book author: </b></td>
        <td><%=renderRequest.getParameter("author")%></td>
    </tr>
    <tr>
        <td bgcolor="#99CCFF"><b>Book ISBN</b></td>
        <td><%=renderRequest.getParameter("isbnNumber")%></td>
    </tr>
    <tr>
        <td bgcolor="#99CCFF"><b>Book Summary</b></td>
        <td><%=renderRequest.getParameter("summary")%></td>
    </tr>
</table>