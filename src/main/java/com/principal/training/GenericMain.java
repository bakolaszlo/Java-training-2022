package com.principal.training;

import com.principal.generic.*;

public class GenericMain {
    public static void main(String[] args) {
        Type<Book> type = new Type<Book>();
        type.set(new Book());
        Book myBook = type.get();
        System.out.println(type.get());
    }
}
