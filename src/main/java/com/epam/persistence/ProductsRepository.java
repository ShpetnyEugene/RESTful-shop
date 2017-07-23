package com.epam.persistence;


import com.epam.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Product,Long> {
    Product findById(long id);
}
