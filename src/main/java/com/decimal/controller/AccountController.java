package com.decimal.controller;

import com.decimal.model.Account;
import com.decimal.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "account", produces = {"application/json"}, consumes = {"application/json"})
public class AccountController {


    @Autowired
    AccountService accountService;

    @PostMapping("/add")
    public ResponseEntity<Object> addRecord(
            @RequestBody  Account account) {
        accountService.addAccount(account);
        Map<String,String> response=new HashMap<>();
        response.put("msg","success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
