package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.BalanceDto;

public interface FetchBalanceFlow {
    BalanceDto getBalanceByMemberId(Long memberId);
}
