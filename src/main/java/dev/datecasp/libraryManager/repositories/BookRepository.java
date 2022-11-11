package dev.datecasp.libraryManager.repositories;

import dev.datecasp.libraryManager.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>
{
}
