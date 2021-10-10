//package za.ac.nwu.ac.web.sb.controller;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import za.ac.nwu.ac.domain.dto.AccountTypeDto;
//import za.ac.nwu.ac.domain.dto.BalanceDto;
//import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
//import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
//import za.ac.nwu.ac.logic.flow.FetchBalanceFlow;
//
//import java.io.UnsupportedEncodingException;
//import java.time.LocalDate;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class BalanceControllerTest {
//
//    private static final String APP_URL = "/account-system/mvc";
//    private static final String ACCOUNT_TYPE_CONTROLLER_URL = APP_URL + "/balance";
//    @Mock
//    private FetchBalanceFlow fetchBalanceFlow;
//    @InjectMocks
//    private BalanceController controller;
//    private MockMvc mockMvc;
//    @Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//    }
//    @Test
//    public void getBalance() throws Exception {
//        String expectedResponse = "{\"successful\":true,\"payload\":[" +
//                "{\"mnemonic\":\"MILES\",\"accountTypeName\":\"Miles\",\"creationDate\":[2020,1,1]}";
//        BalanceDto balanceDto = (new BalanceDto(10001L, "MILES",
//                1000L));
//        when(fetchBalanceFlow.getBalanceByMemberId(10001L)).thenReturn(balanceDto);
//        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
//                        ACCOUNT_TYPE_CONTROLLER_URL, "{memberId}")))
//                        .servletPath(APP_URL)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//        verify(fetchBalanceFlow, times(1)).getBalanceByMemberId(10001L);
//        assertEquals(expectedResponse,
//                mvcResult.getResponse().getContentAsString());
//    }
//}