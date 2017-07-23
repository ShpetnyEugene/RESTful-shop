package com.epam.servieces;

import com.epam.models.Customer;
import com.epam.models.Item;
import com.epam.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;


    public Item getItem(long id){
        return repository.findItemById(id);
    }


    /**
     * TODO
     */
    public void addCustomer(Customer customer) {
        repository.save(customer);
    }


    /**
     * TODO
     * */
    public Customer getCustomerById(long id){
        return repository.findById(id);
    }


    public void deleteCustomerById(long id){
        repository.deleteById(id);
    }



    /**
     * TODO
     */
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

}
