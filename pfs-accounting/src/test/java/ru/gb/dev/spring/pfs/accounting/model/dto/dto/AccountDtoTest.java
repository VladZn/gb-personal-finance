package ru.gb.dev.spring.pfs.accounting.model.dto.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.service.AccountService;

import java.math.BigDecimal;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountDtoTest {

	private static final String AMOUNT = "10";

	@Autowired
	private AccountService accountService;

	@Test
	public void whenConvertAccountToAccountDto_thenCorrect() {
		final Account account = new Account();
		account.setName(randomAlphabetic(8));
		account.setAmount(BigDecimal.TEN);
		account.setActive(true);

		final AccountDto accountDto = accountService.toDto(account);
		assertEquals(account.getId(), accountDto.getId());
		assertEquals(account.getName(), accountDto.getName());
		assertEquals(account.getAmount().toString(), accountDto.getAmount());
		assertEquals(account.getActive().toString(), accountDto.getActive());
	}

	@Test
	public void whenConvertPostDtoToPostEntity_thenCorrect() {
		final AccountDto accountDto = new AccountDto();
		accountDto.setName(randomAlphabetic(8));
		accountDto.setAmount(AMOUNT);
		accountDto.setActive("true");

		final Account account = accountService.fromDto(accountDto);
		assertEquals(accountDto.getId(), account.getId());
		assertEquals(accountDto.getName(), account.getName());
		assertEquals(BigDecimal.TEN, account.getAmount());
		assertEquals(true, account.getActive());
	}

}
