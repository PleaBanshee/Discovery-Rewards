package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TX_DETAILS", schema = "HR")
public class AccountTransactionDetails implements Serializable {
    private static final long serialVersionUID = -1015768182985348357L;

    private Long accountTransactionDetailsId;
    private AccountTransaction accountTransaction;
    private String memberName;
    private Long transactionVal;

    public AccountTransactionDetails (AccountTransaction accountTransaction, String memberName, Long transactionVal) {
        this.accountTransaction = accountTransaction;
        this.memberName = memberName;
        this.transactionVal = transactionVal;
    }

    public AccountTransactionDetails (String memberName, Long transactionVal) {
        this.memberName = memberName;
        this.transactionVal = transactionVal;
    }

    @Id
    @SequenceGenerator(name="ACC_TX_DETAILS_SEQ",sequenceName = "HR.ACC_TX_DETAILS_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACC_TX_DETAILS_SEQ")
    @Column(name = "Account_Tx_Detail_ID")
    public Long getAccountTransactionDetailsId() {
        return accountTransactionDetailsId;
    }

    public void setAccountTransactionDetailsId(Long accountTransactionDetailsId) {
        this.accountTransactionDetailsId = accountTransactionDetailsId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_TX_ID")
    public AccountTransaction getAccountTransaction() {
        return accountTransaction;
    }

    public AccountTransaction setAccountTransaction(AccountTransaction accountTransaction) {
        return this.accountTransaction = accountTransaction;
    }

    @Column(name = "MemberName")
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Column(name = "Transaction_Val")
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
        AccountTransactionDetails that = (AccountTransactionDetails) o;
        return Objects.equals(accountTransactionDetailsId, that.accountTransactionDetailsId) &&
                Objects.equals(accountTransaction, that.accountTransaction) &&
                Objects.equals(memberName, that.memberName) && Objects.equals(transactionVal, that.transactionVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransactionDetailsId, accountTransaction, memberName, transactionVal);
    }

    @Override
    public String toString() {
        return "AccountTransactionDetails{" +
                "accountTransactionDetailsId=" + accountTransactionDetailsId +
                ", accountTransaction=" + accountTransaction +
                ", memberName='" + memberName + '\'' +
                ", transactionVal=" + transactionVal +
                '}';
    }
}
