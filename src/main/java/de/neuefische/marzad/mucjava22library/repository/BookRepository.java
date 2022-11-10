package de.neuefische.marzad.mucjava22library.repository;

import de.neuefische.marzad.mucjava22library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private List<Book> books;

    public BookRepository(List<Book> books){
        this.books = books;
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book addBook(Book book){
        books.add(book);
        return book;
    }

    public Book getBookByISBN(String isbn){
        Book result = null;
        for(Book book: books){
            if(book.isbn().equals(isbn)){
                result = book;
            }
        }
        return result;
    }

    public boolean deleteBook(String isbn){
        try{
            Book book = this.getBookByISBN(isbn);
            books.remove(book);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


}
