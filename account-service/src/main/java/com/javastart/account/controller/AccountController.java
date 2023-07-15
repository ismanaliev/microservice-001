//package com.javastart.account.controller;
//
//import com.javastart.account.dto.AccountRequestDTO;
//import com.javastart.account.dto.AccountResponseDTO;
//import com.javastart.account.entity.Account;
//import com.javastart.account.service.AccountService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@AllArgsConstructor
//public class AccountController {
//    private final AccountService accountService;
//    @GetMapping("/accountId")
//    public AccountResponseDTO getAccounts(@PathVariable("accountId") Long accountId){
//        return new AccountResponseDTO( accountService.getAccountById(accountId));
//    }
//    @PostMapping("/")
//    public Account createAccount(@RequestBody AccountRequestDTO a){
//        return (Account) accountService.createAccount(a.getName(),a.getEmail(),a.getPhone());
//    }
//    @PutMapping("/accountId")
//    public AccountResponseDTO updateAccount(@PathVariable Long accountId, @RequestBody AccountRequestDTO a){
//        Account account=accountService.updateAccount(accountId,a.getName(),a.getEmail(),a.getPhone());
//        return null;
//    }
//    @DeleteMapping
//    public A
//
//}
package com.javastart.account.controller;

import com.javastart.account.dto.AccountResponseDTO;
import com.javastart.account.dto.AccountRequestDTO;
import com.javastart.account.entity.Account;
import com.javastart.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/createAccount/")
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

