package com.aygunestolga.account.service;



import com.aygunestolga.account.repository.ITransactionRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import javax.transaction.Transaction;
import java.util.logging.Logger;

@Service
public class TransactionService {

    private Logger logger = (Logger) LoggerFactory.getLogger(TransactionService.class);

    private final ITransactionRepository transactionRepository;

    public TransactionService(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

/*
    protected Transaction initiateMoney(){

        return transactionRepository.save(
               // new Transaction(amount,account)
        );
    }
*/
}
