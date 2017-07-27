package com.epam.services;

import com.epam.exceptions.ResourceNotFoundException;
import com.epam.models.Item;
import com.epam.models.Product;
import com.epam.persistence.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductsRepository repository;
    private final CustomerService customerService;
    private final ItemService itemService;

    @Autowired
    public ProductService(ProductsRepository repository, CustomerService customerService, ItemService itemService) {
        this.repository = repository;
        this.customerService = customerService;
        this.itemService = itemService;
    }

    /**
     * Finds all Products
     *
     * @param idItems    - idItem who needs to find product
     * @param idCustomer - id Customer who needs to find product
     */
    public List<Product> getAllProducts(long idCustomer, long idItems) {
        return itemService.getItemById(idItems, idCustomer).getProducts();
    }

    /**
     * Finds the product by id
     *
     * @param idItems    -id Item who needs to find product
     * @param idCustomer -id Customer who needs to find product
     * @param idProducts - id on which you want to find Products
     */
    public Product getProductById(Long idCustomer, Long idItems, Long idProducts) {
        for (Product product : itemService.getItemById(idItems, idCustomer).getProducts()) {
            if (product.getId() == idProducts) {
                return product;
            }
        }
        throw new ResourceNotFoundException("Not found product with id :" + idProducts);

    }


    /**
     * Delete the product by id
     *
     * @param idItems    -id Item who needs to delete product
     * @param idCustomer -id Customer who needs to delete product
     * @param idProducts - id on which you want to delete Products
     */
    public void deleteProductById(long idCustomer, long idItems, long idProducts) {
        Item item = itemService.getItemById(idItems, idCustomer);
        int counter = 0;
        for (Product product : itemService.getItemById(idItems, idCustomer).getProducts()) {
            if (product.getId() == idProducts) {
                item.getProducts().remove(counter);
                itemService.addOrUpdateItem(idCustomer, item);
            }
            counter++;
        }
    }

    /**
     * Create and add Product
     *
     * @param idCustomer - id Customer who needs to create Product
     * @param idItems    - id Item who needs to create Product
     * @param product    - object which need create
     */
    public void addProduct(long idCustomer, long idItems, Product product) {
        Item item = itemService.getItemById(idItems, idCustomer);
        item.getProducts().add(product);
        itemService.addOrUpdateItem(idCustomer, item);
    }
}
