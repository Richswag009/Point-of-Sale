package com.richcodes.POS.controller;

import com.richcodes.POS.enitity.Customer;
import com.richcodes.POS.exceptions.DuplicateExceptions;
import com.richcodes.POS.repository.CustomerRepository;
import com.richcodes.POS.service.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService ;
    @Autowired
    private CustomerRepository customerRepository;



    @GetMapping()
    public String index(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        List<Customer> customers= customerService.getAllCustomer();
        model.addAttribute("customers",customers);

        return "customer";
    }

    @PostMapping("/save")
    public String showForm(@ModelAttribute Customer customer, Model model) throws DuplicateExceptions {
        boolean customerExists = customerRepository.existsCustomerByPhone(customer.getPhone());
        if(!customerExists){
            customerService.addCustomer(customer);
        }else{
            model.addAttribute("errorMessage", "Customer already exists");
            return "product";
        }
        return "redirect:/customer";
    }


    @GetMapping("/delete")
    public String deleteEmployee(
            @RequestParam("customerId")
            @ModelAttribute("customer")
            int theId
    ){
        customerService.deleteCustomer(theId);
        return "redirect:/customer";
    }
}
