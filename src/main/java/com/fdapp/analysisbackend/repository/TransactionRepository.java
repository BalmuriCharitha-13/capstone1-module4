package com.fdapp.analysisbackend.repository;


import com.fdapp.analysisbackend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    List<Transaction> findByUser_Id(UUID userId);
}
