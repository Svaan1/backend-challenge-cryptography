package com.svaan1.backendcryptography.repository;

import com.svaan1.backendcryptography.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
