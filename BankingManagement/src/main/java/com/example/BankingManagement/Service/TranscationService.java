package com.example.BankingManagement.Service;

import com.example.BankingManagement.Model.TransactionModel;
import com.example.BankingManagement.Repository.TranscationRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranscationService {
    @Autowired
    TranscationRepositary transactionRepository;

    public List<TransactionModel> getAllDetails() {
        return transactionRepository.findAll();
    }
    public List<TransactionModel> getaccountdetails(long id){
        return transactionRepository.getDetailsById(id) ;
    }
}