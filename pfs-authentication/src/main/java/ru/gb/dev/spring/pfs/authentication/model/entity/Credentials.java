package ru.gb.dev.spring.pfs.authentication.model.entity;

import lombok.Getter;
import lombok.Setter;
import ru.gb.dev.spring.pfs.authentication.model.entity.Authority;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

/**
 * @author V. Zinchenko
 */

@Getter
@Setter
@Entity
@Table(name = "credentials")
public class Credentials {
    @Id
    private String id = UUID.randomUUID().toString();

    @Version
    private Integer version;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Authority> authorities;

    private boolean enabled;

}
