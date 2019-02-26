package ru.gb.dev.spring.pfs.statistics.controller.dto;

public class FailDto extends ResultDto {

	public FailDto(final Exception e) {
		setSuccess(false);
		setMessage(e.getMessage());
	}
}
