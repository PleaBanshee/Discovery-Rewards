package za.ac.nwu.ac.domain.dto;

import io.swagger.annotations.ApiModel;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransactions")
public class AccountTransactionDto implements Serializable {
    private AccountType accountTypeId; // Foreign Key
    private Long memberId;
    private Long amount;
    private LocalDate txDate;
}
