package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.dto.BalanceDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.FetchBalanceFlow;

@RestController
@RequestMapping("balance")
public class BalanceController {
    private final FetchBalanceFlow fetchBalanceFlow;

    @Autowired
    public BalanceController(FetchBalanceFlow fetchBalanceFlow){
        this.fetchBalanceFlow = fetchBalanceFlow;

    }
    @GetMapping("{memberId}")
    @ApiOperation(value = "Fetches the specified Balance.", notes = "Fetches the Balance in the DB with the matching " +
            "memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<BalanceDto>> getBalance(
            @ApiParam(value = "The memberID that uniquely identifies the Balance",
                    example = "10001",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final Long memberId)
    {
       BalanceDto balance = fetchBalanceFlow.getBalanceByMemberId(memberId);
       GeneralResponse<BalanceDto> response = new GeneralResponse<>( true, balance);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
