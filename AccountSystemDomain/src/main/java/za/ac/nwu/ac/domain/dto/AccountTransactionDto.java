package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -7819344808062462808L;
    private Long memberId;
    private Long amount;
    private LocalDate txDate;

    public AccountTransactionDto(Long memberId, Long amount, LocalDate txDate) {
        this.memberId = memberId;
        this.amount = amount;
        this.txDate = txDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.setMemberId(accountTransaction.getMemberID());
        this.setAmount(accountTransaction.getAmount());
        this.setTxDate(accountTransaction.getTxDate());
    }

    public AccountTransactionDto() {

    }

    @ApiModelProperty(
            position = 1,
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
            position =2,
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
            position = 3,
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
        return new AccountTransaction(getMemberId(),getAmount(),getTxDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(txDate, that.txDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, amount, txDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "memberId=" + memberId +
                ", amount=" + amount +
                ", txDate=" + txDate +
                '}';
    }
}
