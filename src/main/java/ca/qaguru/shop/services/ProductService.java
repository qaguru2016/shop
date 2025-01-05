package ca.qaguru.shop.services;

import ca.qaguru.shop.domain.Product;

import java.util.List;
import java.util.UUID;


public interface ProductService {
    Product saveNewProduct(Product product);
    List<Product> findAll();
    Product findById(UUID uuid);
    void updateById(UUID uuid, Product product);
    void deleteById(UUID uuid);

}
