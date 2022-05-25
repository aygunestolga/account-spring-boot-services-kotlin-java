package com.aygunestolga.account.repository;

import com.aygunestolga.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction,String> {


}
