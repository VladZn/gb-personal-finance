package ru.gb.dev.spring.pfs.statistics.system;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.dev.spring.pfs.statistics.feign.AccountService;
import ru.gb.dev.spring.pfs.statistics.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.entity.Operation;
import ru.gb.dev.spring.pfs.statistics.model.service.CategoryService;
import ru.gb.dev.spring.pfs.statistics.model.service.ClientService;
import ru.gb.dev.spring.pfs.statistics.model.service.LogoService;
import ru.gb.dev.spring.pfs.statistics.model.service.OperationService;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Bootstrap implements InitializingBean {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private LogoService logoService;

	@Autowired
	private OperationService operationService;

	@Autowired(required = false)
	private AccountService accountsClient;

	@Override
	public void afterPropertiesSet() throws Exception {
		initStatistics();
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
