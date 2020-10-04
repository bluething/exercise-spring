package io.github.bluething.spring.security.fundamentaljwt.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/book/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable(name = "isbn") String isbn) {
        return new ResponseEntity<Book>(new Book(isbn, "", ""), HttpStatus.OK);
    }

}
