package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;

@Component("createAccountTransactionFlowName")
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {
    private final AccountTransactionTranslator translator;

    @Autowired
    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator translator) {
        this.translator = translator;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransaction) {
        if (null == accountTransaction.getTxDate()) {
            accountTransaction.setTxDate(LocalDate.now());
        }
        return translator.create(accountTransaction);
    }
}
