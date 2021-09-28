package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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

    @JsonIgnore
    public AccountTransaction buildAccountTransaction(AccountType accountType) {
        return new AccountTransaction(this.getAccountTxId(), accountType, this.getMemberId(),
                this.getAmount(), this.getTxDate());
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

    public AccountTransactionDetailsDto getDetails() {
        return details;
    }

    public void setDetails(AccountTransactionDetailsDto details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(accountTxId, that.accountTxId) && Objects.equals(accountTypeMnemonic,
                that.accountTypeMnemonic) && Objects.equals(accountTypeId, that.accountTypeId) &&
                Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) &&
                Objects.equals(txDate, that.txDate) && Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTxId, accountTypeMnemonic, accountTypeId, memberId, amount, txDate, details);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountTxId=" + accountTxId +
                ", accountTypeMnemonic='" + accountTypeMnemonic + '\'' +
                ", accountTypeId=" + accountTypeId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", txDate=" + txDate +
                ", details=" + details +
                '}';
    }
}
