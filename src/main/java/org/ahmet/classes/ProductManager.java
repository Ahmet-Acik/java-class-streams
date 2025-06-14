// ProductManager.java
package org.ahmet.classes;

import java.util.List;
import java.util.stream.Collectors;

public class ProductManager {
    private List<Product> products;

    public ProductManager(List<Product> products) {
        this.products = products;
    }

    public List<Product> filterByPriceRange(double minPrice, double maxPrice) {
        return products.stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<String> getProductNames() {
        return products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    public double calculateTotalInventoryValue() {
        return products.stream()
                .mapToDouble(product -> product.getPrice() * product.getQuantity())
                .sum();
    }
}

