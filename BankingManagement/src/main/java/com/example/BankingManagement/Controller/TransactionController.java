package com.example.BankingManagement.Controller;

import com.example.BankingManagement.Model.Customer;
import com.example.BankingManagement.Model.TransactionModel;
import com.example.BankingManagement.Service.TranscationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
    @Autowired
    TranscationService transactionService;


    @GetMapping("/getalltrans")
    public List<TransactionModel> getAll(){

        return transactionService.getAllDetails();
    }
    @GetMapping("/getaccounttrans/{id}")
    public List<TransactionModel> getAccountDetails(@PathVariable long id){
        return transactionService.getaccountdetails(id);
    }
}
