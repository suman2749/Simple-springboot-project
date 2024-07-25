package com.account.service;

import com.account.entity.Account;
import com.account.payload.AccountDto;
import com.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
       Account account = mapToEntity(accountDto);
        Account saveEntity = accountRepository.save(account);
        AccountDto dto = mapToDto(saveEntity);
        dto.setMessege("Record Saved...");
        return dto;
    }
    Account mapToEntity(AccountDto accountDto){
        Account entity = new Account();
        entity.setName(accountDto.getName());
        entity.setCity(accountDto.getCity());
        entity.setType(accountDto.getType());
        entity.setBranch(accountDto.getBranch());
        entity.setMobile(accountDto.getMobile());
        entity.setEmail(accountDto.getEmail());
        return entity;
    }
    AccountDto mapToDto(Account account){
        AccountDto dto = new AccountDto();
        dto.setName(account.getName());
        dto.setCity(account.getCity());
        dto.setType(account.getBranch());
        dto.setBranch(account.getBranch());
        dto.setMobile(account.getMobile());
        dto.setEmail(account.getEmail());
        return dto;
    }
    public void deleteAccountById(long id){
        accountRepository.deleteById(id);
    }

    public List<AccountDto>listOfAcHolders(){
        List<Account> lists = accountRepository.findAll();
        List<AccountDto> collect = lists.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
        return collect;
    }
}
