package com.ikram.banking.dto;

import com.ikram.banking.com.models.Account;
import com.ikram.banking.com.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AccountDto {
    private Integer id;
    private String iban;
    private UserDto user;

    public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .iban(account.getIban())
                .user(UserDto.fromEntity(account.getUsers()))
                .build();
    }

    public static Account toEntity(AccountDto accountDto) {
        return Account.builder()
                .iban(accountDto.getIban())
                .users(UserDto.toEntity(accountDto.getUser()))
                .build();
    }

}
