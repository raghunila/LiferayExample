/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.xtivia.training.entities.Book;
import javax.portlet.ActionRequest;

/**
 *
 * @author rnila
 */
public class ActionUtil {
    
    public static Book getFormRequest(ActionRequest actionRequest)
    {
     
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Book book = new Book();
        book.setName(ParamUtil.getString(actionRequest, "name"));
        book.setAuthor(ParamUtil.getString(actionRequest, "author"));
        book.setIsbnNumber(ParamUtil.getLong(actionRequest, "isbnNumber"));
        book.setSummary(ParamUtil.getString(actionRequest, "summary"));
        return book;
    }
}
