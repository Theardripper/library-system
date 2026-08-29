package com.library.api.dto.Response;

public class BookResponseDTO {

    private Long id;
    private String name;
    private String author;
    private String year;
    private String synopis;
    private String edition;

    public BookResponseDTO(Long id, String name, String author, String year, String synopis, String edition){
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.synopis = synopis;
        this.edition = edition;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public String getSynopis() {
        return synopis;
    }

    public String getEdition() {
        return edition;
    }
}
