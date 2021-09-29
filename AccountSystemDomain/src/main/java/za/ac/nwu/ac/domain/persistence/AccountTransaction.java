package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANSACTION",schema = "HR")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 1199041377884282633L;
    private Long accountTxId;
    private AccountType accountTypeId; // Foreign Key
    private Long memberId;
    private Long amount;
    private LocalDate txDate;
    private AccountTransactionDetails details;

    public AccountTransaction(Long accountTxId, AccountType accountTypeId, Long memberId, Long amount, LocalDate txDate) {
        this.accountTxId = accountTxId;
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.txDate = txDate;
    }

    public AccountTransaction() {
    }

    public void setAccountTxId(Long accountTxId) {
        this.accountTxId = accountTxId;
    }

    @Id
    @SequenceGenerator(name="ACC_TX_SEQ",sequenceName = "HR.ACC_TX_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACC_TX_SEQ")
    @Column(name = "Account_TX_ID")
    public Long getAccountTxId() {
        return accountTxId;
    }

    // Lazy fetch: fetch data when needed
    @ManyToOne(fetch = FetchType.LAZY) // One account can have many transactions
    @JoinColumn(name="Account_Type_ID")
    public AccountType getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setMemberID(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name="Member_ID")
    public Long getMemberID() {
        return memberId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name="Amount")
    public Long getAmount() {
        return amount;
    }

    public void setTxDate(LocalDate txDate) {
        this.txDate = txDate;
    }

    @Column(name="TX_Date")
    public LocalDate getTxDate() {
        return txDate;
    }

    @OneToOne(targetEntity = AccountTransactionDetails.class,fetch = FetchType.LAZY,mappedBy = "accountTransaction")
    public AccountTransactionDetails getDetails() {
        return details;
    }

    public void setDetails(AccountTransactionDetails details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(accountTxId, that.accountTxId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(txDate, that.txDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTxId, accountTypeId, memberId, amount, txDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTxID=" + accountTxId +
                ", accountTypeID=" + accountTypeId +
                ", memberID=" + memberId +
                ", amount=" + amount +
                ", txDate=" + txDate +
                '}';
    }
}
