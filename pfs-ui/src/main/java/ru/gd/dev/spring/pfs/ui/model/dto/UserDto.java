package ru.gd.dev.spring.pfs.ui.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class UserDto {

	@NotNull
	private String id = "";

	@NotNull
	private String login = "";

	@NotNull
	private String email = "";

}
