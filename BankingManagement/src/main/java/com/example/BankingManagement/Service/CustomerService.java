package com.example.BankingManagement.Service;

import com.example.BankingManagement.Model.Customer;
import com.example.BankingManagement.Model.TransactionModel;
import com.example.BankingManagement.Repository.CustomerRepository;
import com.example.BankingManagement.Repository.TranscationRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TranscationRepositary transcationRepositary;
    public Customer createAccount(Customer customer){
        return customerRepository.save(customer);
    }
    public Optional<Customer> getAccount(Long id){
        return customerRepository.findById(id);
    }
    public ResponseEntity<?> deposit(Long id, double amount) throws NoSuchElementException {
        Customer customer=customerRepository.findById(id).orElse(null);
        String errorMsg = "No customer exists..!";

        if(customer==null) {
            return ResponseEntity.badRequest().body(errorMsg);
        }
        else {

            customer.setBalance(customer.getBalance() + amount);
            customerRepository.save(customer);
            TransactionModel transactionModel = new TransactionModel();
            transactionModel.setId(id);
            transactionModel.setAmount(amount);
            transactionModel.setType("Deposit");
            transactionModel.setTime(new Date());
            transcationRepositary.save(transactionModel);

            return ResponseEntity.ok("Amount Deposited ");
        }
    }

    public ResponseEntity<?> withdraw(Long id, Double amount) {
        Customer customer=customerRepository.findById(id).orElse(null);
        String errorMsg = "No customer exists..!";
        String fundserrormsg="Insufficient funds";
        if(customer==null) {
            return ResponseEntity.badRequest().body(errorMsg);
        }
        if (customer.getBalance()<amount){
            return ResponseEntity.badRequest().body(fundserrormsg);
        }
        else {
            customer.setBalance(customer.getBalance() - amount);
            customerRepository.save(customer);
            TransactionModel transactionModel = new TransactionModel();
            transactionModel.setId(id);
            transactionModel.setAmount(amount);
            transactionModel.setType("Withdraw");
            transactionModel.setTime(new Date());
            transcationRepositary.save(transactionModel);
            return ResponseEntity.ok("Amount withdraw ");
        }
    }

    public ResponseEntity<?> delete_customer(long id){
        customerRepository.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }


}
