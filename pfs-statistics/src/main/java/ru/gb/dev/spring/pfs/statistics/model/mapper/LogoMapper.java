package ru.gb.dev.spring.pfs.statistics.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.mapper.base.AbstractMapper;
import ru.gb.dev.spring.pfs.statistics.model.repository.LogoRepository;

@Component
public class LogoMapper extends AbstractMapper<Logo, LogoDto> {

	LogoMapper(final ModelMapper mapper, final LogoRepository logoRepository) {
		super(Logo.class, LogoDto.class);
	}

}
