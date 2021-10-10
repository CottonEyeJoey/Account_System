package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.BalanceDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.BalanceTranslator;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTransactionFlowImplTest {

    @Mock
    private AccountTransactionTranslator translator;
    @Mock
    private BalanceTranslator balanceTranslator;
    @InjectMocks
    private CreateAccountTransactionFlowImpl flow ;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        when(translator.save(any(AccountTransactionDto.class))).then(returnsFirstArg());
        when(balanceTranslator.updateBalance(any(BalanceDto.class))).then(returnsFirstArg());

        AccountTransactionDto accountTransactionDto = new AccountTransactionDto("MILES",10001L, 1000L, LocalDate.now());
        AccountTransactionDto result = flow.create(accountTransactionDto, true);
        assertNotNull(result);
        verify(translator, atLeastOnce()).save(any(AccountTransactionDto.class));
        verify(balanceTranslator, atLeastOnce()).updateBalance(any(BalanceDto.class));
    }

}