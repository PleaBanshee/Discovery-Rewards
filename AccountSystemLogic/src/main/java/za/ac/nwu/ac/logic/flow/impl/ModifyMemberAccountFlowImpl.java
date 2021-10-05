package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberAccountDto;
import za.ac.nwu.ac.logic.flow.ModifyMemberAccountFlow;
import za.ac.nwu.ac.translator.MemberAccountTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("modifyMemberAccountFlowName")
public class ModifyMemberAccountFlowImpl implements ModifyMemberAccountFlow {

    private final MemberAccountTranslator translator;

    public ModifyMemberAccountFlowImpl(MemberAccountTranslator translator) {
        this.translator = translator;
    }

    @Override
    public MemberAccountDto updateMemberAccount(Integer amount, Long memberId, Long accountTypeId){
        return translator.updateMemberAccount(amount, memberId, accountTypeId);
    }

}
