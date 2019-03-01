package ru.gb.dev.spring.pfs.authentication.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author V. Zinchenko
 */

@Getter
@Setter
@Entity
public class Authority implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
