package ru.gb.dev.spring.pfs.statistics.dto;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

public class LogoDtoTest {

	private final ModelMapper modelMapper = new ModelMapper();

	@Test
	public void whenConvertLogoToLogoDto_thenCorrect() {
		final Logo logo = new Logo();
		logo.setName(randomAlphabetic(8));
		logo.setPath(randomAlphabetic(8));
		logo.setExtension(randomAlphabetic(8));

		final LogoDto logoDto = modelMapper.map(logo, LogoDto.class);
		assertEquals(logo.getId(), logoDto.getId());
		assertEquals(logo.getName(), logoDto.getName());
		assertEquals(logo.getPath(), logoDto.getPath());
		assertEquals(logo.getExtension(), logoDto.getExtension());
	}

	@Test
	public void whenConvertPostDtoToPostEntity_thenCorrect() {
		final LogoDto logoDto = new LogoDto();
		logoDto.setName(randomAlphabetic(8));
		logoDto.setPath(randomAlphabetic(8));
		logoDto.setExtension(randomAlphabetic(8));

		final Logo logo = modelMapper.map(logoDto, Logo.class);
		assertEquals(logoDto.getId(), logo.getId());
		assertEquals(logoDto.getName(), logo.getName());
		assertEquals(logoDto.getPath(), logo.getPath());
	}

}
