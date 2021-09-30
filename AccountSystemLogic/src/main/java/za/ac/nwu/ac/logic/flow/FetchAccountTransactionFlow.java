package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.util.List;

public interface FetchAccountTransactionFlow {
    List<AccountTransactionDto> getAllTransactions();
    AccountTransactionDto getAccountTransactionById(Long id);
}
