package io.github.bluething.spring.security.fundamentaljwt.book;

import lombok.Getter;

@Getter
public class Book {

    private final String isbn;
    private final String author;
    private final String title;

    public Book(String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }
}
