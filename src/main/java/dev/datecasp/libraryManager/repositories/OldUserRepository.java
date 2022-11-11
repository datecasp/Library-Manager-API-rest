package dev.datecasp.libraryManager.repositories;

import dev.datecasp.libraryManager.entities.OldUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OldUserRepository extends JpaRepository<OldUser, Long>
{
}
