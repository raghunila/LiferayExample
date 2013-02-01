/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.workflow;

import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.xtivia.training.servicebuilder.model.Book;
import java.util.Locale;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 *
 * @author rnila
 */
public class BookAssetRenderer extends  BaseAssetRenderer{

     public BookAssetRenderer(Book book) {
        _book = book;
    }
    private Book _book;

    public long getClassPK() {
        return _book.getId();
    }

    public long getGroupId() {
        return _book.getGroupId();
    }

    public String getSummary(Locale locale) {
        return _book.getName();
    }

    public String getTitle(Locale locale) {
        return _book.getName();
    }

    public long getUserId() {
        return _book.getUserId();
    }

    public String getUuid() {
        return _book.getUuid();
    }
    public String getUserName()
    {
        return _book.getAuthor();
    }
    public String render(
            RenderRequest request, RenderResponse response,
            String template)
            throws Exception {

        if (template.equals(TEMPLATE_FULL_CONTENT)) {
            request.setAttribute("BOOK_ENTRY", _book);

            return "/WEB-INF/jsp/" + template + ".jsp";
        } else {
            return null;
        }
    }

    
}
