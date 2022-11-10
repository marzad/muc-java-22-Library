package de.neuefische.marzad.mucjava22library.controller;


import de.neuefische.marzad.mucjava22library.model.Book;
import de.neuefische.marzad.mucjava22library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

/*    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }*/

    @PutMapping("/{isbn}")
    public Book addBook(@PathVariable String isbn){
        return bookService.addBook(new Book(isbn, "","", null));
    }

    @GetMapping("/{isbn}")
    public Book getBookByISBN(@PathVariable String isbn){
        return bookService.getBookByISBN(isbn);
    }

    @DeleteMapping("/{isbn}")
    public boolean deleteBook(@PathVariable String isbn){
        return bookService.deleteBook(isbn);
    }



}
