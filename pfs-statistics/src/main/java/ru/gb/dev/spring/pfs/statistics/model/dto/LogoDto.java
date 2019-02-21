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
public class LogoDto {

	@NotNull
	private String id = "";

	@NotNull
	private String name = "";

	@NotNull
	private String userId = "";

	@NotNull
	private String path = "";

	@NotNull
	private String extension = "";

}
