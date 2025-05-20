package com.bear.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ListProduct implements Serializable {
    private ArrayList<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void generate_sample_dataset() {
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            int id = i;
            String name = "Product " + i;
            int quantity = random.nextInt(100) + 1; // Random quantity between 1 and 100
            double price = random.nextDouble() * 1000; // Random price between 0 and 1000
            int categoryId = random.nextInt(5) + 1; // Random categoryId between 1 and 5
            String description = "Description of Product " + i;

            Product p = new Product(id, name, quantity, price, categoryId);
            addProduct(p);
        }
    }
}
