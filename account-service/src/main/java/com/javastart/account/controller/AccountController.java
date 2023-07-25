package com.javastart.account.controller;

import com.javastart.account.dto.AccountResponseDTO;
import com.javastart.account.dto.AccountRequestDTO;
import com.javastart.account.entity.Account;
import com.javastart.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import jakarta.persistence.*;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getAccount/{accountId}")
    public AccountResponseDTO getAccount(@PathVariable Long accountId) {
        Account account=(accountService.getAccountById(accountId));
        return accountService.accountToResponse(account);
    }

    @PostMapping("/addAccount/")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(accountRequestDTO.getName(), accountRequestDTO.getEmail(),
          accountRequestDTO.getPhone(),accountRequestDTO.getBills());
    }

    @PutMapping("/updateAccount/{accountId}")
    public AccountResponseDTO updateAccount(@PathVariable Long accountId, @RequestBody AccountRequestDTO accountRequestDTO) {
        Account account=(accountService.updateAccount(accountId, accountRequestDTO.getName(), accountRequestDTO.getEmail(),
                accountRequestDTO.getPhone(), accountRequestDTO.getBills()));
        return accountService.accountToResponse(account);
    }

    @DeleteMapping("/deleteAccount/{accountId}")
    public AccountResponseDTO deleteAccount(@PathVariable Long accountId) {
        return accountService.accountToResponse(accountService.deleteAccount(accountId));
    }
}

