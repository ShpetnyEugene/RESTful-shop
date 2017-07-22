package com.epam.controllers;


import com.epam.models.Item;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {
    List<Item> items = new ArrayList<>();


    @RequestMapping(value = "/items/{itemsId}", method = RequestMethod.GET)
    @ResponseBody
    public Item getItemById(@PathVariable String itemsId) {
        for (Item item : items) {
            if (item.getId() == Long.parseLong(itemsId)) {
                return item;
            }
        }
        return null;
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> getItems() {
        return items;
    }


    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public void addItem(@RequestBody Item item) {
        items.add(item);
    }
}
