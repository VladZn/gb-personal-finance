package ru.gb.dev.spring.pfs.accounting.system;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.service.AccountService;

import java.math.BigDecimal;

@Component
public class Bootstrap implements InitializingBean {

	@Autowired
	private AccountService service;

	@Override
	public void afterPropertiesSet() throws Exception {
		final Account account = new Account();
		account.setName("TestAccount");
		account.setAmount(BigDecimal.TEN);
		service.initAccount(account);
	}

}
