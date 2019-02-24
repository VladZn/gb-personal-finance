package ru.gb.dev.spring.pfs.statistics.model.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractBaseEntity implements Serializable {

	@NotNull
	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();

	@Column(name = "created", updatable = false)
	LocalDateTime created;

	@Column(name = "updated", insertable = false)
	LocalDateTime updated;

	@PrePersist
	public void toCreate() {
		setCreated(LocalDateTime.now());
	}

	@PreUpdate
	public void toUpdate() {
		setUpdated(LocalDateTime.now());
	}

}
