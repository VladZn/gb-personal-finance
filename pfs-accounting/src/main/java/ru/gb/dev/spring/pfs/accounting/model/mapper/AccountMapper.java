package ru.gb.dev.spring.pfs.accounting.model.mapper;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;

import static ru.gb.dev.spring.pfs.accounting.util.Utils.getBigDecimalOfString;

@Component
public class AccountMapper implements Mapper<Account, AccountDto> {

    @Override
    public @Nullable Account toEntity(final AccountDto dto) {
//        if (dto == null) return null;

        final Account account = new Account();
        account.setId(dto.getId());
        account.setName(dto.getName());
        account.setAmount(getBigDecimalOfString(dto.getAmount()));
        account.setComment(dto.getComment());
        account.setActive(dto.getActive());
        account.setUserId(dto.getUserId());
        account.setTypeId(dto.getTypeId());
        account.setClientId(dto.getClientId());
        account.setLogoId(dto.getLogoId());
        account.setCreated(dto.getCreated());
        account.setUpdated(dto.getUpdated());

        return account;
    }

    @Override
    public @Nullable AccountDto toDto(final Account entity) {
//        if (entity == null) return null;

        final AccountDto accountDto = new AccountDto();
        accountDto.setId(entity.getId());
        accountDto.setName(entity.getName());
        accountDto.setAmount(entity.getAmount().toString());
        accountDto.setComment(entity.getComment());
        accountDto.setActive(entity.getActive());
        accountDto.setUserId(entity.getUserId());
        accountDto.setTypeId(entity.getTypeId());
        accountDto.setClientId(entity.getClientId());
        accountDto.setLogoId(entity.getLogoId());
        accountDto.setCreated(entity.getCreated());
        accountDto.setUpdated(entity.getUpdated());

        return accountDto;
    }

}
