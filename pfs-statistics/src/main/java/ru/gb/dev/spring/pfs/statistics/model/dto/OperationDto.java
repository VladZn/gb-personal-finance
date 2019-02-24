package ru.gb.dev.spring.pfs.statistics.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class OperationDto {

	@NotNull
	private String id = "";

	@NotNull
	private String amount = "";

	@NotNull
	private String description = "";

	@NotNull
	private String comment = "";

	@NotNull
	private String type = "";

	@NotNull
	private String number = "";

	@NotNull
	private LocalDateTime operationDate = LocalDateTime.now();

	@NotNull
	private String active = "";

	@NotNull
	private String clientId = "";

	@NotNull
	private String categoryId = "";

	@NotNull
	private String logoId = "";

	@NotNull
	private String accountId = "";

	@NotNull
	private String userId = "";

}
