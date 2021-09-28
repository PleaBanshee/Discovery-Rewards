package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountTransactionDetails;

import java.util.Objects;

public class AccountTransactionDetailsDto {
    private String memberName;
    private Long transactionVal;

    public AccountTransactionDetailsDto() {

    }

    public AccountTransactionDetailsDto(String memberName,Long transactionVal) {
        this.memberName = memberName;
        this.transactionVal = transactionVal;
    }

    public AccountTransactionDetailsDto(AccountTransactionDetails details) {
        this.memberName = details.getMemberName();
        this.transactionVal = details.getTransactionVal();
    }

    @JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails(AccountTransaction accountTransaction) {
        return new AccountTransactionDetails(accountTransaction,this.memberName,this.transactionVal);
    }

    @JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails() {
        return new AccountTransactionDetails(this.memberName,this.transactionVal);
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Long getTransactionVal() {
        return transactionVal;
    }

    public void setTransactionVal(Long transactionVal) {
        this.transactionVal = transactionVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDetailsDto that = (AccountTransactionDetailsDto) o;
        return Objects.equals(memberName, that.memberName) && Objects.equals(transactionVal, that.transactionVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberName, transactionVal);
    }

    @Override
    public String toString() {
        return "AccountTransactionDetailsDto{" +
                "memberName='" + memberName + '\'' +
                ", transactionVal=" + transactionVal +
                '}';
    }
}
