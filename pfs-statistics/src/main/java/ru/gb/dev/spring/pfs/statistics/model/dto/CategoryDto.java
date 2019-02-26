package ru.gb.dev.spring.pfs.statistics.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.gb.dev.spring.pfs.statistics.model.dto.base.AbstractNamedDto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XmlRootElement
public class CategoryDto extends AbstractNamedDto {

	private static final long serialVersionUID = -3476100187582748829L;

	@NotNull
	private Boolean active = Boolean.FALSE;

	@NotNull
	private String logoId = "";

	@NotNull
	private List<OperationDto> operations = new ArrayList<>();

	@NotNull
	private String userId = "";

}
