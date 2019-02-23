package ru.gb.dev.spring.pfs.accounting.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@Data
@NoArgsConstructor
@XmlRootElement
public class AccountDto {

	@NotNull
	private String id = UUID.randomUUID().toString();

	@NotNull
	private String name = "";

	@NotNull
	private String amount = "";

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
