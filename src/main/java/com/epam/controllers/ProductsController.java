package com.epam.controllers;

import com.epam.models.Product;
import com.epam.servieces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1.0/customers/{idCustomer}/items/{idItems}/products")
public class ProductsController {

    private final ProductService service;

    @Autowired
    public ProductsController(ProductService service) {
        this.service = service;
    }

    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

}
