package ru.gb.dev.spring.pfs.statistics.model.mapper.base;

import ru.gb.dev.spring.pfs.statistics.model.dto.base.AbstractBaseDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.base.AbstractBaseEntity;

public interface Mapper<E extends AbstractBaseEntity, D extends AbstractBaseDto> {

	E toEntity(D dto);

	D toDto(E entity);

}
