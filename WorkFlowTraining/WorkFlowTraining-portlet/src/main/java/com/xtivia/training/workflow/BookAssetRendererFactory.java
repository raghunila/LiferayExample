/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.xtivia.training.servicebuilder.model.Book;
import com.xtivia.training.servicebuilder.service.BookLocalServiceUtil;

/**
 *
 * @author rnila
 */
public class BookAssetRendererFactory extends BaseAssetRendererFactory {

    public static final String CLASS_NAME = Book.class.getName();

    public static final String TYPE = "book";

    public AssetRenderer getAssetRenderer(long classPK, int type)
        throws PortalException, SystemException {
        System.out.println(classPK +" >>>>>>>> getting the class pk");
        Book book = BookLocalServiceUtil.getBook(classPK);
        System.out.println(book.getAuthor() +" >>>>>>>>>>>>>>>>>>>>> author is ");
        return new BookAssetRenderer(book);
    }

    public String getClassName() {
        return CLASS_NAME;
    }

    public String getType() {
        return TYPE;
    }
}