<%@include  file="/init.jsp" %>
<portlet:resourceURL var="ajaxRemove" id="ajaxRemove" escapeXml="false" />

<script type="text/javascript">
    function <portlet:namespace/>Delete(message) {
        var querystring = 'isbn=' + message; 
        jQuery.ajax({
            type: "POST",
            url: "<%=ajaxRemove%>",
            data: querystring,
            success: function(msg) {
                $('#<portlet:namespace/>'+message +"row").remove();
            }
        });
    }

</script>

<portlet:renderURL var="showAddBookUrl">
    <portlet:param name="myAction" value="addBookForm" />
</portlet:renderURL>
<portlet:renderURL var="showUrl">
</portlet:renderURL>
<form:form name="catalogForm" method="post" action="${showAddBookUrl}">
    <c:if test="${not empty books}">
        <table border="1">
            <tr bgcolor="#99CCFF">
                <% if (!book_name) {
                %>
                <td valign="top"><b>Name</b></td>
                <%                }%>
                <% if (!book_author) {
                %>
                <td valign="top"><b>Author</b></td>
                <%                }%>
                <% if (!book_isbn) {
                %>
                <td valign="top"><b>ISBN Number</b></td>
                <%                }%>
                <% if (!book_summary) {
                %>           
                <td valign="top"><b>Summary</b></td>
                <%                }%>
                <td valign="top"><b></b></td>
            </tr>
            <c:forEach var="book" items="${books}">
                <c:choose>
                    <c:when test="${book.status == 0}">
                        <tr id="<portlet:namespace/>${book.id}row">
                            <% if (!book_name) {
                            %>
                            <td valign="top">
                                <a href="<portlet:renderURL>
                                       <portlet:param name="myAction" value="viewBook" />
                                       <portlet:param name="isbn" value="${book.id}" />
                                   </portlet:renderURL>">
                                    <c:out value="${book.name}" />
                                </a>
                            </td>
                            <%    }%>
                            <% if (!book_author) {
                            %>
                            <td valign="top"><c:out value="${book.author}" /></td>
                            <%    }%>
                            <% if (!book_isbn) {
                            %>
                            <td valign="top"><c:out value="${book.isbn}" /></td>
                            <%    }%>
                            <% if (!book_summary) {
                            %> 
                            <td valign="top"><c:out value="${book.summary}" escapeXml="false" /></td>
                            <%    }
                                if (!book_name || !book_author || !book_isbn || !book_summary) {
                            %>
                            <td valign="top">
                                <a
                                    href="
                                    <portlet:renderURL>
                                        <portlet:param name="myAction" value="editBookForm" />
                                        <portlet:param name="isbn" value="${book.id}" />
                                    </portlet:renderURL>					
                                    "><b>Edit</b>
                                    /
                                    <a  href="#" onclick="<portlet:namespace/>Delete('${book.id}');return false;">Remove</a>
                            </td>
                            <% }%>
                            </a>
                            </td>
                        </tr>
                    </c:when>
                </c:choose>
            </c:forEach>
        </table>
    </c:if>
    <br></br>
    <table align="right">
        <tr>
            <td><input type="submit" value="Add Book" /></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
    </table>
</form:form>
<br></br>
<jsp:useBean id="message" scope="request" class="java.lang.String"></jsp:useBean>
<c:out value="${message}"></c:out>

