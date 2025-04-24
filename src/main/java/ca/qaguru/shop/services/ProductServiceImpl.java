package ca.qaguru.shop.services;

import ca.qaguru.shop.domain.Product;
import ca.qaguru.shop.exception.ProductNotFoundException;
import ca.qaguru.shop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Override
    public Product saveNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(UUID uuid) {
        return productRepository.findById(uuid).orElseThrow(()->{
            throw new ProductNotFoundException("Product not found");
        });
    }

    @Override
    public void updateById(UUID uuid, Product product) {
        findById(uuid);
        product.setId(uuid);
        productRepository.save(product);

    }

    @Override
    public void deleteById(UUID uuid) {
        findById(uuid);
        productRepository.deleteById(uuid);

    }
}
