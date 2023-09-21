/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagementsystem;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Shaldon
 */
public class LibraryManagementSystem {

    public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
        ArrayList<Book> bookInventory = new ArrayList<>();
        Cart cart = new Cart();

        // Populate the book inventory with sample books
        bookInventory.add(new FictionBook("The Great Gatsby", "F. Scott Fitzgerald", 10.99, "Classics"));
        bookInventory.add(new FictionBook("To Kill a Mockingbird", "Harper Lee", 12.99, "Classics"));
        bookInventory.add(new NonFictionBook("Introduction to Java", "John Doe", 29.99, "Programming"));
        bookInventory.add(new NonFictionBook("Data Structures and Algorithms", "Alice Smith", 24.99, "Programming"));

        while (true) {
            System.out.println("Online Bookstore Menu:");
            System.out.println("1. Browse Books");
            System.out.println("2. Add Book to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available Books:");
                    for (int i = 0; i < bookInventory.size(); i++) {
                        Book book = bookInventory.get(i);
                        System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor() + " - $" + book.getPrice());
                    }
                    break;

                case 2:
                    System.out.print("Enter the book number to add to cart: ");
                    int bookNumber = scanner.nextInt();
                    if (bookNumber >= 1 && bookNumber <= bookInventory.size()) {
                        Book selectedBook = bookInventory.get(bookNumber - 1);
                        cart.addItem(selectedBook);
                        System.out.println(selectedBook.getTitle() + " added to cart.");
                    } else {
                        System.out.println("Invalid book number.");
                    }
                    break;

                case 3:
                    ArrayList<Book> cartItems = cart.getItems();
                    if (cartItems.isEmpty()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        System.out.println("Cart Contents:");
                        for (int i = 0; i < cartItems.size(); i++) {
                            Book item = cartItems.get(i);
                            System.out.println((i + 1) + ". " + item.getTitle() + " by " + item.getAuthor() + " - $" + item.getPrice());
                        }
                        System.out.println("Total Price: $" + cart.calculateTotal());
                    }
                    break;

                case 4:
                    ArrayList<Book> purchasedBooks = cart.getItems();
                    if (purchasedBooks.isEmpty()) {
                        System.out.println("Your cart is empty. Nothing to purchase.");
                    } else {
                        System.out.println("Thank you for your purchase!");
                        System.out.println("Purchased Books:");
                        for (Book item : purchasedBooks) {
                            System.out.println(item.getTitle() + " by " + item.getAuthor() + " - $" + item.getPrice());
                        }
                        System.out.println("Total Price: $" + cart.calculateTotal());
                        // Clear the cart after purchase
                        cart.getItems().clear();
                    }
                    break;

                case 5:
                    System.out.println("Exiting the Online Bookstore. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
