package ru.gd.dev.spring.pfs.ui.system;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.dev.spring.pfs.accounting.feign.ClientService;
import ru.gb.dev.spring.pfs.accounting.feign.LogoService;
import ru.gb.dev.spring.pfs.accounting.model.dto.ClientDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.LogoDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.service.AccountService;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Bootstrap implements InitializingBean {

	@Autowired(required = false)
	private AccountService accountService;

	@Autowired(required = false)
	private CategoryService categoryService;

	@Autowired(required = false)
	private ClientService clientService;

	@Autowired(required = false)
	private LogoService logoService;

	@Autowired(required = false)
	private OperationService operationService;

	@Override
	public void afterPropertiesSet() throws Exception {
		initStatistics();

		final Account account;
		if (accountService.count() == 0) {
			account = new Account();
			account.setName("TestAccount");
			account.setAmount(BigDecimal.TEN);
		} else {
			account = accountService.findAll().iterator().next();
		}

		final List<ClientDto> clients = clientService.getAll();
		if (!clients.isEmpty()) account.setClientId(clients.get(0).getId());

		final List<LogoDto> logos = logoService.getAll();
		if (!logos.isEmpty()) account.setLogoId(logos.get(0).getId());

		accountService.save(account);
	}
	private void initStatistics() {
		final Category category;
		final Client client;
		final Logo logo;
		final Operation operation;

		if (categoryService.count() == 0 &&
				clientService.count() == 0 &&
				logoService.count() == 0 &&
				operationService.count() == 0) {
			category = new Category();
			category.setName("TestCategory");
			category.setActive(true);

			client = new Client();
			client.setName("TestClient");
			client.setActive(true);
			client.setCode("TestClientCode");
			client.setComment("TestCLientComment");

			logo = new Logo();
			logo.setName("TestLogo");
			logo.setExtension("PNG");
			logo.setPath("testPath");

			operation = new Operation();
			operation.setNumber("TestOperationNumber");
			operation.setActive(true);
			operation.setAmount(BigDecimal.TEN);
			operation.setComment("TestOperationComment");

			category.setLogo(logo);

			client.setLogo(logo);

			operation.setCategory(category);
			operation.setClient(client);
			operation.setLogo(logo);
		} else {
			category = categoryService.findAll().iterator().next();
			client = clientService.findAll().iterator().next();
			logo = logoService.findAll().iterator().next();
			operation = operationService.findAll().iterator().next();
		}

		final List<AccountDto> accounts = accountsClient.getAll();
		if (!accounts.isEmpty()) operation.setAccountId(accounts.get(0).getId());

		categoryService.save(category);
		clientService.save(client);
		logoService.save(logo);
		operationService.save(operation);
	}

}
