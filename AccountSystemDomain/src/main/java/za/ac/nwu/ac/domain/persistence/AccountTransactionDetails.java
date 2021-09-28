package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;

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
}
