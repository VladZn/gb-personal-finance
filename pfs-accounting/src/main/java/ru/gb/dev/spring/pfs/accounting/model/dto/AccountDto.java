package ru.gb.dev.spring.pfs.accounting.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.gb.dev.spring.pfs.accounting.model.dto.base.AbstractNamedDto;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto extends AbstractNamedDto {

	private static final long serialVersionUID = 1596263169401921474L;

    @NotNull
    private String amount = "";

    @NotNull
    private String comment = "";

	@NotNull
	private Boolean active = Boolean.FALSE;

    @NotNull
    private String userId = "";

    @NotNull
    private String typeId = "";

    @NotNull
    private String clientId = "";

    @NotNull
    private String logoId = "";

}
