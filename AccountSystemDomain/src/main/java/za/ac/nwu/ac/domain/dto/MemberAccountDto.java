package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.MemberAccount;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@ApiModel(value = "MemberAccount", description = "This DTO represents the MemberAccount")
public class MemberAccountDto implements Serializable {
    private static final long serialVersionUID = 5951234213607822710L;
    private Long memberID;
    private Long accountTypeID;
    private Long balance;
    private LocalDate creationDate;

    public MemberAccountDto() {
    }

    public MemberAccountDto(Long memberID, Long accountTypeID, Long balance, LocalDate creationDate) {
        this.memberID = memberID;
        this.accountTypeID = accountTypeID;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    public MemberAccountDto(MemberAccount MemberAccount){
        this.memberID = MemberAccount.getMemberId();
        this.accountTypeID =MemberAccount.getAccountTypeId();
        this.balance =MemberAccount.getBalance();
        this.creationDate = MemberAccount.getCreationDate();
    }

    @ApiModelProperty(
            position = 1,
            value = "MemberAccount MemberID",
            name = "MemberID",
            notes = "Unique Member ID for the Member that owns the account",
            dataType = "java.lang.String",
            example ="100000000000001",
            required = true)
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @ApiModelProperty(
            position = 2,
            value = "MemberAccount AccountType",
            name = "AccountTypeID",
            notes = "The AccountTypeID for the specific AccountType",
            dataType = "java.lang.String",
            example = "100000000000003",
            required = true
    )
    public Long getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @ApiModelProperty(
            position = 3,
            value = "MemberAccount Account Balance",
            name = "balance",
            notes = "Contains the amount of a currency that a User " +
                    "has in their account and is allowed to spend.",
            dataType = "java.lang.Integer",
            example = "42069",
            required = true
    )
    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @ApiModelProperty(
            position = 4,
            value = "MemberAccount Creation Date",
            name = "The creation date of the MemberAccount",
            dataType = "java.lang.String",
            example = "2020-01-01",
            required = true
    )
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAccountDto that = (MemberAccountDto) o;
        return Objects.equals(memberID, that.memberID) && Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(balance, that.balance) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, accountTypeID, balance, creationDate);
    }

    @JsonIgnore
    public MemberAccount getMemberAccount(){
        return new MemberAccount(getMemberID(), getAccountTypeID(), getBalance(), getCreationDate());
    }

    @Override
    public java.lang.String toString() {
        return "MemberAccountDto{" +
                "memberID=" + memberID +
                ", accountTypeID=" + accountTypeID +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                '}';
    }
}