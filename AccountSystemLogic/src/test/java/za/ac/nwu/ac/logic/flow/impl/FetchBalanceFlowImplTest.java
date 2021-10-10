package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.BalanceDto;
import za.ac.nwu.ac.translator.BalanceTranslator;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FetchBalanceFlowImplTest {

    @Mock
    private BalanceTranslator translator;
    @InjectMocks
    private  FetchBalanceFlowImpl testClass;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        testClass = null;
    }

    @Test
    public void getBalanceByMemberId() {
        BalanceDto balanceDto = testClass.getBalanceByMemberId(10001L);
        verify(translator, times( 2)).getBalanceByMemberId(anyLong());
    }
}