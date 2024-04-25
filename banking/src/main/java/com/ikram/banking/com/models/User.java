package com.ikram.banking.com.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="_user")
public class User extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private Integer id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private boolean active;

    @OneToMany(mappedBy="users")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "users")
    private List<Contact> contacts;

    @OneToOne
    private Account account;

    @OneToOne
    private Address address;

    @OneToOne
    private Role role;

}
