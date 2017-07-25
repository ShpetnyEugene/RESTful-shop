package com.epam.services;

import com.epam.exceptions.ResourceNotFound;
import com.epam.models.Item;
import com.epam.persistence.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Service
public class ItemService {
    private ItemRepository repository;
    private CustomerService service;

    @Autowired
    public ItemService(ItemRepository repository, CustomerService service) {
        this.repository = repository;
        this.service = service;
    }

    /**
     * Create item which one Customer
     *
     * @param item       - object which need create
     * @param idCustomer - id customer which add item
     */
    public void addItem(Item item, long idCustomer) {
        service.addItem(idCustomer, item);
    }

    /**
     * Find items for a given idItems
     *
     * @param idItems    - id items which need find
     * @param idCustomer - id customer which find item
     */
    public Item getItemById(long idItems, long idCustomer) {
        List<Item> items = service.getItems(idCustomer);
        for (Item item : items) {
            if (item.getId() == idItems) {
                return item;
            }
        }
        throw new ResourceNotFound("Not found Item "+idItems);
    }

    /**
     * Deletes the list for the given id
     *
     * @param idItems    - id Item which need delete
     * @param idCustomer - id Customer which one need delete item
     */
    public void deleteItemById(long idCustomer, long idItems) {
        service.deleteItemsById(idCustomer, idItems);
    }

    /**
     * If object created then update Item, else item create
     *
     * @param idCustomer - id customers which one change item
     * @param item       - object which need create or update
     */
    public void addOrUpdateItem(long idCustomer, Item item) {
        service.addOrUpdateItem(idCustomer, item);
    }
}
