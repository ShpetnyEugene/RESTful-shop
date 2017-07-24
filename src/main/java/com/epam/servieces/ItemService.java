package com.epam.servieces;

import com.epam.models.Customer;
import com.epam.models.Item;
import com.epam.persistence.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository repository;
    private CustomerService service;


    @Autowired
    public ItemService(ItemRepository repository, CustomerService service) {
        this.repository = repository;
        this.service = service;
    }

    public List<Item> findAllItems() {
        return repository.findAll();
    }



    public void addItem(Item item, long idCustomer) {
         service.addItem(idCustomer,item);
    }

    public Item getItemById(long idItems, long idCustomer) {
        List<Item> items = service.getItems(idCustomer);
        for (Item item: items){
            if (item.getId() == idItems){
                return item;
            }
        }
        return null;
    }

    public void deleteItemById(long idCustomer, long idItems) {
        service.deleteItemsById(idCustomer,idItems);
    }

    public void addOrUpdateItem(long idCustomer, Item item) {
        service.addOrUpdateItem(idCustomer,item);
    }
}
