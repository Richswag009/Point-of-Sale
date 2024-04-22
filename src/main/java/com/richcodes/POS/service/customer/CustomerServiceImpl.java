package com.richcodes.POS.service.customer;

import com.richcodes.POS.enitity.Customer;
import com.richcodes.POS.exceptions.DuplicateExceptions;
import com.richcodes.POS.exceptions.ResourceNotFoundExceptions;
import com.richcodes.POS.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void addCustomer(Customer customer) {
        if(customerRepository.existsCustomerByPhone(customer.getPhone())){
            throw  new DuplicateExceptions("Customer already exists");
        }
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Integer theId) {
        Optional<Customer> result = customerRepository.findById(theId);
        Customer customer = null;
        if (result.isPresent()) {
            customer = result.get();
        }
        else {
            throw new ResourceNotFoundExceptions("Did not find employee id - " + theId);
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void deleteCustomer(Integer theId){
        customerRepository.deleteById(theId);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
