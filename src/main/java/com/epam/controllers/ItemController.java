package com.epam.controllers;


import com.epam.exceptions.ResourceNotFound;
import com.epam.models.Item;
import com.epam.services.CustomerService;
import com.epam.services.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1.0/customers/{idCustomer}/items")
public class ItemController {

    private static final Logger log = Logger.getLogger(ItemController.class);
    private final CustomerService customerService;
    private final ItemService service;

    @Autowired
    public ItemController(CustomerService customerService, ItemService service) {
        this.customerService = customerService;
        this.service = service;
    }

    @GetMapping
    public List<Item> getAllItems(@PathVariable Long idCustomer) {
        log.info("Get all items");
        return customerService.getItems(idCustomer);
    }

    @PostMapping
    public void addItem(@RequestBody Item item, @PathVariable long idCustomer) {
        log.info("Add new Item" + item);
        service.addItem(item, idCustomer);
    }

    @DeleteMapping("/{idItems}")
    public ResponseEntity<String> deleteItemById(@PathVariable long idCustomer, @PathVariable long idItems) {
        log.info("Get items with id: " + idItems);
        service.deleteItemById(idCustomer, idItems);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public void addOrUpdate(@RequestBody Item item, @PathVariable long idCustomer) {
        service.addOrUpdateItem(idCustomer, item);
        log.info("Create or update item" + item);
    }

    @GetMapping("/{idItems}")
    public Item getItemById(@PathVariable long idCustomer, @PathVariable long idItems) {
        if(service.getItemById(idItems, idCustomer) == null){
            throw new ResourceNotFound();
        }
        return service.getItemById(idItems, idCustomer);
    }
}
