package com.epam.persistence;


import com.epam.models.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Products,Long> {
    Products findById(long id);
}
