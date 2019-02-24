package ru.gb.dev.spring.pfs.accounting.model.dto;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;

import java.math.BigDecimal;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

public class AccountDtoTest {

	private static final String AMOUNT = "10";

	private ModelMapper modelMapper = new ModelMapper();

	@Test
	public void whenConvertAccountToAccountDto_thenCorrect() {
		Account account = new Account();
		account.setName(randomAlphabetic(8));
		account.setAmount(BigDecimal.TEN);

		AccountDto accountDto = modelMapper.map(account, AccountDto.class);
		assertEquals(account.getId(), accountDto.getId());
		assertEquals(account.getName(), accountDto.getName());
		assertEquals(account.getAmount().toString(), accountDto.getAmount());
	}

	@Test
	public void whenConvertPostDtoToPostEntity_thenCorrect() {
		AccountDto accountDto = new AccountDto();
		accountDto.setName(randomAlphabetic(8));
		accountDto.setAmount(AMOUNT);

		Account account = modelMapper.map(accountDto, Account.class);
		assertEquals(accountDto.getId(), account.getId());
		assertEquals(accountDto.getName(), account.getName());
		assertEquals(accountDto.getAmount(), account.getAmount().toString());
	}

}
