package com.epam.persistence;

import com.epam.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item,Long> {
    Item findById(long id);
}
