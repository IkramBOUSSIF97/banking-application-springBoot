package com.ikram.banking.repositories;

import com.ikram.banking.com.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findByIban(String iban);
}
