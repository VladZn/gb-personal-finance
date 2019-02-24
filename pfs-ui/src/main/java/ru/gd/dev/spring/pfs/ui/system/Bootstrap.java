package ru.gd.dev.spring.pfs.ui.system;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gd.dev.spring.pfs.ui.model.dto.AccountDto;
import ru.gd.dev.spring.pfs.ui.model.dto.CategoryDto;
import ru.gd.dev.spring.pfs.ui.model.dto.ClientDto;
import ru.gd.dev.spring.pfs.ui.model.dto.LogoDto;
import ru.gd.dev.spring.pfs.ui.model.dto.OperationDto;
import ru.gd.dev.spring.pfs.ui.model.service.AccountService;
import ru.gd.dev.spring.pfs.ui.model.service.CategoryService;
import ru.gd.dev.spring.pfs.ui.model.service.ClientService;
import ru.gd.dev.spring.pfs.ui.model.service.LogoService;
import ru.gd.dev.spring.pfs.ui.model.service.OperationService;

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

//	@Autowired(required = false)
//	private UserService userService;

	@Override
	public void afterPropertiesSet() throws Exception {
		initAccounting();
		initStatistics();
//		initUsers();
	}

	private void initAccounting() {
		final AccountDto account;
		final boolean isNew = accountService.getAll().isEmpty();
		if (isNew) {
			account = new AccountDto();
			account.setName("TestAccount");
			account.setAmount(BigDecimal.TEN.toString());
		} else {
			account = accountService.getAll().get(0);
		}

		final List<ClientDto> clients = clientService.getAll();
		if (!clients.isEmpty()) account.setClientId(clients.get(0).getId());

		final List<LogoDto> logos = logoService.getAll();
		if (!logos.isEmpty()) account.setLogoId(logos.get(0).getId());

		if (isNew) accountService.post(account);
		else accountService.put(account);
	}

	private void initStatistics() {
		final CategoryDto category;
		final ClientDto client;
		final LogoDto logo;
		final OperationDto operation;

		final boolean isCategoryNew = categoryService.getAll().isEmpty();
		final boolean isClientNew = clientService.getAll().isEmpty();
		final boolean isLogoNew = logoService.getAll().isEmpty();
		final boolean isOperationNew = operationService.getAll().isEmpty();

		if (isCategoryNew) {
			category = new CategoryDto();
			category.setName("TestCategory");
			category.setActive(Boolean.TRUE.toString());
		} else {
			category = categoryService.getAll().get(0);
		}

		if (isClientNew) {
			client = new ClientDto();
			client.setName("TestClient");
			client.setIsActice(Boolean.TRUE.toString());
			client.setCode("TestClientCode");
			client.setComment("TestCLientComment");
		} else {
			client = clientService.getAll().get(0);
		}

		if (isLogoNew) {
			logo = new LogoDto();
			logo.setName("TestLogo");
			logo.setExtension("PNG");
			logo.setPath("testPath");
		} else {
			logo = logoService.getAll().get(0);
		}

		if (isOperationNew) {
			operation = new OperationDto();
			operation.setAmount(BigDecimal.TEN.toString());
			operation.setComment("TestOperationComment");
		} else {
			operation = operationService.getAll().get(0);
		}

		category.setLogo_id(logo.getId());

		client.setLogo_id(logo.getId());

		operation.setCategoryId(category.getId());
		operation.setFileId(logo.getId());

		if (isCategoryNew) categoryService.post(category);
		else categoryService.put(category);

		if (isClientNew) clientService.post(client);
		else clientService.put(client);

		if (isLogoNew) logoService.post(logo);
		else logoService.put(logo);

		if (isOperationNew) operationService.post(operation);
		else operationService.put(operation);
	}

//	private void initUsers() {
//		if (!userService.getAll().isEmpty()) return;
//		final UserDto admin = new UserDto();
//		final UserDto user = new UserDto();
//
//		user.setLogin("user");
//		user.setEmail("user@pfs.com");
//
//		admin.setLogin("admin");
//		admin.setEmail("admin@pfs.com");
//
//		userService.post(admin);
//		userService.post(user);
//	}

}
