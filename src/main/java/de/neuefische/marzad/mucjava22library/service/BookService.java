package de.neuefische.marzad.mucjava22library.service;

import de.neuefische.marzad.mucjava22library.model.Book;
import de.neuefische.marzad.mucjava22library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static BookRepository bookRepo;

    public BookService(BookRepository bookrepo){
        this.bookRepo = bookrepo;
    }

    public static List<Book> getAllBooks(){
        return bookRepo.getAllBooks();
    }

    public Book addBook(Book book){
        return bookRepo.addBook(book);
    }
}
