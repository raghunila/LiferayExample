<%-- 
    Document   : add
    Created on : Jan 16, 2013, 4:27:03 PM
    Author     : rnila
--%>
<%@include file="/init.jsp" %>



<jsp:useBean
    id="book"
    type="com.xtivia.training.entities.Book"
    scope="request" />
<portlet:actionURL name="addBook" var="addBookURL"/>
<portlet:actionURL name="editBookAction" var="editBookURL">
    <portlet:param name="isbn" value="${book.isbnNumber}"></portlet:param>
</portlet:actionURL>
<jsp:useBean
    id="edit"
    type="java.lang.String"
    scope="request" />
<%
    String url = "";
    String submit = "";
    System.out.println(edit);
    if (edit != null && edit.equals("edit")) {
        url = editBookURL.toString();
        submit = "Save";
    } else {
        url = addBookURL.toString();
        submit = "Add";
    }
    System.out.println(submit);
    System.out.println(url);

%>
<aui:form name="fm" action="<%=url%>" method="post">
    <table border="1">
        <tr>
            <td bgcolor="#99CCFF" ><b>Name:</b><font style="color: #C11B17;">*</font></td>
            <td>
                <aui:input     type="text"
                value="<%= book.getName()%>"
                    size="25"
                    name="name"/>
                <liferay-ui:error
                    key="bookname-required"
                    message="bookname-required" />
            </td>
        </tr>
        <tr>
            <td bgcolor="#99CCFF" ><b>Author:</b><font style="color: #C11B17;">*</font></td>
            <td><aui:input
                    type="text"
                value="<%= book.getIsbnNumber()%>"
                    size="25"
                    name="isbnNumber"/>
                <liferay-ui:error
                    key="isbnnumber-required"
                    message="isbnnumber-required" />
            </td>
        </tr>
        <tr>
            <td bgcolor="#99CCFF"><b>ISBN:</b><font style="color: #C11B17;">*</font></td>
            <td>
                <aui:input
                    type="text"
                value="<%= book.getAuthor()%>"
                    size="25" 
                    name="author"
                    />
                <liferay-ui:error
                    key="author-required"
                    message="author-required" />

            </td>
        </tr>
        <tr>
            <td bgcolor="#99CCFF" ><b>Summary:</b><font style="color: #C11B17;">*</font></td>
            <td><aui:field-wrapper>
                    <liferay-ui:input-editor initMethod="initEditor" name="summary" />
                    <script type="text/javascript">
                    function <portlet:namespace />initEditor() {
                        return "<%=UnicodeFormatter.toString(book.getSummary())%>";
                    }
                    </script>
                </aui:field-wrapper>
                <input name="<portlet:namespace />" type="hidden" /> 
                <liferay-ui:error
                    key="summary-required"
                    message="summary-required" />
            </td>
        </tr>
        <tr align="center">
            <td/>
            <td colspan="2"><input type="Submit" value="<%=submit%>" /></td>
        </tr>
    </table>
</aui:form>
