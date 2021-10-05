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
import za.ac.nwu.ac.domain.dto.MemberAccountDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateMemberAccountFlow;
import za.ac.nwu.ac.logic.flow.FetchMemberAccountFlow;
import za.ac.nwu.ac.logic.flow.ModifyMemberAccountFlow;

@RestController
@RequestMapping("member-account")
public class MemberAccountController {
    private final CreateMemberAccountFlow createMemberAccountFlow;
    private final FetchMemberAccountFlow fetchMemberAccountFlow;
    private final ModifyMemberAccountFlow modifyMemberAccountFlow;

    @Autowired
    public MemberAccountController(@Qualifier("createMemberAccountFlowName") CreateMemberAccountFlow createMemberAccountFlow,
                                   @Qualifier("fetchMemberAccountFlowName") FetchMemberAccountFlow fetchMemberAccountFlow,
                                   @Qualifier("modifyMemberAccountFlowName") ModifyMemberAccountFlow modifyMemberAccountFlow) {
        this.createMemberAccountFlow = createMemberAccountFlow;
        this.fetchMemberAccountFlow = fetchMemberAccountFlow;
        this.modifyMemberAccountFlow = modifyMemberAccountFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new Member Account of a specific AccountType")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account Type Successfully Created", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberAccountDto>> create(
            @ApiParam(value = "Request body to create a new Member Account", required = true)
            @RequestBody MemberAccountDto MemberAccount ){
        //ToDO: add if checks to ensure values are added
        MemberAccountDto MemberAccountResponse = createMemberAccountFlow.create(MemberAccount);
        GeneralResponse<MemberAccountDto> response = new GeneralResponse<>(true, MemberAccountResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{memberId}/{accountTypeId}")
    @ApiOperation(value="Gets a MemberAccount for specified MemberID and AccountTypeID",
            notes = "Gets a MemberAccount for specified MemberID and AccountTypeID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Types Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberAccountDto>> getMember(
            @ApiParam(value = "The MemberID that uniquely identifies the MemberAccountOwner.",
                    name = "Member 1",
                    type = "Long",
                    example = "100000000000001",
                    required = true)
            @PathVariable("memberId") final Long memberId,
            @ApiParam(value = "The AccountTypeID that uniquely identifies the AccountType.",
                    name = "Currency AccountID",
                    type = "Long",
                    example = "100000000000003",
                    required = true)
            @PathVariable("accountTypeId") final Long accountTypeId){
        MemberAccountDto MemberAccount =fetchMemberAccountFlow.getMember(memberId , accountTypeId);
        GeneralResponse<MemberAccountDto> response = new GeneralResponse<>(true, MemberAccount);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("{transactionValue}")
    @ApiOperation(value = "Updates a MemberAccount with the value of a transaction",
            notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account Type Successfully Created", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberAccountDto>> updateMemberAccount(
            @ApiParam(value="Transaction Value",
                    name="Value of transaction",
                    example = "600",
                    required = true)
            @PathVariable("transactionValue") final String transactionValue,

            @ApiParam(value = "The MemberID that uniquely identifies the MemberAccountOwner.",
                    name = "Member 1",
                    example = "1000000001")
            @RequestParam("memberID") final Long memberID,

            @ApiParam(value = "The AccountTypeID that uniquely identifies the AccountType.",
                    name="Currency AccountTypeID",
                    example = "1000000001",
                    required = true)
            @RequestParam("accountTypeID") final Long accountTypeID
    ){
         MemberAccountDto MemberAccount = modifyMemberAccountFlow.updateMemberAccount(Long.parseLong(transactionValue),memberID , accountTypeID);
         GeneralResponse<MemberAccountDto> response = new GeneralResponse<>(true, MemberAccount);
         return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
