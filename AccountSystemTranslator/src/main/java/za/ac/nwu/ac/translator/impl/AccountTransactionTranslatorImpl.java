package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {
    private  AccountTransactionRepository accountTransactionRepository;
    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository,AccountTypeRepository accountTypeRepository){
        this.accountTransactionRepository = accountTransactionRepository;
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public AccountTransactionDto save(AccountTransactionDto accountTransactionDto){

        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
            AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);
            return new AccountTransactionDto(accountTransactionRepository.save(accountTransaction));
        } catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
