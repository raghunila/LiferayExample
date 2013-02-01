

<script type="text/javascript"
src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page  import="java.util.List"
         import="com.liferay.portal.kernel.util.UnicodeFormatter"
         import="javax.portlet.PortletPreferences"
         import="com.liferay.portlet.PortletPreferencesFactoryUtil"
         import="com.liferay.portal.kernel.util.ParamUtil"
         import="com.liferay.portal.kernel.util.StringPool"
         import="com.liferay.portal.kernel.workflow.WorkflowConstants"
         %>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
    boolean book_name = false;
    boolean book_author = false;
    boolean book_isbn = false;
    boolean book_summary = false;
    if (renderRequest != null) {
        PortletPreferences portalPreferences = null;
        portalPreferences = renderRequest.getPreferences();
        String portletResource = ParamUtil.getString(request, "portletResource");
        if (Validator.isNotNull(portletResource)) {
            portalPreferences = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
        }
        book_name = portalPreferences.getValue("book_name", StringPool.BLANK) != null && portalPreferences.getValue("book_name", StringPool.BLANK).equals("true") ? true : false;
        book_author = portalPreferences.getValue("book_author", StringPool.BLANK) != null && portalPreferences.getValue("book_author", StringPool.BLANK).equals("true") ? true : false;
        book_isbn = portalPreferences.getValue("book_isbn", StringPool.BLANK) != null && portalPreferences.getValue("book_isbn", StringPool.BLANK).equals("true") ? true : false;
        book_summary = portalPreferences.getValue("book_summary", StringPool.BLANK) != null && portalPreferences.getValue("book_summary", StringPool.BLANK).equals("true") ? true : false;
    }
%>