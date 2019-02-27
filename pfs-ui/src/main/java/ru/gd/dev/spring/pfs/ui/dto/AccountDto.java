package ru.gd.dev.spring.pfs.ui.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@EqualsAndHashCode(callSuper = true)
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
	private Boolean active = Boolean.FALSE;

    @NotNull
    private String userId = "";

    @NotNull
    private AccountType type = AccountType.CASH;

    @NotNull
    private String clientId = "";

    @NotNull
    private String logoId = "";

}
