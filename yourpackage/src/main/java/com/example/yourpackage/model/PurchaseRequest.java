package com.example.yourpackage.model;

public class PurchaseRequest {

        private String author;
        private String description;
        private int quantity;

        public PurchaseRequest(String author, String description, int quantity) {
            this.author = author;
            this.description = description;
            this.quantity = quantity;
        }
        public PurchaseRequest() {}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    }


