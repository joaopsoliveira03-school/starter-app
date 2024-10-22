package dev.joaop.controllers;

import dev.joaop.data.Products;
import dev.joaop.enums.Category;
import dev.joaop.exceptions.AlreadyExistsException;
import dev.joaop.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    private final Marker marker = MarkerFactory.getMarker("catalog-app");
    private final Logger logger = LoggerFactory.getLogger(CatalogController.class);

    public CatalogController() {
        generateDummyData();
        logger.info(marker, "CatalogController created.");
    }

    private void generateDummyData() {
        logger.info(marker, "Catalog dummy data generation...pending.");
        Product product1 = new Product("C001", "Computer A001", Category.COMPUTERS, 925.4f);

        try {
            Products.add(product1);
            Products.add(new Product("C002", "Computer A002", Category.COMPUTERS, 841.94f));
            Products.add(
                    new Product("P001", "Printer P001", Category.PRINTERS, 321.32f),
                    new Product("P002", "Printer P002", Category.PRINTERS, 128.98f)
            );
        } catch (AlreadyExistsException e) {
            logger.error(marker, "Error adding product: " + e.getMessage());
            return;
        } catch (IllegalArgumentException e) {
            logger.error(marker, "Error {} | Stacktrace {}", e.getStackTrace(), e.getMessage());
            return;
        }

        logger.info(marker, "Catalog dummy data generation...done.");
    }

    @RequestMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products;
        logger.info(marker, "getProducts(id) request received...pending.");
        products = Products.get();
        logger.info(marker, "getProducts(id) request received...2000K ({}).", products);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @RequestMapping("/products-by-category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") Category category) {
        List<Product> products;
        logger.info(marker, "getProducts(category) request received...pending.");
        products = Products.get(category);
        logger.info(marker, "getProducts(category) request received...2000K ({}).", products);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
        Product product;
        logger.info(marker, "getProductById(id) request received...pending.");
        product = Products.get(id);
        logger.info(marker, "getProductById(id) request received...2000K ({}).", product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
