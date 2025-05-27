package com.bear.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//import com.bear.models.Category;
//import com.bear.models.ListCategory;
import com.bear.models.Category;
import com.bear.models.ListCategory;
import com.bear.models.Product;
import com.example.k22411csampleproject.R;

public class ProductManagementActivity extends AppCompatActivity {
    Spinner spinnerCategory;
    ArrayAdapter<Category> adapterCategory;
    ListCategory listCategory;
    ListView lvProduct;
    ArrayAdapter<Product> adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Category c=adapterCategory.getItem(i);
                displayProductsByCategory(c);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // Thêm sự kiện long click cho ListView sản phẩm
        lvProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Product selectedProduct = adapterProduct.getItem(position);
                showOptionsMenu(selectedProduct);
                return true;  // Đã xử lý sự kiện
            }
        });
    }

    private void showOptionsMenu(Product selectedProduct) {
        String[] options = {"Details", "Edit", "Delete"};
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Set option for " + selectedProduct.getName())
                .setItems(options, (dialog, which) -> {
                    switch (which) {
                        case 0:
                            showProductDetail(selectedProduct);
                            break;
                        case 1:
                            editProduct(selectedProduct);
                            break;
                        case 2:
                            deleteProduct(selectedProduct);
                            break;
                    }
                }).show();
    }
    private void showProductDetail(Product product) {
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Details")
                .setMessage(
                        "Name: " + product.getName() +
                                "\nPrice: " + product.getPrice() +
                                "\nQuantity: " + product.getQuantity() +
                                "\nDescription: " + (product.getDescription() == null ? "No description" : product.getDescription())
                )
                .setPositiveButton("OK", null)
                .setNegativeButton("More Info", (dialog, which) -> {
                    // Mở màn hình chi tiết đầy đủ
                    Intent intent = new Intent(this, ProductDetailActivity.class);
                    intent.putExtra("product", product);
                    startActivity(intent);
                })
                .show();
    }


    private void editProduct(Product product) {
        // TODO: mở màn hình sửa sản phẩm (bạn tự tạo)
        // Intent intent = new Intent(this, EditProductActivity.class);
        // intent.putExtra("product_id", product.getId());
        // startActivity(intent);
    }

    private void deleteProduct(Product product) {
        // Xoá sản phẩm khỏi danh sách hiện tại và cập nhật ListView
        adapterProduct.remove(product);
        adapterProduct.notifyDataSetChanged();
    }


    private void displayProductsByCategory(Category c) {
        //xoá dữ liệu cũ trong listview
        adapterProduct.clear();
        //thêm dữ liệu mới
        adapterProduct.addAll(c.getProducts());
    }

    private void addViews() {
        spinnerCategory = findViewById(R.id.spinnerCategory);
        adapterCategory=new ArrayAdapter<>(ProductManagementActivity.this,
                android.R.layout.simple_spinner_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        listCategory=new ListCategory();
        listCategory.generate_sample_product_dataset();
        adapterCategory.addAll(listCategory.getCategories());

        lvProduct=findViewById(R.id.lvProduct);
        adapterProduct=new ArrayAdapter<>(ProductManagementActivity.this,
                android.R.layout.simple_list_item_1);
        lvProduct.setAdapter(adapterProduct);
    }
}