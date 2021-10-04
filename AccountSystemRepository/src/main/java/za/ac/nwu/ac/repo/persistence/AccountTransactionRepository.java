package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTransactionDto(" +
            "at.memberId," + "at.amount," + "at.txDate)" +" FROM " +
            "AccountTransaction at" + " WHERE at.memberId = :memberId ")
    AccountTransactionDto getAccountTransactionDtoByMnemonic(Long memberId);
}