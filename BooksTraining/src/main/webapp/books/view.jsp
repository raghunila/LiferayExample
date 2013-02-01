<%@include file="/init.jsp" %>
<portlet:resourceURL var="testURL"  escapeXml="false" />

<script type="text/javascript">
    function <portlet:namespace/>Test(message) {
	    var querystring = 'message=' + message; 
    jQuery.ajax({
    type: "POST",
    url: "<%=renderResponse.encodeURL(testURL.toString())%>",
    data: querystring,
    success: function(msg) {
        var div = document.getElementById("<portlet:namespace/>content");
        div.innerHTML = "";
        div.innerHTML = msg;
        }
    });
}
    function <portlet:namespace/>Delete(message) {
	    var querystring = 'message=' + message; 
    jQuery.ajax({
    type: "POST",
    url: "<%=renderResponse.encodeURL(testURL.toString())%>",
    data: querystring,
    success: function(msg) {
        var div = document.getElementById("<portlet:namespace/>content");
        $('#<portlet:namespace/>'+message +"row").remove();
        div.innerHTML = "";
        div.innerHTML = msg;
        }
    });
}
</script>
<div id="<portlet:namespace/>content">
</div>
<%
    java.util.List<Book> books = (List<Book>) request.getAttribute("books");

%>
<portlet:actionURL name="gotoAddBook" var="addBookURL"/>
<portlet:actionURL name="callInterPorltet" var="callInterPorltetURL"></portlet:actionURL>
<aui:form name="fm" action="<%=callInterPorltetURL.toString()%>" method="post">
<table>
    <tr>
        <td>Enter ISBNumber</td>
        <td><input name="isbn" type="text" size="50"/> </td>
        <td></td>
        
        <td><input name="submit" value="Submit" type="submit"></td>
    </tr>
</table>
</aui:form>



<div id="number_filters"> 
    <form name="bookform" id="bookform">

        <span id="userData">
            <c:if test="${not empty books}">
                <table border="1" id="tb">
                    <tr bgcolor="#99CCFF" id="121212">
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
                    <c:forEach var="book" items="${books}" varStatus="status">
                        <tr id="<portlet:namespace/>${book.isbnNumber}row" >
                            <% if (!book_name) {
                            %>
                            <td valign="top">
                                <portlet:actionURL name="getBook" var="getBookURL">
                                    <portlet:param name="isbn" value="${book.isbnNumber}"></portlet:param>
                                </portlet:actionURL>
                                <a href="${getBookURL.toString()}"><c:out value="${book.name}" /></a>
                            </td>
                            <%    }%>
                            <% if (!book_author) {
                            %>
                            <td valign="top"><c:out value="${book.author}" /></td>
                            <%    }%>
                            <% if (!book_isbn) {
                            %>
                            <td valign="top"><c:out value="${book.isbnNumber}" /></td>
                            <%    }%>
                            <% if (!book_summary) {
                            %> 
                            <td valign="top"><c:out value="${book.summary}" escapeXml="false" /></td>
                            <%    }%>
                            <td valign="top">
                                <input type="button" value = "Delete" onClick="<portlet:namespace/>Delete('${book.isbnNumber}');return false;">
                             </td>
                            </tr>
                    </c:forEach>
                </table>

            </c:if> 
        </span>  
    </form>
    <aui:form name="fm" action="<%=addBookURL.toString()%>" method="post">
        <aui:button type="submit" value="addBook" name="saveRegistration" />
    </aui:form>
</div>

<jsp:useBean id="username" scope="request" class="java.lang.String"></jsp:useBean>
<c:out value="${username}"></c:out>