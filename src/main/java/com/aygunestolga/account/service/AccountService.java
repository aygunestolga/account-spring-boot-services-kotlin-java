package com.aygunestolga.account.service;


import com.aygunestolga.account.dto.AccountDto;
import com.aygunestolga.account.dto.AccountDtoConvertor;
import com.aygunestolga.account.dto.CreateAccountRequest;
import com.aygunestolga.account.model.Account;
import com.aygunestolga.account.model.Customer;
import com.aygunestolga.account.model.Transaction;
import com.aygunestolga.account.repository.IAccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final IAccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConvertor converter;
    private final Clock clock;

    public AccountService(IAccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConvertor converter, Clock clock) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
        this.clock = clock;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                getLocalDateTimeNow());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(
                    createAccountRequest.getInitialCredit(),
                    getLocalDateTimeNow(),
                    account);

           // account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }

    private LocalDateTime getLocalDateTimeNow() {
        Instant instant = clock.instant();
        return LocalDateTime.ofInstant(
                instant,
                Clock.systemDefaultZone().getZone());
    }
}