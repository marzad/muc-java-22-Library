package de.neuefische.marzad.mucjava22library.service;

import de.neuefische.marzad.mucjava22library.model.Book;
import de.neuefische.marzad.mucjava22library.repository.BookRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    BookRepository bookRepository = mock(BookRepository.class);
    BookService bookService = new BookService(bookRepository);

    @Test
    public void test_getAllBooks(){
        List<Book> books = new ArrayList<>();
        Book book = new Book("123", "Me", "Java");
        books.add(book);

        when(BookService.getAllBooks()).thenReturn(books);

        List<Book> expected = BookService.getAllBooks();

        List<Book> result = books;

        verify(bookRepository).getAllBooks();

        assertEquals(expected, result);

    }

    @Test
    public void test_getBookByISBN(){
        Book book = new Book("0345391802", "","");

        when(BookService.getBookByISBN("0345391802")).thenReturn(book);

        Book expected = bookRepository.getBookByISBN("0345391802");
        Book result = new Book("0345391802", "","");

        verify(bookRepository).getBookByISBN("0345391802");

        assertEquals(expected, result);

    }

    @Test
    public void test_addBook(){
        Book book = new Book("0345391802", "","");

        when(BookService.addBook(book)).thenReturn(book);

        Book expected = bookRepository.addBook(book);
        Book result = new Book("0345391802", "","");

        verify(bookRepository).addBook(book);

        assertEquals(expected, result);
    }

    @Test
    public void test_deleteBook(){
        Book book = new Book("0345391802", "","");

        when(BookService.deleteBook("0345391802")).thenReturn(true);

        boolean expected = bookRepository.deleteBook("0345391802");

        verify(bookRepository).deleteBook("0345391802");

       assertTrue(expected);
    }




}