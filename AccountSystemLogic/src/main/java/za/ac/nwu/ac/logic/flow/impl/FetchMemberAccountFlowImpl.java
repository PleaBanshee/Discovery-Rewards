package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberAccountDto;
import za.ac.nwu.ac.logic.flow.FetchMemberAccountFlow;
import za.ac.nwu.ac.translator.MemberAccountTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class FetchMemberAccountFlowImpl implements FetchMemberAccountFlow {
    private final MemberAccountTranslator translator;

    public FetchMemberAccountFlowImpl(MemberAccountTranslator translator) {
        this.translator = translator;
    }

    @Override
    public MemberAccountDto getMember(Long memberID, Long accountTypeID) {
        return translator.getMember(memberID, accountTypeID);
    }


}
