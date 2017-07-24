package com.epam.servieces;

import com.epam.models.Customer;
import com.epam.models.Item;
import com.epam.persistence.CustomerRepository;
import com.epam.persistence.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final ItemRepository itemRepository;

    @Autowired
    public CustomerService(CustomerRepository repository,ItemRepository itemRepository) {
        this.repository = repository;
        this.itemRepository = itemRepository;
    }


    public List<Item> getItems(long idCustomer) {
        return repository.findById(idCustomer).getItems();
    }

    public void addOrUpdateItem(long idCustomer, Item item) {
        Customer customer = repository.findById(idCustomer);
        itemRepository.save(item);
        customer.setItems(itemRepository.findAll());
        repository.save(customer);
    }

    public void addItem(long idCustomer, Item item) {
        Customer customer = repository.findById(idCustomer);
        if(itemRepository.findById(item.getId()) == null) {
            itemRepository.save(item);
            customer.getItems().add(item);
            repository.save(customer);
        }
    }

    public void addCustomer(Customer customer) {
        if (repository.findById(customer.getId()) == null) {
            repository.save(customer);
        }
    }


    public void addOrUpdate(Customer customer) {
        repository.save(customer);
    }

    public Customer getCustomerById(long id) {
        return repository.findById(id);
    }

    public void deleteCustomerById(long id) {
        repository.deleteById(id);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public void deleteItemsById(long idCustomer, long idItems) {
        Customer customer = repository.findById(idCustomer);
        for (Item item : customer.getItems()) {
            if (item.getId() == idItems) {
                customer.getItems().remove(item);
                repository.save(customer);
                break;
            }
        }
    }


}
