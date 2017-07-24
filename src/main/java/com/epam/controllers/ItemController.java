package com.epam.controllers;


import com.epam.models.Item;
import com.epam.servieces.CustomerService;
import com.epam.servieces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1.0/customers/{idCustomer}/items")
public class ItemController {

    private final CustomerService customerService;
    private final ItemService service;

    @Autowired
    public ItemController(CustomerService customerService, ItemService service) {
        this.customerService = customerService;
        this.service = service;
    }

    @GetMapping
    public List<Item> getAllItems(@PathVariable Long idCustomer) {
        return customerService.getItems(idCustomer);
    }

    @PostMapping
    public void addItem(@RequestBody Item item,@PathVariable long idCustomer){
         service.addItem(item,idCustomer);
    }

    @DeleteMapping("/{idItems}")
    public ResponseEntity<String> deleteItemById(@PathVariable long idCustomer ,@PathVariable long idItems){
        service.deleteItemById(idCustomer,idItems);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public void addOrUpdate(@RequestBody Item item,@PathVariable long idCustomer){
        service.addOrUpdateItem(idCustomer,item);
    }

    @GetMapping("/{idItems}")
    public Item getItemById(@PathVariable long idCustomer ,@PathVariable long idItems){
        return service.getItemById(idItems,idCustomer);
    }
}
