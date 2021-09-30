package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {
    private final AccountTransactionRepository repo;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository repo) {
        this.repo = repo;
    }

    public AccountTransaction save(AccountTransaction accountTransaction) {
        try {
            return repo.save(accountTransaction);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the database",e);
        }
    }

    public List<AccountTransaction> getAllTransactions() {
        List<AccountTransaction> accountTransactions;
        try {
            accountTransactions = new ArrayList<>(repo.findAll());
        } catch (Exception e) {
            // TODO: Log
            throw new RuntimeException("Unable to read from the database",e);
        }
        return accountTransactions;
    }

    public AccountTransactionDto create(AccountTransactionDto accountTransaction) {
        try {
            AccountTransaction transaction = repo.save(accountTransaction.getTransaction());
            return new AccountTransactionDto(transaction);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the database",e);
        }
    }

    public AccountTransaction getAccountTransactionById(Long id) {
        try {
            return repo.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the database",e);
        }
    }
}
