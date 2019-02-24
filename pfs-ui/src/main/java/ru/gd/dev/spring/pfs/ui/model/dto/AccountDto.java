package ru.gd.dev.spring.pfs.ui.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AccountDto {

	@NotNull
	private String id = "";

	@NotNull
	private String name = "";

	@NotNull
	private BigDecimal amount = BigDecimal.ZERO;

	@NotNull
	private String comment = "";

	@NotNull
	private String active = "";

	@NotNull
	private String userId = "";

	@NotNull
	private String typeId = "";

	@NotNull
	private String clientId = "";

	@NotNull
	private String logoId = "";

}
