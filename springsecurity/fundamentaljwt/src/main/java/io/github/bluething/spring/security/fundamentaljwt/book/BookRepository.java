package io.github.bluething.spring.security.fundamentaljwt.book;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    public Book getBook(Book bookRequest) {
        return new Book(bookRequest.getIsbn(), "This is the author", "This is a title");
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("978-6-2021-1578-0", "This is the author", "This is a title"));
        books.add(new Book("978-0-4546-1715-3", "This is the author", "This is a title"));
        return books;
    }

    public boolean deleteBook(Book bookRequest) {
        return true;
    }

    public Book addBook(Book bookRequest) {
        return bookRequest;
    }
}
