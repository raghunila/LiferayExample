<%    /**
     * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
     *
     * Permission is hereby granted, free of charge, to any person obtaining a
     * copy of this software and associated documentation files (the
     * "Software"), to deal in the Software without restriction, including
     * without limitation the rights to use, copy, modify, merge, publish,
     * distribute, sublicense, and/or sell copies of the Software, and to permit
     * persons to whom the Software is furnished to do so, subject to the
     * following conditions:
     *
     * The above copyright notice and this permission notice shall be included
     * in all copies or substantial portions of the Software.
     *
     * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
     * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
     * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
     * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
     * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
     * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
     * USE OR OTHER DEALINGS IN THE SOFTWARE.
     */
%>
<%@include file="/init.jsp" %>
<jsp:useBean class="java.lang.String" id="addNameURL" scope="request" />
<%    List<Book> books = null;
    if (renderRequest != null) {
        books = (List<Book>) renderRequest.getAttribute("books");
    } else {
        books = (List<Book>) request.getAttribute("books");
    }
%>
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
            <tr id='<c:out value="${status.count}"></c:out>'>
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
                    <portlet:resourceURL var="ajaxDelete" id="ajaxDelete" escapeXml="false">
                        <portlet:param name="isbn" value="${book.isbnNumber}"></portlet:param>
                    </portlet:resourceURL>
                    <a href="${deleteBookURL.toString()}" id='<c:out value="${status.count}"></c:out>'>Delete</a>
                    </td>
                </tr>
        </c:forEach>
    </table>
</div>
</c:if> 
<br>

