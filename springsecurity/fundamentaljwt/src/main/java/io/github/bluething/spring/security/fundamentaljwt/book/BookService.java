package io.github.bluething.spring.security.fundamentaljwt.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(Book bookRequest) {
        return bookRepository.getBook(bookRequest);
    }

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public boolean deleteBook(Book bookRequest) {
        return bookRepository.deleteBook(bookRequest);
    }

    public Book addBook(Book bookRequest) {
        return bookRepository.addBook(bookRequest);
    }
}
