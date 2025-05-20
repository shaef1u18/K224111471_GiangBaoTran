package com.bear.k22411csampleproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bear.models.Category;
import com.bear.models.Product;
import com.example.k22411csampleproject.R;

public class CategoryDetailActivity extends AppCompatActivity {

    ListView lvProducts;
    ArrayAdapter<Product> adapter;
    Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        lvProducts = findViewById(R.id.lvProducts);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvProducts.setAdapter(adapter);

        category = (Category) getIntent().getSerializableExtra("category");

        if (category == null) {
            Log.e("CategoryDetail", "Category nhận được là null!");
            Toast.makeText(this, "Category data is missing!", Toast.LENGTH_LONG).show();
            finish();  // Đóng activity nếu không có dữ liệu
            return;
        }

        Log.d("CategoryDetail", "Category: " + category.getName());
        Log.d("CategoryDetail", "Số sản phẩm: " + category.getProducts().size());

        if (category.getProducts() != null && !category.getProducts().isEmpty()) {
            adapter.addAll(category.getProducts());
        } else {
            Toast.makeText(this, "Category chưa có sản phẩm nào!", Toast.LENGTH_LONG).show();
        }
    }
}
