package com.bear.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bear.models.Category;
import com.bear.models.ListCategory;
import com.example.k22411csampleproject.R;

public class CategoryManagementActivity extends AppCompatActivity {

    ListView lvCategory;
    ArrayAdapter<Category> adapter;
    ListCategory listCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_management);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        addEvents();
    }

    private void addViews() {
        lvCategory = findViewById(R.id.lvCategory);
        listCategory = new ListCategory();
        listCategory.generate_sample_product_dataset(); // Tạo dữ liệu mẫu category + product

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adapter.addAll(listCategory.getCategories());
        lvCategory.setAdapter(adapter);
        for (Category c : listCategory.getCategories()) {
            Log.d("CategoryCheck", c.getName() + " có " + c.getProducts().size() + " sản phẩm.");
        }

    }

    private void addEvents() {
        lvCategory.setOnItemLongClickListener((parent, view, position, id) -> {
            Category selected = adapter.getItem(position);
            if (selected != null) {
                adapter.remove(selected);
            }
            return true;
        });

        lvCategory.setOnItemClickListener((parent, view, position, id) -> {
            Category selectedCategory = adapter.getItem(position);
            if (selectedCategory != null) {
                Intent intent = new Intent(CategoryManagementActivity.this, CategoryDetailActivity.class);
                intent.putExtra("category", selectedCategory);
                startActivity(intent);
            }
        });
    }
}
