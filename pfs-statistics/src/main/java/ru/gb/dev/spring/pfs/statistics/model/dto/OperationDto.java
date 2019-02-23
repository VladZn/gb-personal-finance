package ru.gb.dev.spring.pfs.statistics.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class OperationDto {

	@NotNull
	private String id = "";

	@NotNull
	private String comment = "";

	@NotNull
	private String amount = "";

	@NotNull
	private String date = "";

	@NotNull
	private String typeId = "";

	@NotNull
	private String accountId = "";

	@NotNull
	private String userId = "";

	@NotNull
	private String categoryId = "";

	@NotNull
	private String fileId = "";

	@NotNull
	private String counterpartId = "";

}
