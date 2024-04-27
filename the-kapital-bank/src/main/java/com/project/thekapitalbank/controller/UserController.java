package com.project.thekapitalbank.controller;

import com.project.thekapitalbank.dto.*;
import com.project.thekapitalbank.service.impl.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User Account Management APIs ")
public class UserController {
    @Autowired
    UserService userService;

    @Operation(
            summary = "Create New User Account",
            description = "Creating a new user and assigning an account ID"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest) {
        return userService.createAccount(userRequest);
    }

    @Operation(
            summary = "Balance Enquiry",
            description = "Given an account number, check how much the user has money"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 SUCCESS"
    )

    @GetMapping("/balanceEnquiry")//musterikodune esasen balansi gosterir
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request) {
        return userService.balanceEnquiry(request);
    }

    @GetMapping("/nameEnquiry")//musteri koduna esasen musterinin adini gosterir
    public String nameEnquiry(@RequestBody EnquiryRequest request) {
        return userService.nameEnquiry(request);
    }

    @PostMapping("/credit")//balansi artirmaq ucun istifade edirem
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request) {
        return userService.creditAccount(request);
    }

    @PostMapping("/debit")
    public BankResponse debitAccount(@RequestBody CreditDebitRequest request) {
        return userService.debitAccount(request);
    }

    @PostMapping("/transfer")
    public BankResponse transfer(@RequestBody TransferRequest request) {
        return userService.transfer(request);
    }


}
