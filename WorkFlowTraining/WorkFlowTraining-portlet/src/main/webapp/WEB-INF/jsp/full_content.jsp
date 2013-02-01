<%--
/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.xtivia.training.servicebuilder.model.Book"%>
<%@include file="/html/init.jsp"%>
<%

String currentURL = PortalUtil.getCurrentURL(request);
Book book = (Book) request.getAttribute("BOOK_ENTRY");
%>

<h1><%= book.getName() %></h1>

<liferay-ui:ratings className="<%= Book.class.getName() %>"
    classPK="<%= book.getId() %>" type="stars" />

<liferay-ui:panel-container extended="<%= false %>"
    id="booksloganCommentsPanelContainer" persistState="<%= true %>">

  <liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
      id="bookCommentsPanel" persistState="<%= true %>"
      title='<%= LanguageUtil.get(pageContext, "comments") %>'>

    <portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />

    <liferay-ui:discussion className="<%= Book.class.getName() %>"
        classPK="<%= book.getId() %>"
        formAction="<%= discussionURL %>" formName="fm2"
        ratingsEnabled="<%= true %>" redirect="<%= currentURL %>"
        subject="<%= book.getName() %>"
        userId="<%= book.getUserId() %>" />

  </liferay-ui:panel>

</liferay-ui:panel-container>
