package za.ac.nwu.ac.domain.dto;

import io.swagger.annotations.ApiModel;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransactions")
public class AccountTransactionDto implements Serializable {
    private static final long serialVersionUID = -8094256495086775098L;

    private Long accountTxId;
    private String accountTypeMnemonic;
    private AccountType accountTypeId; // Foreign Key
    private Long memberId;
    private Long amount;
    private LocalDate txDate;
    private AccountTransactionDetailsDto details;

    public AccountTransactionDto() {

    }

    public AccountTransactionDto(Long accountTxId, String accountTypeMnemonic, Long memberId, Long amount,
                                 LocalDate txDate) {
        this.accountTxId = accountTxId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.txDate = txDate;
    }
    public AccountTransactionDto(Long accountTxId, String accountTypeMnemonic, Long memberId, Long amount,
                                 LocalDate txDate, AccountTransactionDetailsDto details) {
        this.accountTxId = accountTxId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.txDate = txDate;
        this.details = details;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.accountTxId = accountTransaction.getAccountTxId();
        this.accountTypeMnemonic = accountTransaction.getAccountTypeId().getMnemonic();
        this.memberId = accountTransaction.getMemberID();
        this.amount = accountTransaction.getAmount();
        this.txDate = accountTransaction.getTxDate();
        if (accountTransaction.getDetails() != null) {
            this.details = new AccountTransactionDetailsDto(accountTransaction.getDetails());
        }
    }

    public Long getAccountTxId() {
        return accountTxId;
    }

    public void setAccountTxId(Long accountTxId) {
        this.accountTxId = accountTxId;
    }

    public String getAccountTypeMnemonic() {
        return accountTypeMnemonic;
    }

    public void setAccountTypeMnemonic(String accountTypeMnemonic) {
        this.accountTypeMnemonic = accountTypeMnemonic;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getTxDate() {
        return txDate;
    }

    public void setTxDate(LocalDate txDate) {
        this.txDate = txDate;
    }
}
