/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.data;

import com.xtivia.training.util.Unique;
import java.io.Serializable;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Book Domain object which defines properties of a book in the catalog.
 *
 * @author asarin
 */
public class Book{

    @NotEmpty
    @Size(max = 100, min = 10)
    private String name;
    @NotEmpty
    private String author;
    @Unique
    private Long isbnNumber;
    @NotEmpty
    private String summary;

    public Book(String name, String author, long isbnNumber,String summary) {
        this.name = name;
        this.author = author;
        this.isbnNumber = isbnNumber;
        this.summary = summary;
    }

    public Book() {
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

    @Override
    public boolean equals(Object otherObject) {
        Book otherBook = (Book) otherObject;
        if (otherBook.getIsbnNumber() == this.isbnNumber) {
            return true;
        } else {
            return false;
        }
    }
}
