package ru.gb.dev.spring.pfs.accounting.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ClientDto {

	@NotNull
	private String id = "";

	@NotNull
	private String name = "";

	@NotNull
	private String fullName = "";

	@NotNull
	private String email = "";

	@NotNull
	private String phone = "";

	@NotNull
	private String code = "";

	@NotNull
	private String inn = "";

	@NotNull
	private String kpp = "";

	@NotNull
	private String urAddress = "";

	@NotNull
	private String physAddress = "";

	@NotNull
	private String comment = "";

	@NotNull
	private String isActice = "";

	@NotNull
	private String logo_id = "";

	@NotNull
	private String userId = "";

}
