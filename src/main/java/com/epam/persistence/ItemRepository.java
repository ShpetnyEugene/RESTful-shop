package com.epam.persistence;

import com.epam.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, Long> {
    /**
     * Finds item for a given id
     *
     * @param id - ID on which you want to find item
     */
    Item findById(long id);
}
