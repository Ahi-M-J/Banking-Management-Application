package com.example.BankingManagement.Controller;

import com.example.BankingManagement.Model.Customer;
import com.example.BankingManagement.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/addcustomer")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createAccount(customer);
    }
    @GetMapping("/getcustomer/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getAccount(id).orElseThrow(()->new RuntimeException("Account not found, Create new one"));
    }
    @PostMapping("/deposit/{id}/{amount}")
    public ResponseEntity<?> deposit(@PathVariable long id, @PathVariable double amount) {
        return customerService.deposit(id, amount);
    }
    @PostMapping("/withdraw/{id}/{amount}")

    public ResponseEntity<?> withdraw(@PathVariable long id,@PathVariable double amount){
        return customerService.withdraw(id,amount);
    }
    @DeleteMapping("/delete_customer/{id}")
    public ResponseEntity<?> delete_customer(@PathVariable long id){
        return customerService.delete_customer(id);
    }



}
