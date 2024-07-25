package com.account.service;

import com.account.payload.AccountDto;

public interface AccountService {
    public AccountDto createAccount(AccountDto accountDto);

    void deleteAccountById(long id);
}
