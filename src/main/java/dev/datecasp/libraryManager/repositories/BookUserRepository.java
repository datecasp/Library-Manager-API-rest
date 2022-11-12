package dev.datecasp.libraryManager.repositories;

import dev.datecasp.libraryManager.entities.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookUserRepository extends JpaRepository<BookUser, Long>
{
}
