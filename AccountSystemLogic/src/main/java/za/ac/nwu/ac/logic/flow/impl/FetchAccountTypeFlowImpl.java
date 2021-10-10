package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchAccountTypeFlowImpl.class);
    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }
    @Override
    public List<AccountTypeDto> getAllAccountTypes(){
        LOGGER.info("The return object is {}", accountTypeTranslator.getAllAccountTypes());
        return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic)
    {
        LOGGER.info("The return object is {}", accountTypeTranslator.getAccountTypeByMnemonic(mnemonic))
;       return accountTypeTranslator.getAccountTypeByMnemonic(mnemonic);
    }


}
