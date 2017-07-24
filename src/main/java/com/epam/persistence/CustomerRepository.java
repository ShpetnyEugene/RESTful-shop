package com.epam.persistence;


import com.epam.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {

    /**
     * Finds customer for a given id
     *
     * @param id - ID on which you want to find Customer
     */
    Customer findById(long id);

    /**
     * Delete customer for a given id
     *
     * @param id - ID on which want to delete Customer
     */
    void deleteById(long id);


}
