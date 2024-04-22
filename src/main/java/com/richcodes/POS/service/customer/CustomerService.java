package com.richcodes.POS.service.customer;

import com.richcodes.POS.enitity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomerById(Integer theId);
    void updateCustomer(Customer customer);
    void deleteCustomer(Integer theId);
    List<Customer> getAllCustomer();
}
