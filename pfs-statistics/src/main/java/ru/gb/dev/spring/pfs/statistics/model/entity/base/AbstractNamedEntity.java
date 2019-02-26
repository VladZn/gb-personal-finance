package ru.gb.dev.spring.pfs.statistics.model.entity.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractBaseEntity {

	@Column(name = "name")
	private String name = "";

}
