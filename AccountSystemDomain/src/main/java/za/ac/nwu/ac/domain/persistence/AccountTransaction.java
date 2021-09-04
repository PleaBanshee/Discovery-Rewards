package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANSACTION",schema = "HR")
public class AccountTransaction implements Serializable {

    private Long accountTxID;
    private AccountType accountTypeID; // Foreign Key
    private Long memberID;
    private Long amount;
    private LocalDate txDate;

    public AccountTransaction(Long accountTxID, AccountType accountTypeID, Long memberID, Long amount, LocalDate txDate) {
        this.accountTxID = accountTxID;
        this.accountTypeID = accountTypeID;
        this.memberID = memberID;
        this.amount = amount;
        this.txDate = txDate;
    }

    public AccountTransaction() {
    }

    @Id
    @SequenceGenerator(name="ACC_TX_SEQ",sequenceName = "ACC_TX_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACC_TX_SEQ")
    @Column(name = "ACCOUNT_TX_ID")
    public Long getAccountTxID() {
        return accountTxID;
    }

    public void setAccountTxID(Long accountTxID) {
        this.accountTxID = accountTxID;
    }

    // Laze fetch: fetch data when needed
    @ManyToOne(fetch = FetchType.LAZY) // One account can have many transactions
    @JoinColumn(name="ACCOUNT_TYPE_ID")
    public AccountType getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(AccountType accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @Column(name="MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @Column(name="AMOUNT")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name="TX_DATE")
    public LocalDate getTxDate() {
        return txDate;
    }

    public void setTxDate(LocalDate txDate) {
        this.txDate = txDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(accountTxID, that.accountTxID) && Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(memberID, that.memberID) && Objects.equals(amount, that.amount) && Objects.equals(txDate, that.txDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTxID, accountTypeID, memberID, amount, txDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTxID=" + accountTxID +
                ", accountTypeID=" + accountTypeID +
                ", memberID=" + memberID +
                ", amount=" + amount +
                ", txDate=" + txDate +
                '}';
    }
}
