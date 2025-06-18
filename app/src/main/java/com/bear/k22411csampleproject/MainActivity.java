package com.bear.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k22411csampleproject.R;

public class MainActivity extends AppCompatActivity {

    ImageView imgEmployee;
    TextView txtEmployee;

    ImageView imgCustomer;
    TextView txtCustomer;

    ImageView imgProduct;
    TextView txtProduct;

    ImageView imgAdvancedProduct;
    TextView txtAdvancedProduct;

    ImageView imgPaymentMethod;
    TextView txtPaymentMethod;

    ImageView imgOrder;
    TextView txtOrder;

    ImageView imgTelephony;
    TextView txtTelephony;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addEvents() {
        imgEmployee.setOnClickListener(view -> openEmployeeManagementActivity());
        txtEmployee.setOnClickListener(view -> openEmployeeManagementActivity());

        imgCustomer.setOnClickListener(view -> openCustomerManagementActivity());
        txtCustomer.setOnClickListener(view -> openCustomerManagementActivity());

        imgProduct.setOnClickListener(view -> openProductManagementActivity());
        txtProduct.setOnClickListener(view -> openProductManagementActivity());

        imgAdvancedProduct.setOnClickListener(view -> openAdvancedProductManagementActivity());
        txtAdvancedProduct.setOnClickListener(view -> openAdvancedProductManagementActivity());

        imgPaymentMethod.setOnClickListener(view -> openPaymentMethodActivity());
        txtPaymentMethod.setOnClickListener(view -> openPaymentMethodActivity());

        imgOrder.setOnClickListener(view -> openOrdersViewerActivity());
        txtOrder.setOnClickListener(view -> openOrdersViewerActivity());

        imgTelephony.setOnClickListener(view -> openTelephonyActivity());
        txtTelephony.setOnClickListener(view -> openTelephonyActivity());
    }

    private void openTelephonyActivity() {
        Intent intent = new Intent(MainActivity.this, TelephonyActivity.class);
        startActivity(intent);
    }

    private void openPaymentMethodActivity() {
        Intent intent = new Intent(MainActivity.this, PaymentMethodActivity.class);
        startActivity(intent);
    }

    private void openAdvancedProductManagementActivity() {
        Intent intent = new Intent(MainActivity.this, AdvancedProductManagementActivity.class);
        startActivity(intent);
    }

    private void openProductManagementActivity() {
        Intent intent = new Intent(MainActivity.this, ProductManagementActivity.class);
        startActivity(intent);
    }

    private void openEmployeeManagementActivity() {
        Intent intent = new Intent(MainActivity.this, EmployeeManagementActivity.class);
        startActivity(intent);
    }

    private void openCustomerManagementActivity() {
        Intent intent = new Intent(MainActivity.this, CustomerManagementActivity.class);
        startActivity(intent);
    }

    private void openOrdersViewerActivity() {
        Intent intent = new Intent(MainActivity.this, OrdersViewerActivity.class);
        startActivity(intent);
    }

    private void addViews() {
        imgEmployee = findViewById(R.id.imgEmployee);
        txtEmployee = findViewById(R.id.txtEmployee);

        imgCustomer = findViewById(R.id.imgCustomer);
        txtCustomer = findViewById(R.id.txtCustomer);

        imgProduct = findViewById(R.id.imgProduct);
        txtProduct = findViewById(R.id.txtProduct);

        imgAdvancedProduct = findViewById(R.id.imgAdvancedProduct);
        txtAdvancedProduct = findViewById(R.id.txtAdvancedProduct);

        imgPaymentMethod = findViewById(R.id.imgPaymentMethod);
        txtPaymentMethod = findViewById(R.id.txtPaymentMethod);

        imgOrder = findViewById(R.id.imgOrder);
        txtOrder = findViewById(R.id.txtOrder);

        imgTelephony = findViewById(R.id.imgTelephony);
        txtTelephony = findViewById(R.id.txtTelephony);
    }
}
