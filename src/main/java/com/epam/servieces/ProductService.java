package com.epam.servieces;

import com.epam.models.Product;
import com.epam.persistence.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductsRepository repository;

    @Autowired
    public ProductService(ProductsRepository repository) {
        this.repository = repository;
    }
    public List<Product> getAllProducts (){
        return repository.findAll();
    }
}
