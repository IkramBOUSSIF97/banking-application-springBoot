package com.ikram.banking.com.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
//@Builder    // pour creer de façon simple les objets
@Entity
public class Account extends AbstractEntity  {
//    @Id
//    @GeneratedValue
//    private Integer id;

    private String iban;

//    private LocalDateTime creationDate;
//    private LocalDateTime lastUpdated;

    @OneToOne
    @JoinColumn(name="id_user")
    private User users;
}
