package com.epam.controllers;

import com.epam.models.Product;
import com.epam.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0/customers/{idCustomer}/items/{idItems}/products")
public class ProductsController {

    private static final Logger log = Logger.getLogger(ProductsController.class);
    private final ProductService service;

    @Autowired
    public ProductsController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts(@PathVariable Long idCustomer, @PathVariable Long idItems) {
        log.info("Get all products");
        return service.getAllProducts(idCustomer, idItems);
    }

    @GetMapping("/{idProducts}")
    public Product getProductById(@PathVariable Long idCustomer, @PathVariable Long idItems, @PathVariable Long idProducts) {
        log.info("Get products with id: " + idItems);
        return service.getProductById(idCustomer, idItems, idProducts);
    }

    @DeleteMapping("/{idProducts}")
    public void deleteProductById(@PathVariable Long idCustomer, @PathVariable Long idItems, @PathVariable Long idProducts) {
        log.info("Delete Product with id : " + idProducts);
        service.deleteProductById(idCustomer, idItems, idProducts);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@PathVariable Long idCustomer, @PathVariable Long idItems, @RequestBody Product product) {
        log.info("Add new Product");
        service.addProduct(idCustomer, idItems, product);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
