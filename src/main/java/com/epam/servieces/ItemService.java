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

    public List<Item> findAll(){
        return repository.findAll();
    }

    public void insert (Item item){
        repository.insert(item);
    }


}
