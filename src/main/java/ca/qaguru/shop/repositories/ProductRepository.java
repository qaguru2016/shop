package ca.qaguru.shop.repositories;

import ca.qaguru.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByModel(String model);
    List<Product> findByCategoryAndBrand(String category, String brand);
}

