package dev.datecasp.libraryManager.services;

import dev.datecasp.libraryManager.entities.Book;
import dev.datecasp.libraryManager.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll()
    {
        return bookRepository.findAll();
    }
}
