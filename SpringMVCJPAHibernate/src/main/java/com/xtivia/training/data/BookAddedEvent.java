/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.data;

/**
 *
 * @author rnila
 */
import com.xitivia.training.entities.Book;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookAddedEvent implements Serializable {

    private static final long serialVersionUID = -2232317909090023831L;
    private String name;
    private String author;
    private Long isbn;
    private String summary;

    public BookAddedEvent() {
        //-- do nothing
    }

    public BookAddedEvent(Book book) {
        this.name = book.getName();
        this.author = book.getAuthor();
        this.summary = book.getSummary();
        this.isbn = book.getIsbn();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getisbn() {
        return isbn;
    }

    public void setisbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}