package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.MemberAccountDto;
import za.ac.nwu.ac.domain.persistence.MemberAccount;
import za.ac.nwu.ac.repo.persistence.MemberAccountRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.MemberAccountTranslator;

import javax.transaction.Transactional;


@Component
public class MemberAccountTranslatorImpl implements MemberAccountTranslator {

    private final MemberAccountRepository repo;
    private final AccountTransactionTranslator translator;

    @Autowired
    public MemberAccountTranslatorImpl(MemberAccountRepository repo, AccountTransactionTranslator translator) {
        this.repo = repo;
        this.translator = translator;
    }

    @Override
    public MemberAccountDto create(MemberAccountDto MemberAccountDto) {
        try{
            MemberAccount MemberAccount= repo.save(MemberAccountDto.getMemberAccount());
            return new MemberAccountDto(MemberAccount);
        }catch (Exception e){
            throw  new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    @Transactional
    public MemberAccountDto updateMemberAccount(Integer amount, Long memberId, Long accountTypeId) {
        try {
            Integer AccountBalancePrev = 0;
            Integer AccountBalanceUpdate = 0;
            AccountBalancePrev = getMember(memberId,accountTypeId).getBalance();
            if( amount + AccountBalancePrev >= 0 ){
                AccountTransactionDto accountTransaction = translator.create(
                        new AccountTransactionDto(memberId, accountTypeId, amount));
                AccountBalanceUpdate = amount + AccountBalancePrev;
                MemberAccount MemberAccount = repo.updateMemberAccount(AccountBalanceUpdate, memberId, accountTypeId);
                return new MemberAccountDto(MemberAccount);
            } else {
                throw new RuntimeException("Cannot subtract an amount larger than your current account balance");
            }
        } catch (Exception e){
            throw new RuntimeException("Unable to update DB", e);
        }
    }

    @Override
    public MemberAccountDto getMember(Long memberID, Long accountTypeID) {
        try {
            MemberAccount MemberAccount=repo.getMember(memberID, accountTypeID);
            return new MemberAccountDto(MemberAccount);
        } catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

}