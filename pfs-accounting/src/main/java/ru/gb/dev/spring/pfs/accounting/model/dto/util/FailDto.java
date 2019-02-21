package ru.gb.dev.spring.pfs.accounting.model.dto.util;

public class FailDto extends ResultDto {

	public FailDto(final Exception e) {
		setSuccess(false);
		setMessage(e.getMessage());
	}
}
