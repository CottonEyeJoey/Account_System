package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;

import javax.transaction.Transactional;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final CreateAccountTransactionFlow createAccountTransactionFlow;


    @Autowired
    public AccountTransactionController(@Qualifier("createAccountTransactionFlowName") CreateAccountTransactionFlow createAccountTransactionFlow
    ) {
        this.createAccountTransactionFlow = createAccountTransactionFlow;

    }

    @PostMapping("/add")
    @ApiOperation(value = "Adds a new AccountTransaction and adds to balance.", notes = "Creates a new AccountTransaction in the DB and adds to the balance")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "AccountTransaction added successfully and updated balance", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    @Transactional(rollbackOn = Throwable.class)
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> add(
            @ApiParam(value = "Request to add to the balance and create the transaction", required = true)
            @RequestBody AccountTransactionDto accountTransaction,
            @RequestHeader(name = "make_exception", required = false, defaultValue = "false") Boolean makeexception) {
        AccountTransactionDto accountTransactionResponse = createAccountTransactionFlow.create(accountTransaction,true);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionResponse);


        if (makeexception) {
            throw new RuntimeException("The transaction has been rolled back successfully.");
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/subtract")
    @ApiOperation(value = "Adds a new AccountTransaction and subtracts from the balance.", notes = "Creates a new AccountTransaction in the DB and subtracts from the balance")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "AccountTransaction created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    @Transactional(rollbackOn = Throwable.class)
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> subtract(
            @ApiParam(value = "Request to subtract from the balance and create the transaction", required = true)
            @RequestBody AccountTransactionDto accountTransaction)
            {
        AccountTransactionDto accountTransactionResponse = createAccountTransactionFlow.create(accountTransaction, false);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionResponse);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
