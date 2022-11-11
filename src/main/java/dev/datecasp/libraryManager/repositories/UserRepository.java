package dev.datecasp.libraryManager.repositories;

import dev.datecasp.libraryManager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
}
