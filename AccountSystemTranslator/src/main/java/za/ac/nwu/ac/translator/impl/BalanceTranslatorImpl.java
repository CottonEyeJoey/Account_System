package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.BalanceDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Balance;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.repo.persistence.BalanceRepository;
import za.ac.nwu.ac.translator.BalanceTranslator;

import java.util.Optional;

@Component
public class BalanceTranslatorImpl implements BalanceTranslator {

    private final BalanceRepository balanceRepository;
    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public BalanceTranslatorImpl(BalanceRepository balanceRepository, AccountTypeRepository accountTypeRepository){

        this.balanceRepository = balanceRepository;
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public BalanceDto getBalanceByMemberId(Long memberId)
    {
        try
        {
            Optional <Balance> balance = balanceRepository.findById(memberId);
            return new BalanceDto(balance.get());
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the DB", e);
        }

    }
    @Override
    public BalanceDto updateBalance(BalanceDto balanceDto){
        try
        {
            Optional <Balance> balance = balanceRepository.findById(balanceDto.getMemberId());
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(balanceDto.getAccountTypeMnemonic());
            if (balance.isPresent()){
                Balance existingBalance = balance.get();
                existingBalance.setAmount(existingBalance.getAmount()+balanceDto.getAmount());
                Balance updatedBalance = balanceRepository.save(existingBalance);
                return new BalanceDto(updatedBalance);
            }
            else{
                Balance newBalance = balanceRepository.save(balanceDto.buildBalance(accountType));
                return new BalanceDto(newBalance);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to update the DB", e);
        }
    }
}
