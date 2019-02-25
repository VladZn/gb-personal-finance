package ru.gb.dev.spring.pfs.statistics.model.entity.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractBaseEntity {

	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();

}
