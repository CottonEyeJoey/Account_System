package za.ac.nwu.ac.web.sb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BalanceControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String BALANCE_CONTROLLER_URL = APP_URL + "/account-type";
    @Test
    public void getBalance() {
    }
}