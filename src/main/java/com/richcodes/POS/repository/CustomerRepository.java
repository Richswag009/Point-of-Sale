package com.richcodes.POS.repository;

import com.richcodes.POS.enitity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsCustomerByPhone(String name);
}
