package ca.qaguru.shop.services;

import ca.qaguru.shop.repositories.ProductRepository;
import ca.qaguru.shop.domain.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    Product getProduct() {
        return Product.builder()
                .name("Sharpie")
                .description("Highligter pen")
                .price(1.99F)
                .build();
    }
    @Test
    void save() {
        when(productRepository.save(any())).thenReturn(getProduct());
        Product savedProduct = productService.saveNewProduct(getProduct());
        assertNotNull(savedProduct);

    }


    @Test
    void findAll() {

    }

    @Test
    void findById() {
        when(productRepository.findById(any())).thenReturn(Optional.of(getProduct()));
        assertNotNull(productService.findById(UUID.randomUUID()));
        verify(productRepository).findById(any());

    }

    @Test
    void updateById() {
        when(productRepository.findById(any())).thenReturn(Optional.of(getProduct()));
        when(productRepository.save(any())).thenReturn(getProduct());
        productService.updateById(UUID.randomUUID(),getProduct());
        verify(productRepository).save(any());

    }

    @Test
    void deleteById() {
        when(productRepository.findById(any())).thenReturn(Optional.of(getProduct()));
        productService.deleteById(UUID.randomUUID());
        verify(productRepository).deleteById(any());

    }


}