package com.epam.servieces;

import com.epam.models.Item;
import com.epam.persistence.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public List<Item> findAllItems(){
        return repository.findAll();
    }
}
