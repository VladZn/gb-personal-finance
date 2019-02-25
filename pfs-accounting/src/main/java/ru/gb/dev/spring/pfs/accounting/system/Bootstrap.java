package ru.gb.dev.spring.pfs.accounting.system;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.dev.spring.pfs.accounting.client.ClientService;
import ru.gb.dev.spring.pfs.accounting.client.LogoService;
import ru.gb.dev.spring.pfs.accounting.model.dto.ClientDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.LogoDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.service.AccountService;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Bootstrap implements InitializingBean {

	@Autowired
	private AccountService accountService;

	@Autowired(required = false)
	private ClientService clientService;

	@Autowired(required = false)
	private LogoService logoService;

	@Override
	public void afterPropertiesSet() throws Exception {
		final Account account;
		if (accountService.count() == 0) {
			account = new Account();
			account.setName("TestAccount");
			account.setAmount(BigDecimal.TEN);
		} else {
			account = accountService.findAll().iterator().next();
		}

//		final List<ClientDto> clients = clientService.getAll();
//		if (!clients.isEmpty()) account.setClientId(clients.get(0).getId());
//
//		final List<LogoDto> logos = logoService.getAll();
//		if (!logos.isEmpty()) account.setLogoId(logos.get(0).getId());

		accountService.save(account);
	}

}
