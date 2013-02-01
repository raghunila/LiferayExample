/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.DAO;

import com.xtivia.training.entities.Book;
import java.util.List;

/**
 *
 * @author rnila
 */
public interface BookDAO {
    public void addBook(Book book);
    public List<Book> getListBook();
    public boolean deleteBook(long id);
    public boolean updateBook(Book book);
    public Book getBook(long id);
}
