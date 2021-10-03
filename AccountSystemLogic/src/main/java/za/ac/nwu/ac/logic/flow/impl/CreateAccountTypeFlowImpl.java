package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTypeFlowImpl.class);
    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType){
        LOGGER.info("The input object was {}", accountType);
        if(null == accountType.getCreationDate()){
             accountType.setCreationDate(LocalDate.now());
        }
        AccountTypeDto results = accountTypeTranslator.create(accountType);
        LOGGER.info("The return object is {}", results);
        return results;
    }
}
