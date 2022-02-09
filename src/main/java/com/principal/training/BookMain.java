package com.principal.training;

import com.principal.model.Book;

public class BookMain {
    public static void main(String[] args) {
        System.out.println(Book.bookCount);
        new Book();
        new Book();
        new Book();
        new Book();
        System.out.println(Book.bookCount);
    }
}
