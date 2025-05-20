package com.bear.models;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private int id;
    private String name;
    private ArrayList<Product> products;

    public Category() {
        products = new ArrayList<>();
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        products = new ArrayList<>();
    }

    // Getter - Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    // Thêm sản phẩm vào danh sách sản phẩm
    public void addProduct(Product product) {
        products.add(product);
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
