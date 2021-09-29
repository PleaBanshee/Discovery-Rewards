package za.ac.nwu.ac.logic.flow.impl;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

public interface CreateAccountTransactionFlow {
    AccountTransactionDto create(AccountTransactionDto accountTransaction);
}
