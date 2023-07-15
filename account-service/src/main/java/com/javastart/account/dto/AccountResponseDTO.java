package com.javastart.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AccountResponseDTO {
    private Long accountId;
    private String phone;
    private String name;
    private List<Long> bills;
    private String email;
    private OffsetDateTime creationDate;



}
