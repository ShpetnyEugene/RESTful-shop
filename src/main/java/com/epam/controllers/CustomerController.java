package com.epam.controllers;

import com.epam.models.Customer;
import com.epam.servieces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */

@RestController
@RequestMapping("/v1.0/customers")
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{idCustomer}")
    public Customer getCustomersById(@PathVariable long idCustomer) {
        return service.getCustomerById(idCustomer);
    }


    @PutMapping
    public void createOrUpdateCustomer(@RequestBody Customer customer) {
        service.addOrUpdate(customer);
    }


    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable long idCustomer) {
        service.deleteCustomerById(idCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }
}
