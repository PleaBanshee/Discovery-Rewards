//package za.ac.nwu.ac.translator.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
//import za.ac.nwu.ac.domain.dto.MemberAccountDto;
//import za.ac.nwu.ac.domain.persistence.MemberAccount;
//import za.ac.nwu.ac.repo.persistence.MemberAccountRepository;
//import za.ac.nwu.ac.translator.AccountTransactionTranslator;
//import za.ac.nwu.ac.translator.MemberAccountTranslator;
//
//import javax.transaction.Transactional;
//
//
//@Component
//public class MemberAccountTranslatorImpl implements MemberAccountTranslator {
//
//    private final MemberAccountRepository MemberAccountRepository;
//    private final AccountTransactionTranslator accountTransactionTranslator;
//
//    @Autowired
//    public MemberAccountTranslatorImpl(MemberAccountRepository MemberAccountRepository, AccountTransactionTranslator accountTransactionTranslator) {
//        this.MemberAccountRepository = MemberAccountRepository;
//        this.accountTransactionTranslator = accountTransactionTranslator;
//    }
//
//    @Override
//    public MemberAccountDto create(MemberAccountDto MemberAccountDto) {
//        try{
////            MemberAccountRepository.createSavePoint();
//            MemberAccount MemberAccount= MemberAccountRepository.save(MemberAccountDto.getMemberAccount());
////            MemberAccountRepository.commitDB();
//            return new MemberAccountDto(MemberAccount);
//        }catch (Exception e){
////            MemberAccountRepository.rollbackDB();
//            throw  new RuntimeException("Unable to save to the DB", e);
//        }
//    }
//
//    //ToDo: Fix UpdateMemberAccount
//    //ToDo: AccountTypeID cannot be called from within MemberAccount.!!
//    // Need to call from the transaction.
//    // Need to create rollback point, create transaction,
//    //      then run update, then commit/rollback
//
//    @Override
//    @Transactional
//    public MemberAccountDto updateMemberAccount(Integer TransactionAmount, Long memberID, Long accountTypeID) {
//
//        try{
//            Integer oldAccountBalance= 0;
//            Integer newAccountBalance= 0;
//
//            //ToDo: check if current value  is more than substract value
//            oldAccountBalance= getMemberByMemberIDandAccountTypeID(memberID,accountTypeID).getBalance();
//            //ToDO: Move to Logic
//            if( TransactionAmount + oldAccountBalance >=0 ){
//                AccountTransactionDto accountTransaction = accountTransactionTranslator.create(
//                        new AccountTransactionDto(memberID, accountTypeID, TransactionAmount));//ToDO: Remove
//
//                newAccountBalance = TransactionAmount + oldAccountBalance;//ToDO: Move to Logic
//                MemberAccount MemberAccount = MemberAccountRepository.updateMemberAccount(newAccountBalance, memberID, accountTypeID);
//                return new MemberAccountDto(MemberAccount);
//            }else{
//                //ToDo some catch or some shit
//                throw new RuntimeException("Cannot Subtract more currency that you own!");
//            }
//        }catch (Exception e){
//            throw new RuntimeException("Unable to update DB", e);
//        }
//
//
//    }
//
//    //ToDo: Create GetMemberByMemberIDandAccountTypeID
//
//    @Override
//    public MemberAccountDto getMemberByMemberIDandAccountTypeID(Long memberID, Long accountTypeID) {
//        try{
//            MemberAccount MemberAccount=MemberAccountRepository.getMemberByMemberIDandAccountTypeID(memberID, accountTypeID);
//            return new MemberAccountDto(MemberAccount);
//        }catch (Exception e){
//            throw new RuntimeException("Unable to read from the DB", e);
//        }
//
//    }
//
//}