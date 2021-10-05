package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberAccountDto;

public interface ModifyMemberAccountFlow {
    MemberAccountDto updateMemberAccount(Integer amount, Long memberId, Long accountTypeId);
}
