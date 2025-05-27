package com.bear.k22411csampleproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.k22411csampleproject.R;

public class ProductDetailActivity extends AppCompatActivity {

    EditText edtProductId, edtProductName, edtProductQuantity, edtProductPrice, edtProductSold;
    Button btnNew, btnSave, btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);  // đổi theo tên file layout bạn đặt

        // Ánh xạ view
        edtProductId = findViewById(R.id.edt_product_id);
        edtProductName = findViewById(R.id.edt_product_name);
        edtProductQuantity = findViewById(R.id.edt_product_quantity);
        edtProductPrice = findViewById(R.id.edt_product_price);
        edtProductSold = findViewById(R.id.edt_product_sold);

        btnNew = findViewById(R.id.btn_new);
        btnSave = findViewById(R.id.btn_save);
        btnRemove = findViewById(R.id.btn_remove);

        // Xử lý sự kiện nút New
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputs();
            }
        });

        // Xử lý sự kiện nút Save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProduct();
            }
        });

        // Xử lý sự kiện nút Remove
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeProduct();
            }
        });
    }

    private void clearInputs() {
        edtProductId.setText("");
        edtProductName.setText("");
        edtProductQuantity.setText("");
        edtProductPrice.setText("");
        edtProductSold.setText("");
        Toast.makeText(this, "Cleared input fields", Toast.LENGTH_SHORT).show();
    }

    private void saveProduct() {
        String id = edtProductId.getText().toString().trim();
        String name = edtProductName.getText().toString().trim();
        String quantity = edtProductQuantity.getText().toString().trim();
        String price = edtProductPrice.getText().toString().trim();
        String sold = edtProductSold.getText().toString().trim();

        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Product ID and Name are required", Toast.LENGTH_SHORT).show();
            return;
        }

        // Ở đây bạn có thể thêm code lưu dữ liệu vào database hoặc gửi lên server
        // Hiện tại mình chỉ giả lập thông báo

        Toast.makeText(this, "Product saved:\nID: " + id + "\nName: " + name, Toast.LENGTH_LONG).show();
    }

    private void removeProduct() {
        String id = edtProductId.getText().toString().trim();

        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "Product ID required to remove", Toast.LENGTH_SHORT).show();
            return;
        }

        // Code xóa dữ liệu theo ID tại đây

        Toast.makeText(this, "Product with ID " + id + " removed", Toast.LENGTH_LONG).show();

        clearInputs();
    }
}
