package ru.gb.dev.spring.pfs.accounting.model.dto.dto;

import org.junit.Test;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;

import java.math.BigDecimal;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

public class AccountDtoTest {

	private static final String AMOUNT = "10";

	@Test
	public void whenConvertAccountToAccountDto_thenCorrect() {
		Account account = new Account();
		account.setName(randomAlphabetic(8));
		account.setAmount(BigDecimal.TEN);
		account.setActive(true);

		AccountDto accountDto = new AccountDto(account);
		assertEquals(account.getId(), accountDto.getId());
		assertEquals(account.getName(), accountDto.getName());
		assertEquals(account.getAmount().toString(), accountDto.getAmount());
		assertEquals(account.getActive().toString(), accountDto.getActive());
	}

	@Test
	public void whenConvertPostDtoToPostEntity_thenCorrect() {
		AccountDto accountDto = new AccountDto();
		accountDto.setName(randomAlphabetic(8));
		accountDto.setAmount(AMOUNT);
		accountDto.setActive("true");

		Account account = new Account(accountDto);
		assertEquals(accountDto.getId(), account.getId());
		assertEquals(accountDto.getName(), account.getName());
		assertEquals(BigDecimal.TEN, account.getAmount());
		assertEquals(true, account.getActive());
	}

}
