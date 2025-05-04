package ca.qaguru.shop.bootstrap;

import ca.qaguru.shop.domain.Product;
import ca.qaguru.shop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class DataLoad implements CommandLineRunner {

    @Autowired
    private final ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count()==0){
            loadProducts();
        }
    }

    private void loadProducts() {
        Product product1 = Product.builder()
                .brand("Thermos")
                .category("sports")
                .model("TH20004")
                .description("Thermos Vacuum Insulated Spiderman FUNTainer Bottle, 355 ml")
                .price(16.97F)
                .build();
        Product product2 = Product.builder()
                .brand("Hamilton Beach")
                .category("appliance")
                .model("HAM86776")
                .description("Hamilton Beach 4 Slice Toaster Oven 31401C")
                .price(16.97F)
                .build();
        Product product3 = Product.builder()
                .brand("Puma")
                .category("shoes")
                .model("PUM8766")
                .description("TruBlue The Original Backpack - Redwood")
                .price(39.96F)
                .build();
        Product product4 = Product.builder()
                .brand("Puma")
                .category("shoes")
                .model("PUM4536")
                .description("Walking shoes")
                .price(94.97F)
                .build();
        Product product5 = Product.builder()
                .brand("Nike")
                .category("shoes")
                .model("NIK4345")
                .description("Running shoes")
                .price(120.96F)
                .build();
        Product product6 = Product.builder()
                .brand("Adidas")
                .category("shoes")
                .model("AD96543")
                .description("Walking shoes")
                .price(73.96F)
                .build();
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        log.info("Number of products loaded via bootstrap - "+ productRepository.count());

    }
}
