package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId){
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public void addCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Marian");
        customer.setLastName("Kowalski");
        customer.setEmail("wielGAB0LZGA@WP.pl");

        customerService.saveCustomer(customer);
    }

    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId){
        customerService.deleteCustomer(customerId);
    }


}
