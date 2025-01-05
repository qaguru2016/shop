package ca.qaguru.shop.repositories;

import ca.qaguru.shop.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    Product getProduct() {
        return Product.builder()
                .name("Sharpie")
                .description("Highligter pen")
                .price(1.99F)
                .build();
    }

    @Test
    void saveProduct() {
        productRepository.save(getProduct());
        assertTrue(productRepository.count()>0);
    }

    @Test
    void findProduct() {
        productRepository.save(getProduct());
        Product savedProduct = productRepository.findByName(getProduct().getName()).orElseThrow(()-> {
            throw new RuntimeException("Product not found");
        });

    }
    @Test
    void updateProduct(){
        productRepository.save(getProduct());
        Product savedProduct = productRepository.findByName(getProduct().getName()).orElseThrow(()-> {
            throw new RuntimeException("Product not found");
        });

        String updatedDesc = "Safe highlighter for kids";
        savedProduct.setDescription(updatedDesc);
        productRepository.save(savedProduct);
        Assertions.assertEquals(updatedDesc,productRepository.findByName(getProduct().getName()).get().getDescription());

    }
    @Test
    void deleteProduct() {
        productRepository.save(getProduct());
        assertEquals(1,productRepository.count());
        Product savedProduct = productRepository.findByName(getProduct().getName()).orElseThrow(()-> {
            throw new RuntimeException("Product not found");
        });
        productRepository.deleteById(savedProduct.getId());

    }


}