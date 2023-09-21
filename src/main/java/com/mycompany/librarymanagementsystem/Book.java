/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem;

/**
 *
 * @author Shaldon
 */
interface Book {
   String getTitle();
    String getAuthor();
    double getPrice();
}

class FictionBook implements Book {
    private String title;
    private String author;
    private double price;
    private String genre;

    public FictionBook(String title, String author, double price, String genre) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = genre;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }
}

class NonFictionBook implements Book {
    private String title;
    private String author;
    private double price;
    private String category;

    public NonFictionBook(String title, String author, double price, String category) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}