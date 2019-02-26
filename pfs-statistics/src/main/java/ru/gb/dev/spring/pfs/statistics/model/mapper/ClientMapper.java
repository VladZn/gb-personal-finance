package ru.gb.dev.spring.pfs.statistics.model.mapper;

import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.statistics.model.dto.ClientDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.mapper.base.AbstractMapper;
import ru.gb.dev.spring.pfs.statistics.model.repository.LogoRepository;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class ClientMapper extends AbstractMapper<Client, ClientDto> {

	private final ModelMapper mapper;
	private final LogoRepository logoRepository;

	ClientMapper(final ModelMapper mapper, final LogoRepository logoRepository) {
		super(Client.class, ClientDto.class);
		this.mapper = mapper;
		this.logoRepository = logoRepository;
	}

	@PostConstruct
	public void setupMapper() {
		mapper.createTypeMap(Client.class, ClientDto.class)
				.addMappings(m -> m.skip(ClientDto::setLogoId)).setPostConverter(toDtoConverter());
		mapper.createTypeMap(ClientDto.class, Client.class)
				.addMappings(m -> m.skip(Client::setLogo)).setPostConverter(toEntityConverter());
	}

	@Override
	protected void mapSpecificFields(final Client source, final ClientDto destination) {
		String logoId = getLogoId(source);
		if (!StringUtils.isEmpty(logoId)) destination.setLogoId(logoId);
	}

	@Nullable
	private String getLogoId(final Client source) {
		return Objects.isNull(source) || Objects.isNull(source.getLogo()) ? null : source.getLogo().getId();
	}

	@Override
	protected void mapSpecificFields(final ClientDto source, final Client destination) {
		destination.setLogo(logoRepository.findById(source.getLogoId()).orElse(null));
	}

}
