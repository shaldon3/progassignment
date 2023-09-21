/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem;
import java.util.ArrayList;
/**
 *
 * @author Shaldon
 */
 class Cart {
private ArrayList<Book> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Book book) {
        items.add(book);
    }

    public ArrayList<Book> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Book item : items) {
            total += item.getPrice();
        }
        return total;
    }    
}
