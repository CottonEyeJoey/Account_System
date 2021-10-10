package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.BalanceDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.BalanceTranslator;


import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTransactionFlowName")
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);
    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final BalanceTranslator balanceTranslator;


    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                            FetchAccountTypeFlow fetchAccountTypeFlow,BalanceTranslator balanceTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.balanceTranslator = balanceTranslator;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto,Boolean add){
        LOGGER.info("The input object was {}", accountTransactionDto);
        if(null == accountTransactionDto.getTransactionDate()){
            accountTransactionDto.setTransactionDate(LocalDate.now());
        }

        AccountTransactionDto results = accountTransactionTranslator.save(accountTransactionDto);
        LOGGER.info("The return object is {}", results);

        BalanceDto updateRequest = new BalanceDto(accountTransactionDto.getMemberId(),
                accountTransactionDto.getAccountTypeMnemonic(), add?accountTransactionDto.getAmount() : -accountTransactionDto.getAmount());
        LOGGER.info("The balance being updated is {}", updateRequest);
        BalanceDto updatedBalance = balanceTranslator.updateBalance(updateRequest);
        LOGGER.info("The new balance is {}", updatedBalance);
        return results;
    }
}
