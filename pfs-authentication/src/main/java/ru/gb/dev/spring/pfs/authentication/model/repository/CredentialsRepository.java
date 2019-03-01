package ru.gb.dev.spring.pfs.authentication.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.dev.spring.pfs.authentication.model.entity.Credentials;

/**
 * @author V. Zinchenko
 */
@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, String> {
    Credentials findByName(String name);
}
