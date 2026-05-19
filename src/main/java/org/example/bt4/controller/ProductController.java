package org.example.bt4.controller;

import org.example.bt4.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product("P001", "Laptop", 1200));
        products.add(new Product("P002", "Mouse", 25));
        products.add(new Product("P003", "Keyboard", 50));
    }

    @PutMapping("/{productId}")
    public Object updateProduct(@PathVariable String productId,
                                @RequestBody Product updatedProduct) {

        for (Product p : products) {

            if (p.getId().equalsIgnoreCase(productId)) {

                p.setName(updatedProduct.getName());
                p.setPrice(updatedProduct.getPrice());

                return p;
            }
        }

        return "Product not found";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable String productId) {

        for (Product p : products) {

            if (p.getId().equalsIgnoreCase(productId)) {

                products.remove(p);

                return "Delete product successfully";
            }
        }

        return "Product not found";
    }
}