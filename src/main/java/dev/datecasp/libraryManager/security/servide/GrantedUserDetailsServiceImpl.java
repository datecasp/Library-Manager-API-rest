package dev.datecasp.libraryManager.security.servide;

import dev.datecasp.libraryManager.entities.GrantedUser;
import dev.datecasp.libraryManager.repositories.GrantedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Autentica un usuario de la base de datos
 *
 * Authentication Manager llama al método loadUserByUsername de esta clase
 * para obtener los detalles del usuario de la base de datos cuando
 * se intente autenticar un usuario
 */
@Service
public class GrantedUserDetailsServiceImpl implements UserDetailsService
{

    @Autowired
    private GrantedUserRepository grantedUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        GrantedUser gUser = grantedUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return new org.springframework.security.core.userdetails.User(
                gUser.getUsername(),gUser.getPassword(),new ArrayList<>());
    }
}