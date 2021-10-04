//package za.ac.nwu.ac.domain.persistence;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.util.Objects;
//
//@Entity
//@Table(name = "MEMBER_ACCOUNT", schema = "HR")
//public class MemberAccount implements Serializable {
//    private static final long serialVersionUID = -6632638440092162565L;
//    private Long MemberAccountID;
//    private Long memberID;
//    private Long accountTypeID;
//    private Long Balance;
//    private LocalDate creationDate;
//
//    public MemberAccount(Long MemberAccountID, Long memberID, Long accountTypeID, Long Balance, LocalDate creationDate) {
//        this.MemberAccountID = MemberAccountID;
//        this.memberID = memberID;
//        this.accountTypeID = accountTypeID;
//        this.Balance = Balance;
//        this.creationDate = creationDate;
//    }
//    public MemberAccount(Long memberID, Long accountTypeID, Long Balance, LocalDate creationDate) {
//        this.memberID = memberID;
//        this.accountTypeID = accountTypeID;
//        this.Balance = Balance;
//        this.creationDate = creationDate;
//    }
//
//    @Id
//    @SequenceGenerator(name = "SEQ_Member_ACCOUNT_ID", sequenceName = "DISCOVERYSYSTEM.SEQ_Member_ACCOUNT_ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Member_ACCOUNT_ID")
//    @Column(name = "Member_ACCOUNT_ID")
//    public Long getMemberAccountID() {
//        return MemberAccountID;
//    }
//
//    public void setMemberAccountID(Long MemberAccountID) {
//        this.MemberAccountID = MemberAccountID;
//    }
//
//    @Column(name = "MEMBER_ID")
//    public Long getMemberID() {
//        return memberID;
//    }
//
//    public void setMemberID(Long memberID) {
//        this.memberID = memberID;
//    }
//
//    @Column(name = "ACCOUNT_TYPE_ID")
//    public Long getAccountTypeID() {
//        return accountTypeID;
//    }
//
//    public void setAccountTypeID(Long accountTypeID) {
//        this.accountTypeID = accountTypeID;
//    }
//
//    @Column(name = "ACCOUNT_BALANCE")
//    public Long getBalance() {
//        return Balance;
//    }
//
//    public void setBalance(Long Balance) {
//        this.Balance = Balance;
//    }
//
//    @Column(name = "CREATION_DATE")
//    public LocalDate getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(LocalDate creationDate) {
//        this.creationDate = creationDate;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MemberAccount that = (MemberAccount) o;
//        return Objects.equals(MemberAccountID, that.MemberAccountID) && Objects.equals(memberID, that.memberID) && Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(Balance, that.Balance) && Objects.equals(creationDate, that.creationDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(MemberAccountID, memberID, accountTypeID, Balance, creationDate);
//    }
//
//    @Override
//    public java.lang.String toString() {
//        return "MemberAccount{" +
//                "MemberAccountID=" + MemberAccountID +
//                ", memberID=" + memberID +
//                ", accountTypeID=" + accountTypeID +
//                ", Balance=" + Balance +
//                ", creationDate=" + creationDate +
//                '}';
//    }
//}