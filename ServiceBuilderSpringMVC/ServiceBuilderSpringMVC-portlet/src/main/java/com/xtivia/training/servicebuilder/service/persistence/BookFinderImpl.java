/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.servicebuilder.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.xtivia.training.servicebuilder.model.Book;
import com.xtivia.training.servicebuilder.model.impl.BookImpl;
import java.util.List;

/**
 *
 * @author rnila
 */
public class BookFinderImpl extends BasePersistenceImpl implements BookFinder {

    public Book findBook(long isbn) throws SystemException {
        Session session = null;
        try {
            System.out.println(" Iam getting the value");
            session = openSession();
            //String sql = CustomSQLUtil.get(FIND_BOOKS);
            String sql = "select * from book_book where isbn=" + isbn;
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity("Book", BookImpl.class);
            QueryPos qPos = QueryPos.getInstance(query);
            //qPos.add(name);
            Book book = (Book) query.uniqueResult();
            System.out.println(" Iam getting the value" +book.getName());

            return book;
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return null;
    }
}
