package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accountType",schema = "HR")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 3866606557126890054L;
    private Long accountTypeID;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;
    private Set<AccountTransaction> accountTransactions;

    public AccountType(Long accountTypeID, String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.accountTypeID = accountTypeID;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountType() {

    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate) {
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @Id
    @SequenceGenerator(name="ACC_TYPE_SEQ",sequenceName = "HR.ACC_TYPE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACC_TYPE_SEQ")
    @Column(name = "accountTypeID")
    public Long getAccountTypeID() {
        return accountTypeID;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name="mnemonic")
    public String getMnemonic() {
        return mnemonic;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Column(name="")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name="creationDate")
    public LocalDate getCreationDate() {
        return creationDate;
    }



    // One Account can have many Transactions.
    // mappedBy: sets equal to variable in other Entity
    // orphanRemoval: everything that gets deleted in this entity, will also be removed from the other entity
    // cascade: determines whether to save data entity values
    @OneToMany(targetEntity = AccountTransaction.class,fetch = FetchType.LAZY,mappedBy = "accountTypeID",orphanRemoval = true,cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions; // returns a list without duplicate values
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return accountTypeID == that.accountTypeID && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeID=" + accountTypeID +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
