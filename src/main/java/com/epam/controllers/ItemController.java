package com.epam.controllers;


import com.epam.models.Item;
import com.epam.servieces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {
    List<Item> items = new ArrayList<>();

    @Autowired
    ItemService service = new ItemService();

//
//    @RequestMapping(value = "/items/{itemsId}", method = RequestMethod.GET)
//    @ResponseBody
//    public Item getItemById(@PathVariable String itemsId) {
//        for (Item item : items) {
//            if (item.getId() == Long.parseLong(itemsId)) {
//                return item;
//            }
//        }
//        return null;
//    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
//    public List<Item> getItems() {
//        return items;
//    }
    public List<Item> getItems(){
        return service.findAll();
    }

//    @RequestMapping(value = "/items", method = RequestMethod.POST)
//    public void addItem(@RequestBody Item item) {
//        items.add(item);
//    }
//    @RequestMapping(value = "/items/{itemsId}",method = RequestMethod.DELETE)
//    public void deleteItemById(@PathVariable String itemsId) {
//        for (Item item : items) {
//            if (item.getId() == Long.parseLong(itemsId)) {
//                items.remove(item);
//            }
//            // TODO insert not Number in path
//        }
//    }
}
