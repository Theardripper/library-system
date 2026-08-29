package com.library.api.dto.Request;

public class BookRequestDTO {

    private String name;
    private String author;
    private String year;
    private String synopis;
    private String edition;


    // getters and setters

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSynopis() {
        return synopis;
    }

    public void setSynopis(String synopis) {
        this.synopis = synopis;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
