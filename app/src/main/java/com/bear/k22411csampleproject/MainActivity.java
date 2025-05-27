//package com.bear.k22411csampleproject;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.example.k22411csampleproject.R;
//
//public class MainActivity extends AppCompatActivity {
//
//    ImageView imgEmployee;
//    TextView txtEmployee;
//    ImageView imgCustomer;
//    TextView txtCustomer;
//    ImageView imgProduct;
//    TextView txtProduct;
//    ImageView imgAdvancedProduct;
//    TextView txtAdvancedProduct;
////    ImageView imgCategory;
////    TextView txtCategory;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        addViews();
//        addEvents();
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//
//    private void addEvents() {
//        imgEmployee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Gọi code mở màn hình quản trị nhân sự
//                openEmployeeManagementActivity();
//            }
//        });
//        txtEmployee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Gọi code mở màn hình quản trị nhân sự
//                openEmployeeManagementActivity();
//            }
//        });
//
//        imgCustomer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openCustomerManagementActivity();
//            }
//        });
//        txtCustomer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Gọi code mở màn hình quản trị nhân sự
//                openCustomerManagementActivity();
//            }
//        });
//        imgProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openProductManagementActivity();
//            }
//        });
//        txtProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openProductManagementActivity();
//            }
//        });
//        imgAdvancedProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View view){
//                openAdvancedProductManagementActivity();
//            }
//        });
//        txtAdvancedProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdvancedProductManagementActivity();
//            }
//        });
////        imgCategory.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view){
////                openCategoryManagementActivity();
////            }
////        });
////        txtCategory.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick (View view){
////                openCategoryManagementActivity();
////            }
//    }
//
//    private void openAdvancedProductManagementActivity() {
//        Intent intent=new Intent(MainActivity.this, AdvancedProductManagementActivity.class);
//        startActivity(intent);
//    }
//
//    private void openCategoryManagementActivity() {
//        Intent intent = new Intent(MainActivity.this, CategoryManagementActivity.class);
//        startActivity(intent);
//    }
//
//    void openProductManagementActivity() {
//        Intent intent=new Intent(MainActivity.this, ProductManagementActivity.class);
//        startActivity(intent);
//    }
//    void openEmployeeManagementActivity()
//    {
//        Intent intent=new Intent(MainActivity.this, EmployeeManagementActivity.class);
//        startActivity(intent);
//    }
//
//    void openCustomerManagementActivity()
//    {
//        Intent intent=new Intent(MainActivity.this, CustomerManagementActivity.class);
//        startActivity(intent);
//    }
//
//    private void addViews() {
//        imgEmployee = findViewById(R.id.imgEmployee);
//        txtEmployee = findViewById(R.id.txtEmployee);
//        imgCustomer = findViewById(R.id.imgCustomer);
//        txtCustomer = findViewById(R.id.txtCustomer);
//        imgProduct = findViewById(R.id.imgProduct);
//        txtProduct = findViewById(R.id.txtProduct);
//        imgAdvancedProduct = findViewById(R.id.imgAdvancedProduct);
//        txtAdvancedProduct = findViewById(R.id.txtAdvancedProduct);
////        imgCategory = findViewById(R.id.imgCategory);
////        txtCategory = findViewById(R.id.txtCategory);
//    }
//
//    public void addEvents(View view) {
//    }
//}
package com.bear.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        imgEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //gọi code mở màn hình quản trị nhân sự
                openEmployeeManagementActivity();
            }
        });
        txtEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //gọi code mở màn hình quản trị nhân sự
                openEmployeeManagementActivity();
            }
        });

        imgCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCustomerManagementActivity();
            }
        });
        txtCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCustomerManagementActivity();
            }
        });

        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProductManagementActivity();
            }
        });
        txtProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProductManagementActivity();
            }
        });
        imgAdvancedProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdvancedProductManagementActivity();
            }
        });
        txtAdvancedProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdvancedProductManagementActivity();
            }
        });
    }

    private void openAdvancedProductManagementActivity() {
        Intent intent=new Intent(MainActivity.this, AdvancedProductManagementActivity.class);
        startActivity(intent);
    }

    private void openProductManagementActivity() {
        Intent intent=new Intent(MainActivity.this, ProductManagementActivity.class);
        startActivity(intent);
    }

    void openEmployeeManagementActivity()
    {
        Intent intent=new Intent(MainActivity.this, EmployeeManagementActivity.class);
        startActivity(intent);
    }
    void openCustomerManagementActivity()
    {
        Intent intent=new Intent(MainActivity.this, CustomerManagementActivity.class);
        startActivity(intent);
    }

    private void addViews() {
        imgEmployee=findViewById(R.id.imgEmployee);
        txtEmployee=findViewById(R.id.txtEmployee);
        imgCustomer=findViewById(R.id.imgCustomer);
        txtCustomer=findViewById(R.id.txtCustomer);
        imgProduct=findViewById(R.id.imgProduct);
        txtProduct=findViewById(R.id.txtProduct);
        imgAdvancedProduct=findViewById(R.id.imgAdvancedProduct);
        txtAdvancedProduct=findViewById(R.id.txtAdvancedProduct);
    }
}