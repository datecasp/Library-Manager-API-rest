package dev.datecasp.libraryManager.repositories;

import dev.datecasp.libraryManager.entities.GrantedUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrantedUserRepository extends JpaRepository<GrantedUser, Long>
{
    Optional<GrantedUser> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
