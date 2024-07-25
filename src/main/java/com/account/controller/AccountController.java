package com.account.controller;

import com.account.payload.AccountDto;
import com.account.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/createAccount")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto accountDto){
        AccountDto account = accountService.createAccount(accountDto);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAccountById(@RequestParam long id){
        accountService.deleteAccountById(id);
        return new ResponseEntity<>("Deleted..",HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<AccountDto>>accountHoldersList(){
        List<AccountDto> accountDtos = accountService.listOfAcHolders();
        return new ResponseEntity<>(accountDtos,HttpStatus.OK);
    }
}
