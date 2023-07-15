package com.javastart.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private String name;
    private String phone;
    private String email;
    private OffsetDateTime creationDate;
    @ElementCollection
    private List<Long> bills;








}
