package ru.gb.dev.spring.pfs.accounting.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement
public class AccountDto {

    @NotNull
    private String id = "";

    @NotNull
    private String name = "";

    @NotNull
    private String amount = "";

    @NotNull
    private String userId = "";

    @NotNull
    private String typeId = "";

    @NotNull
    private String iconId = "";

    public AccountDto(@Nullable final Account account) {
        if (account == null) return;
        id = account.getId();
        name = account.getName();
        amount = account.getAmount().toString();
        userId = account.getUserId();
        typeId = account.getTypeId();
        iconId = account.getIconId();
    }

}
