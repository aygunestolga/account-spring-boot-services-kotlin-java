package com.aygunestolga.account.dto;


import com.aygunestolga.account.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConvertor {

    public AccountCustomerDto convertToAccountCustomer(Customer from){
        if (from == null){
            return new AccountCustomerDto("","", "");
        }
        return new AccountCustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname());
    }


}
