package com.aygunestolga.account.repository;

import com.aygunestolga.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account,String> {
}
