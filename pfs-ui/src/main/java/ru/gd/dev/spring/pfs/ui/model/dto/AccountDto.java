package ru.gd.dev.spring.pfs.ui.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.gd.dev.spring.pfs.ui.model.dto.base.AbstractNamedDto;

@Data
@EqualsAndHashCode(callSuper = true)
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
