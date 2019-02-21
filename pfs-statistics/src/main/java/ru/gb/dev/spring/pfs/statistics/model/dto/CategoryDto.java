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
public class CategoryDto {

	@NotNull
	private String id = "";

	@NotNull
	private String name = "";

	@NotNull
	private String active = "";

	@NotNull
	private String logo_id = "";

	@NotNull
	private String userId = "";

}
