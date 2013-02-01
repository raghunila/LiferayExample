/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.entities;

/**
 *
 * @author rnila
 */
public class Book {

    private String name;
    private String author;
    private Long isbnNumber;
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

    /**
     * Two books are considered identical if they have the same ISBN number.
     *
     */
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
