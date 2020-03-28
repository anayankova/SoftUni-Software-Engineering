package com.example.cardealerxml.services;

import com.example.cardealerxml.models.dtos.CustomerSeedDto;
import com.example.cardealerxml.models.dtos.CustomerViewRootDto;
import com.example.cardealerxml.models.entities.Customer;

import java.util.List;

public interface CustomerService {
    void seedCustomers(List<CustomerSeedDto> customerSeedDtos);

    Customer getRandomCustomer();

    CustomerViewRootDto getAllOrderedCustomers();
}
