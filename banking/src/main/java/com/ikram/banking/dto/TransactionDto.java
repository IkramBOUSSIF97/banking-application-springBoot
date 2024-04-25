package com.ikram.banking.dto;

import com.ikram.banking.com.models.Account;
import com.ikram.banking.com.models.Transaction;
import com.ikram.banking.com.models.TransactionType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransactionDto {

    private Integer id;

    @Positive
    @Max(value= 1000000)
    @Min(value=10)
    private BigDecimal amount;
    private TransactionType type;
    private String destinationIban;
    private UserDto user;

  public static TransactionDto fromEntity(Transaction transaction) {
      return TransactionDto.builder()
              .id(transaction.getId())
              .amount(transaction.getAmount())
              .type(transaction.getType())
              .destinationIban(transaction.getDestinationIban())
              .build();

  }

  public static Transaction toEntity(TransactionDto transactionDto) {
      return Transaction.builder()
              .amount(transactionDto.getAmount())
              .type(transactionDto.getType())
              .destinationIban(transactionDto.destinationIban)
              .users(UserDto.toEntity(transactionDto.getUser()))
              .build();

  }
}
