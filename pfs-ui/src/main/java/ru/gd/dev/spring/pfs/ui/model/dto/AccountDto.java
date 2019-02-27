package ru.gd.dev.spring.pfs.ui.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

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
    private String comment = "";

    @NotNull
    private boolean active = true;

    @NotNull
    private String userId = "";

    @NotNull
    private AccountType type;

    @NotNull
    private String clientId = "";

    @NotNull
    private String logoId = "";

}
