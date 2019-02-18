package ru.gb.dev.spring.pfs.notifying.model.base;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.intellij.lang.annotations.Identifier;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Id
    @Identifier
    @Column(name = "id", unique = true, nullable = false)
    private String id = UUID.randomUUID().toString();

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "user_id", unique = true, nullable = false)
    private String user_id;

}
