package com.epam.controllers;

import com.epam.models.Customer;
import com.epam.servieces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @RequestMapping(value = "/customers/{idCustomer}", method = RequestMethod.GET)
    public Customer getCustomersById(@PathVariable long idCustomer) {
        return service.getCustomerById(idCustomer);
    }

    @RequestMapping(value = "customers/{idCustomer}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCustomerById(@PathVariable long idCustomer){
        service.deleteCustomerById(idCustomer);
        //TODO maybe wrong HttpStatus
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /**
     * TODO ADD PUT METHODS
     */
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }
}
