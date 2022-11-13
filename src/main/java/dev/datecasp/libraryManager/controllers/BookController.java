package dev.datecasp.libraryManager.controllers;

import dev.datecasp.libraryManager.entities.Book;
import dev.datecasp.libraryManager.repositories.BookRepository;
import dev.datecasp.libraryManager.repositories.BookUserRepository;
import dev.datecasp.libraryManager.repositories.UserRepository;
import dev.datecasp.libraryManager.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Books")
public class BookController
{
    @Autowired
    private BookService bookService;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private BookUserRepository bookUserRepository;

    public BookController(BookRepository bookRepository, UserRepository userRepository, BookUserRepository bookUserRepository)
    {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.bookUserRepository = bookUserRepository;
    }

    @GetMapping("/GetAllBooks")
    public ResponseEntity<List<Book>> getAllBooks ()
    {
        return ResponseEntity.ok(bookService.findAll());
    }
}
