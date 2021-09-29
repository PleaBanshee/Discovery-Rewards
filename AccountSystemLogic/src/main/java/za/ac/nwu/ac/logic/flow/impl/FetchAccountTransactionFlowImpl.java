package za.ac.nwu.ac.logic.flow.impl;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow {
    private AccountTransactionTranslator translator;

    public FetchAccountTransactionFlowImpl(AccountTransactionTranslator translator) {
        this.translator = translator;
    }

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions() {
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        for (AccountTransaction accountTransaction : translator.getAllAccountTransactions()) {
            accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
        }
        return accountTransactionDtos;
    }

    @Override
    public AccountTransactionDto getAccountTransactionById(Long transactionId) {
        AccountTransaction accountTransaction = translator.getAccountTransactionByPk(transactionId);
        return accountTransaction != null ? new AccountTransactionDto(accountTransaction) : null;
    }
}
