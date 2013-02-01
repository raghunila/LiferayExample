/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.data;

/**
 *
 * @author rnila
 */
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookAddedEvent implements Serializable {

    private static final long serialVersionUID = -2232317909090023831L;
    private String name;
    private String author;
    private Long isbnNumber;
    private String summary;

    public BookAddedEvent() {
        //-- do nothing
    }

    public BookAddedEvent(Book book) {
        this.name = book.getName();
        this.author = book.getAuthor();
        this.summary = book.getSummary();
        this.isbnNumber = book.getIsbnNumber();
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

    public Long getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(Long isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}