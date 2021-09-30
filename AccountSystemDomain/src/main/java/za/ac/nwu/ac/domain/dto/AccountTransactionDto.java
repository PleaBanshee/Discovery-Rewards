package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -7819344808062462808L;
    private AccountType accountTypeId;
    private Long memberId;
    private Long amount;
    private LocalDate txDate;

    public AccountTransactionDto(AccountType accountTypeId, Long memberId, Long amount, LocalDate txDate) {
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.txDate = txDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.setAccountTypeId(accountTransaction.getAccountTypeId());
        this.setMemberId(accountTransaction.getMemberID());
        this.setAmount(accountTransaction.getAmount());
        this.setTxDate(accountTransaction.getTxDate());
    }

    public AccountTransactionDto() {

    }

    @ApiModelProperty(
            position = 1,
            value = "AccountType",
            name = "accountType",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true
    )
    public AccountType getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
    }


    @ApiModelProperty(
            position = 2,
            value = "Member ID",
            name = "memberId",
            notes = "Uniquely identifies a member",
            dataType = "java.lang.String",
            example = "1001",
            required = true
    )
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(
            position =3,
            value = "Amount",
            name = "Amount",
            notes = "Amount on the member's account",
            dataType = "java.lang.String",
            example = "200",
            required = true
    )
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @ApiModelProperty(
            position = 1,
            value = "Transaction Date",
            name = "txDate",
            notes = "The date the transaction occurred",
            dataType = "java.lang.String",
            example = "2021-02-01",
            required = true
    )
    public LocalDate getTxDate() {
        return txDate;
    }

    public void setTxDate(LocalDate txDate) {
        this.txDate = txDate;
    }

    @JsonIgnore
    public AccountTransaction getTransaction() {
        return new AccountTransaction(getAccountTypeId(),getMemberId(),getAmount(),getTxDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(txDate, that.txDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, memberId, amount, txDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountTypeId=" + accountTypeId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", txDate=" + txDate +
                '}';
    }
}
