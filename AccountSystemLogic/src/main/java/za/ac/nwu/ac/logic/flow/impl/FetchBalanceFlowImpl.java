package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.BalanceDto;
import za.ac.nwu.ac.logic.flow.FetchBalanceFlow;
import za.ac.nwu.ac.translator.BalanceTranslator;

import javax.transaction.Transactional;


@Transactional
@Component
public class FetchBalanceFlowImpl implements FetchBalanceFlow {
    private final BalanceTranslator balanceTranslator;
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchBalanceFlowImpl.class);

    @Autowired
    public FetchBalanceFlowImpl(BalanceTranslator balanceTranslator){
        this.balanceTranslator = balanceTranslator;
    }
    @Override
    public BalanceDto getBalanceByMemberId(Long memberId)
    {
        LOGGER.info("The return object is {}", balanceTranslator.getBalanceByMemberId(memberId));
        return balanceTranslator.getBalanceByMemberId(memberId);
    }

}
