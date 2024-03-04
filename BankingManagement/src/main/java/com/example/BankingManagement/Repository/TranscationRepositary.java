package com.example.BankingManagement.Repository;

import com.example.BankingManagement.Model.Customer;
import com.example.BankingManagement.Model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranscationRepositary extends JpaRepository<TransactionModel,Long> {
    @Query("select t from TransactionModel t where t.id= :id")
    List<TransactionModel> getDetailsById(long id);
}
