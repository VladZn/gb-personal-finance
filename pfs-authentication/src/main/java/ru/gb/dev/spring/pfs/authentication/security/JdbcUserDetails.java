package ru.gb.dev.spring.pfs.authentication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.gb.dev.spring.pfs.authentication.model.entity.Credentials;
import ru.gb.dev.spring.pfs.authentication.model.repository.CredentialsRepository;

import java.util.Optional;

/**
 * @author V. Zinchenko
 */
@Component
public class JdbcUserDetails implements UserDetailsService {

    @Autowired
    private CredentialsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Credentials credentials = Optional.ofNullable(repository.findByName(username))
                .orElseThrow(() -> new UsernameNotFoundException("User" + username + "can not be found"));

        User user = new User(credentials.getName(),
                credentials.getPassword(),
                credentials.isEnabled(),
                true,
                true,
                true,
                credentials.getAuthorities());

        return user;
    }
}
