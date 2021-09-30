package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.util.List;

public interface AccountTransactionTranslator {
    List<AccountTransaction> getAllTransactions();

    AccountTransactionDto create(AccountTransactionDto accountTransaction);

    AccountTransaction getAccountTransactionById(Long id);

    AccountTransaction save(AccountTransaction accountTransaction);
}
