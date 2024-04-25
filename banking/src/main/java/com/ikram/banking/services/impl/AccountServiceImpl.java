package com.ikram.banking.services.impl;

import com.ikram.banking.com.models.Account;
import com.ikram.banking.dto.AccountDto;
import com.ikram.banking.exceptions.OperationNonPermittedException;
import com.ikram.banking.repositories.AccountRepository;
import com.ikram.banking.services.AccountService;
import com.ikram.banking.validators.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final ObjectValidator validator;
    @Override
    public Integer save(AccountDto dto) {
        if(dto.getId() != null) {
            throw new OperationNonPermittedException(
                    "Account cannot be updated ",
                    "save account",
                    "Account",
                    "Update not permitted"
            );
        }
        validator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        // todo generate random IBAN
        account.setIban(generateRandomIban());
        return repository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
        //  stream() convertit cette liste en streams (une flux de donnees)
    }

    @Override
    public AccountDto findById(Integer id) {
        return repository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No account was found with the ID :" +id));
    }

    @Override
    public void delete(Integer id) {
     // todo check delete account
        repository.deleteById(id);
    }
    private String generateRandomIban() {
        // todo generate an IBAN
    String iban = Iban.random(CountryCode.DE).toFormattedString();
        // check if the iban exists
       boolean ibanExists =  repository.findByIban(iban).isPresent();
       // or boolean ibanNotExists = repository.findByIban(iban).isEmpty();


        // if exists -> generate new random iban
     if(ibanExists) {
         generateRandomIban();
     }
        // if not exist -> return generated iban

        return iban;
    }
}
