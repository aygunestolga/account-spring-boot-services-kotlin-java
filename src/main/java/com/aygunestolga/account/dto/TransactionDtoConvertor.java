package com.aygunestolga.account.dto;

import com.aygunestolga.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConvertor {
    public TransactionDto convert(Transaction from) {
        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
