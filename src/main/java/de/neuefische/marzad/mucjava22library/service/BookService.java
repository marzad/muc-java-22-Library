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

    public static Book addBook(Book book){
        return bookRepo.addBook(book);
    }

    public static Book getBookByISBN(String isbn){
        return bookRepo.getBookByISBN(isbn);
    }

    public static boolean deleteBook(String isbn){
        return bookRepo.deleteBook(isbn);
    }


}
