package com.epam.controllers;

import com.epam.models.Customer;
import com.epam.services.CustomerService;
import org.apache.log4j.Logger;
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
    private static final Logger log = Logger.getLogger(CustomerController.class);
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
        log.info("Add new Customer" + customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{idCustomer}")
    public Customer getCustomersById(@PathVariable long idCustomer) {
        log.info("Get customer by id :" + idCustomer);
        return service.getCustomerById(idCustomer);
    }

    @PutMapping
    public void createOrUpdateCustomer(@RequestBody Customer customer) {
        log.info("Create or update customer: " + customer);
        service.addOrUpdate(customer);
    }


    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable long idCustomer) {
        service.deleteCustomerById(idCustomer);
        log.info("Delete customer with id: " + idCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }
}
