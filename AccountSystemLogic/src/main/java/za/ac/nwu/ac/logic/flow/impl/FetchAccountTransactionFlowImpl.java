package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow {
    private AccountTransactionTranslator translator;

    public FetchAccountTransactionFlowImpl (AccountTransactionTranslator translator) {
        this.translator = translator;
    }

    public List<AccountTransactionDto> getAllTransactions() {
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        for (AccountTransaction accountTransaction: translator.getAllTransactions()) {
            accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
        }
        return accountTransactionDtos;
    }

    public AccountTransactionDto getAccountTransactionById(Long id) {
        AccountTransaction accountTransaction = translator.getAccountTransactionById(id);
        return accountTransaction != null ? new AccountTransactionDto(accountTransaction) : null;
    }
}
