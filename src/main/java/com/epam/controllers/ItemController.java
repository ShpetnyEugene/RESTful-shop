package com.epam.controllers;


import com.epam.models.Item;
import com.epam.servieces.CustomerService;
import com.epam.servieces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ItemService service;

    @GetMapping(value = "/customers/{idCustomer}/items")
    public Item getAllItems(@PathVariable long idCustomer) {
        return customerService.getItem(idCustomer);
    }



}
