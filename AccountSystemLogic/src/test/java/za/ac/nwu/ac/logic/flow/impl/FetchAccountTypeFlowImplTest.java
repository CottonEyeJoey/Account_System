package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FetchAccountTypeFlowImplTest {
    @Mock
    private AccountTypeTranslator translator;
    @InjectMocks
    private FetchAccountTypeFlowImpl testClass;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        testClass = null;
    }

    @Test
    public void getAllAccountTypes(){
        List<AccountTypeDto> list = translator.getAllAccountTypes();
        verify(translator, times( 1)).getAllAccountTypes();
        assertNotNull(list);
    }

    @Test
    public void getAccountTypeByMnemonic(){
        AccountTypeDto accountTypeDto = translator.getAccountTypeByMnemonic("MILES");
        verify(translator, times( 1)).getAccountTypeByMnemonic(anyString());
    }

}