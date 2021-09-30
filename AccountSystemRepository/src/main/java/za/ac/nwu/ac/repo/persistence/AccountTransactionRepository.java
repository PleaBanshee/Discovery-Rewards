package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Long > {

    @Query( // NB! Not recommended to use, since query won't work if you change databases, due to native nature
            value = "SELECT "+"ACCOUNT_TYPE_ID,"+"ACCOUNT_TYPE_NAME,"+"CREATION_DATE,"+"MNEMONIC "+
                    "FROM "+"HR.ACCOUNT_TYPE "+"WHERE MNEMONIC = :mnemonic", nativeQuery = true
    )
    AccountTransaction getAccountTransactionById(Long id);
}
