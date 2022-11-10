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

}