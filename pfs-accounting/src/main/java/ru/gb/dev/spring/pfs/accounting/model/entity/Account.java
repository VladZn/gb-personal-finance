package ru.gb.dev.spring.pfs.accounting.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.base.AbstractNamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

import static ru.gb.dev.spring.pfs.accounting.utils.Utils.getBigDecimalOfString;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "accounts")
public class Account extends AbstractNamedEntity {

	@NotNull
	@Column(name = "amount")
	private BigDecimal amount = BigDecimal.ZERO;

	@NotNull
	@Column(name = "comment")
	private String comment = "";

	@NotNull
	@Column(name = "active")
	private Boolean active = false;

	@NotNull
	@Column(name = "type_id")
	private String typeId = "";

	@NotNull
	@Column(name = "user_id")
	private String userId = "";

	@NotNull
	@Column(name = "client_id")
	private String clientId = "";

	@NotNull
	@Column(name = "logo_id")
	private String logoId = "";

	public Account(@Nullable final AccountDto account) {
		if (account == null) return;
		setId(account.getId());
		setName(account.getName());
		amount = getBigDecimalOfString(account.getAmount());
		comment = account.getComment();
		active = Boolean.valueOf(account.getActive());
		userId = account.getUserId();
		typeId = account.getTypeId();
		clientId = account.getClientId();
		logoId = account.getLogoId();
	}

}
