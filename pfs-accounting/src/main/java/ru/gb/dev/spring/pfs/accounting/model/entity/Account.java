package ru.gb.dev.spring.pfs.accounting.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.gb.dev.spring.pfs.accounting.model.entity.base.AbstractNamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "account")
public class Account extends AbstractNamedEntity {

    @NotNull
    @Column(name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @NotNull
    @Column(name = "user_id")
    private String userId = "";

    @NotNull
    @Column(name = "type_id")
    private String typeId = "";

    @NotNull
    @Column(name = "icon_id")
    private String iconId = "";

}
