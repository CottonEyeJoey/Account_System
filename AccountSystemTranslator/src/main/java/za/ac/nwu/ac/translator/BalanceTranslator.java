package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.BalanceDto;


public interface BalanceTranslator {
    BalanceDto getBalanceByMemberId(Long memberId);
    BalanceDto updateBalance(BalanceDto balanceDto);
}
