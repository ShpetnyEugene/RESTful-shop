package com.epam.controllers;

import com.epam.models.Product;
import com.epam.servieces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0/customers/{idCustomer}/items/{idItems}/products")
public class ProductsController {

    private final ProductService service;

    @Autowired
    public ProductsController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts(@PathVariable Long idCustomer, @PathVariable Long idItems) {
        return service.getAllProducts(idCustomer, idItems);
    }

    @GetMapping("/{idProducts}")
    public Product getProductById(@PathVariable Long idCustomer, @PathVariable Long idItems, @PathVariable Long idProducts) {
        return service.getProductById(idCustomer, idItems, idProducts);
    }

    @DeleteMapping("/{idProducts}")
    public void deleteProductById(@PathVariable Long idCustomer, @PathVariable Long idItems, @PathVariable Long idProducts) {
        service.deleteProductById(idCustomer, idItems, idProducts);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@PathVariable Long idCustomer, @PathVariable Long idItems, @RequestBody Product product) {
        service.addProduct(idCustomer, idItems, product);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
