package de.neuefische.marzad.mucjava22library.controller;

import de.neuefische.marzad.mucjava22library.model.Book;
import de.neuefische.marzad.mucjava22library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    BookRepository bookRepository;

    @Test
    void getAllBooksTest() throws Exception {

        Book book = new Book("123", "me", "Java");
        bookRepository.addBook(book);

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
[
{
"isbn" : "123",
"autor" : "me",
"title" : "Java"
}
]
"""));
    }

    @Test
    void addBookTest() throws Exception{

        Book book = new Book("123", "me", "Java");
        bookRepository.addBook(book);

        mockMvc.perform(put("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""

{
"isbn" : "123",
"autor" : "me",
"title" : "Java"
}

"""));
    }

    @Test
    void getBookByISBNTest() throws Exception{
        Book book = new Book("0345391802", "", "");
        bookRepository.addBook(book);

        mockMvc.perform(get("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""

{
"isbn" : "0345391802",
"autor" : "",
"title" : ""
}

"""));
    }
    @Test
    void deleteBookTest() throws Exception{
        Book book = new Book("0345391802", "", "");
        bookRepository.addBook(book);
        String isbn ="0345391802";

        mockMvc.perform(delete("/books/{isbn}", isbn))
                .andExpect(status().isOk());


/*
{
"isbn" : "0345391802",
"autor" : "",
"title" : ""
}
*/


    }



}

