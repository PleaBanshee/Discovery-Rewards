package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.MemberAccount;

@Repository
public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long> {
    @Query(value = "SELECT "+ "mb "+ "FROM " + "MemberAccount mb " + "WHERE " +
            "mb.memberID = :memberId " + "AND mb.accountTypeId = :accountTypeID")
    MemberAccount getMember(Long memberID, Long accountTypeID);


    @Modifying
    @Query(value = "UPDATE " + "MemberAccount mb " + "SET mb.accountBalance = :Balance " +
            "WHERE mb.memberId = :memberID " + "AND mb.accountTypeId = :accountTypeID")
    MemberAccount updateMemberAccount(@Param("Balance") Long accountBalance, @Param("memberID") Long memberID, @Param("accountTypeID") Long accountTypeID);
}