//package za.ac.nwu.ac.web.sb.controller;
//
//import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
//import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
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
//
//
//import java.io.UnsupportedEncodingException;
//import java.time.LocalDate;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.AdditionalAnswers.returnsFirstArg;
//
//import static org.mockito.ArgumentMatchers.eq;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class AccountTransactionControllerTest {
//
//    private static final String APP_URL = "/account-system/mvc";
//    private static final String ACCOUNT_TRANSACTION_CONTROLLER_URL = APP_URL + "/account-transaction";
//    @Mock
//    private CreateAccountTransactionFlow createAccountTransactionFlow;
//    @InjectMocks
//    private AccountTransactionController controller;
//    private MockMvc mockMvc;
//    @Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//    }
//    @Test
//    public void add() throws Exception {
//        String accountTransactionToBeAdded =
//                "{\"accountTypeMnemonic\": \"MILES\",\"memberId\":\"10001\",\"amount\":\"1000\",\"transactionDate\":[2020,01,01]},";
//        String expectedResponse = "{\"successful\":true,\"payload\":" +
//                "{\"accountTypeMnemonic\": \"MILES\",\"memberId\":\"10001\",\"amount\":\"1000\",\"transactionDate\":[2020,01,01]}";
//        AccountTransactionDto accountTransaction= new AccountTransactionDto("MILES", Long.parseLong("10001"), Long.parseLong("1000"), LocalDate.parse("2020-01-01"));
//                when(createAccountTransactionFlow.create(eq(accountTransaction), true)).then(returnsFirstArg());
//        MvcResult mvcResult = mockMvc.perform(post(String.format("%s/%s",
//                        ACCOUNT_TRANSACTION_CONTROLLER_URL, "add"))
//                            .servletPath(APP_URL)
//                            .accept(MediaType.APPLICATION_JSON)
//                            .content(accountTransactionToBeAdded)
//                            .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isCreated())
//                    .andReturn();
//        verify(createAccountTransactionFlow, times(1)).create(eq(accountTransaction), true);
//        assertEquals(expectedResponse,
//                mvcResult.getResponse().getContentAsString());
//    }
//
//    @Test
//    public void subtract() throws Exception {
//        String accountTransactionToBeSubtracted =
//                "{\"accountTypeMnemonic\": \"MILES\",\"memberId\":\"10001\",\"amount\":\"1000\",\"transactionDate\":[2020,01,01]},";
//        String expectedResponse = "{\"successful\":true,\"payload\":" +
//                "{\"accountTypeMnemonic\": \"MILES\",\"memberId\":\"10001\",\"amount\":\"1000\",\"transactionDate\":[2020,01,01]}";
//        AccountTransactionDto accountTransaction= new AccountTransactionDto("MILES", Long.parseLong("10001"),
//                Long.parseLong("1000"), LocalDate.parse("2020-01-01"));
//        when(createAccountTransactionFlow.create(eq(accountTransaction), false)).then(returnsFirstArg());
//        MvcResult mvcResult = mockMvc.perform(post(String.format("%s/%s",
//                        ACCOUNT_TRANSACTION_CONTROLLER_URL, "subtract"))
//                        .servletPath(APP_URL)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(accountTransactionToBeSubtracted)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andReturn();
//        verify(createAccountTransactionFlow, times(1)).create(eq(accountTransaction), false);
//        assertEquals(expectedResponse,
//                mvcResult.getResponse().getContentAsString());
//    }
//}