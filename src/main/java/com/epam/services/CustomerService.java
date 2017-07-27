package com.epam.services;

import com.epam.exceptions.ResourceNotFoundException;
import com.epam.models.Customer;
import com.epam.models.Item;
import com.epam.persistence.CustomerRepository;
import com.epam.persistence.ItemRepository;
import com.epam.persistence.ProductsRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Service
public class CustomerService {

    private static final Logger log = Logger.getLogger(CustomerService.class);

    private final CustomerRepository repository;
    private final ItemRepository itemRepository;
    private final ProductsRepository productsRepository;

    @Autowired
    public CustomerService(CustomerRepository repository, ItemRepository itemRepository, ProductsRepository productsRepository) {
        this.repository = repository;
        this.itemRepository = itemRepository;
        this.productsRepository = productsRepository;
    }

    /**
     * Finds all items for Customers
     *
     * @param idCustomer - ID at which it is necessary to find all Items
     */
    public List<Item> getItems(long idCustomer) {
        if (repository.findById(idCustomer).getItems() == null) {
            log.error(new ResourceNotFoundException());
            throw new ResourceNotFoundException();
        }
        return repository.findById(idCustomer).getItems();
    }


    /**
     * If there is a item with such id, then the object is changed, otherwise a new one is created
     *
     * @param idCustomer - object which one need create item
     * @param item       - object you need to create or update
     */

    public void addOrUpdateItem(long idCustomer, Item item) {
        Customer customer = repository.findById(idCustomer);
        itemRepository.save(item);
        customer.setItems(itemRepository.findAll());
        repository.save(customer);
    }


    /**
     * Create item have given Customer
     *
     * @param idCustomer - id customer which one need create item
     * @param item       - item you need to create
     */

    public void addItem(long idCustomer, Item item) {
        Customer customer = repository.findById(idCustomer);
        if (itemRepository.findById(item.getId()) == null) {
            itemRepository.save(item);
            customer.getItems().add(item);
            repository.save(customer);
        }
    }

    /**
     * Create object Customer
     *
     * @param customer - Object which need create
     */
    public void addCustomer(Customer customer) {
        if (repository.findById(customer.getId()) == null) {
            repository.save(customer);
            if (customer.getItems() != null) {
                itemRepository.save(customer.getItems());
                for (Item item : customer.getItems()) {
                    productsRepository.save(item.getProducts());
                }
            }
        }
    }

    /**
     * If there is a list with such id, then the object is changed, otherwise a new one is created
     *
     * @param customer - Object which need change or create
     */

    public void addOrUpdate(Customer customer) {
        repository.save(customer);
    }

    /**
     * Finds customer for a given id
     *
     * @param id - ID on which you want to find Customer
     */
    public Customer getCustomerById(long id) {
        if (repository.findById(id) == null) {
            log.error(new ResourceNotFoundException("No such Customer"));
            throw new ResourceNotFoundException("No such Customer");
        }
        return repository.findById(id);
    }

    /**
     * Delete customer for a given id
     *
     * @param id - ID on which you want to delete Customer
     */
    public void deleteCustomerById(long id) {
        repository.deleteById(id);
    }

    /**
     * Finds all customers
     */
    public List<Customer> getAllCustomers() {
        if (repository.findAll().isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return repository.findAll();
    }


    /**
     * Delete item for a given idItems and idCustomers
     *
     * @param idCustomer - ID which one needed delete Item
     * @param idItems    - id items which one need delete
     */
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
