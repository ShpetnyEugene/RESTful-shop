package com.epam.servieces;

import com.epam.models.Item;
import com.epam.persistence.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public List<Item> findAll(){
        return repository.findAll();
    }

    @PostConstruct
    public void save(){
        repository.deleteAll();
        repository.save(new Item(1,"Apple",124));
        repository.save(new Item(2,"Orange",657));
        repository.save(new Item(3,"Potato",197));
    }

}
