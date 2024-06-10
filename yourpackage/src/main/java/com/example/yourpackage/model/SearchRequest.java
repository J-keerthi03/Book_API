package com.example.yourpackage.model;

import java.util.List;

public class SearchRequest {
    private List<String> authors;
    private List<String> descriptions;

    // Constructors
    public SearchRequest() {}

    public SearchRequest(List<String> authors, List<String> descriptions) {
        this.authors = authors;
        this.descriptions = descriptions;
    }

    // Getters and Setters
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }
}
