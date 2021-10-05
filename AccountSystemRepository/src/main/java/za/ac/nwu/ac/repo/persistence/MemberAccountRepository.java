package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.MemberAccount;

@Repository
public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long> {
    @Query(value = "SELECT "+
            "ua "+
            "FROM " +
            "MemberAccount ua " +
            "WHERE " +
            "ua.memberID = :memberID " +
            "AND ua.accountTypeID = :accountTypeID")
    MemberAccount getMemberByMemberIDandAccountTypeID(Long memberID, Long accountTypeID);


    @Modifying
    @Query(value = "UPDATE " +
            "MemberAccount ua " +
            "SET ua.accountBalance = :accountBalance " +
            "WHERE ua.memberID = :memberID " +
            "AND ua.accountTypeID = :accountTypeID")
    MemberAccount updateMemberAccount(@Param("accountBalance") Integer accountBalance, @Param("memberID") Long memberID, @Param("accountTypeID") Long accountTypeID);
}