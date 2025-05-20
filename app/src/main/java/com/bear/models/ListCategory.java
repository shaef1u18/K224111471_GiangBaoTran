package com.bear.models;

import android.util.Log;

import java.util.ArrayList;

public class ListCategory {
    private ArrayList<Category> categories;

    public ListCategory() {
        categories = new ArrayList<>();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    // Tạo dữ liệu mẫu, gồm 5 category và phân loại sản phẩm vào đúng category
    public void generate_sample_product_dataset() {
        categories.clear();

        // Tạo 5 category mẫu
        for (int i = 1; i <= 5; i++) {
            categories.add(new Category(i, "Category " + i));
        }

        // Tạo danh sách sản phẩm mẫu
        ListProduct listProduct = new ListProduct();
        listProduct.generate_sample_dataset();

        // Phân loại sản phẩm vào đúng category dựa vào cate_id
        for (Product p : listProduct.getProducts()) {
            for (Category c : categories) {
                if (p.getCate_id() == c.getId()) {
                    c.addProduct(p);
                    break;
                            }
                        }
                    }

                }
            }
