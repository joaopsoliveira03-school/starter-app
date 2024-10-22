package dev.joaop.data;

import dev.joaop.enums.Category;
import dev.joaop.exceptions.AlreadyExistsException;
import dev.joaop.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private static final Logger logger = LoggerFactory.getLogger(Products.class);
    private static final List<Product> products = new ArrayList<>();
    private static final Marker readMarker = MarkerFactory.getMarker("product-read-operation");
    private static final Marker addMarker = MarkerFactory.getMarker("product-add-operation");

    public static List<Product> get() {
        logger.info(readMarker, "Reading all products");
        return products;
    }

    public static List<Product> get(Category category) {
        logger.info(readMarker, "Reading products by category: " + category);
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();
    }

    public static void add(Product product) throws IllegalArgumentException, AlreadyExistsException {
        logger.info(addMarker, "Adding product...pending.");

        // check if product is null
        if (product == null) {
            logger.error(addMarker, "Product object cannot be null.");
            throw new IllegalArgumentException();
        }

        // check if code is empty
        if (product.getCode().isEmpty()) {
            logger.error(addMarker, "Product code cannot be empty.");
            throw new IllegalArgumentException();
        }

        // check if exists already
        if (products.stream().anyMatch(p -> p.getCode().equals(product.getCode()))) {
            logger.error(addMarker, "Product {} would be duplicated in the list.", product.getCode());
            throw new AlreadyExistsException("Products.add()", product.getCode());
        }

        products.add(product);
        logger.info(addMarker, "Product {} added successfully.", product.getCode());
    }

    public static void add(Product... products) throws IllegalArgumentException, AlreadyExistsException {
        for (Product product : products) {
            add(product);
        }
    }

    public static Product get(String id) {
        logger.info(readMarker, "Reading product by id: {}", id);
        return products.stream()
                .filter(product -> product.getCode().equals(id))
                .findFirst()
                .orElse(null);
    }
}
