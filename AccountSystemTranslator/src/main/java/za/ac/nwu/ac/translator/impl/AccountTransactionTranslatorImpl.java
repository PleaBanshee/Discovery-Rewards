package za.ac.nwu.ac.translator.impl;

import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {
    private AccountTransactionRepository repo;

    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTypeRepository) {
        this.repo = accountTypeRepository;
    }

    @Override
    public List<AccountTransaction> getAllAccountTransactions() {
        List<AccountTransaction> accountTransactions;
        try {
            accountTransactions = new ArrayList<>(repo.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the database",e);
        }
    }

    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionId) {
        try {
            return repo.findById(transactionId).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the database",e);
        }
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction) {
        try {
            return repo.save(accountTransaction);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the database",e);
        }
    }
}