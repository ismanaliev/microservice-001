package com.javastart.account.service;

import com.javastart.account.dto.AccountResponseDTO;
import com.javastart.account.entity.Account;
import com.javastart.account.exception.AccountNotFoundException;
import com.javastart.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

public Account getAccountById(Long accountId) {
    return accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Unable account with id: " + accountId));
}
    public Long createAccount(String name, String email, String phone, List<Long> bills){
        Account account=new Account();
        account.setName(name);
        account.setEmail(email);
        account.setPhone(phone);
        account.setBills(bills);
        account.setCreationDate(OffsetDateTime.now());
        return accountRepository.save(account).getAccountId();
    }
    public Account updateAccount(Long accountId,String name,String email,String phone,List<Long> bills) {
        Account account=getAccountById(accountId);
        account.setName(name);
        account.setPhone(phone);
        account.setCreationDate(OffsetDateTime.now());
        account.setEmail(email);
        account.setBills(bills);
        return accountRepository.save(account);
}
public AccountResponseDTO accountToResponse(Account a){
    AccountResponseDTO accountResponseDTO= new AccountResponseDTO();
    accountResponseDTO.setName(a.getName());
    accountResponseDTO.setPhone(a.getPhone());
    accountResponseDTO.setEmail(a.getEmail());
    accountResponseDTO.setCreationDate(a.getCreationDate());
    accountResponseDTO.setBills(a.getBills());
    accountResponseDTO.setAccountId(a.getAccountId());
    return accountResponseDTO;
}
public Account deleteAccount(Long accountId){
    accountRepository.deleteById(accountId);
    return getAccountById(accountId);
}
}
