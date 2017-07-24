package com.epam.persistence;


import com.epam.models.Customer;
import com.epam.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {
    /**
     * TODO
     * */
    Customer findById(long id);

    /**
     * TODO
     * */
    void deleteById(long id);


}
