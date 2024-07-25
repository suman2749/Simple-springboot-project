package com.account.service;

import com.account.payload.AccountDto;

import java.util.List;

public interface AccountService {
    public AccountDto createAccount(AccountDto accountDto);

    public List<AccountDto> listOfAcHolders ();

    void deleteAccountById(long id);
}
