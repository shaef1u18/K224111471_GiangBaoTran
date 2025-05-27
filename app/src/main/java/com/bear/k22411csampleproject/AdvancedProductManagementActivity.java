//package com.bear.k22411csampleproject;
//
//import android.os.Bundle;
//import android.widget.ListView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.bear.models.ListProduct;

//
//import adapters.ProductAdapter;
//
//public class AdvancedProductManagementActivity extends AppCompatActivity {
//    ListView lvAdvancedProduct;
//    ProductAdapter adapter;
//    ListProduct listProduct;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_advanced_product_management);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        addViews();
//    }
//
//    private void addViews() {
//        lvAdvancedProduct=findViewById(R.id.lvAdvancedProduct);
//        adapter=new ProductAdapter(AdvancedProductManagementActivity.this,
//                R.layout.item_advanced_product
//                );
//        lvAdvancedProduct.setAdapter(adapter);
//
//        listProduct=new ListProduct();
//        listProduct.generate_sample_product_dataset();
//        adapter.addAll(listProduct.getProducts());
//    }
//}

package com.bear.k22411csampleproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bear.adapters.ProductAdapter;
import com.bear.models.ListProduct;
import com.example.k22411csampleproject.R;

public class AdvancedProductManagementActivity extends AppCompatActivity {

    ListView lvAdvancedProduct;
    ProductAdapter adapter;

    ListProduct listProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_advanced_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        lvAdvancedProduct=findViewById(R.id.lvAdvancedProduct);
        adapter=new ProductAdapter(AdvancedProductManagementActivity.this,
                R.layout.item_advanced_product
        );
        lvAdvancedProduct.setAdapter(adapter);

        listProduct=new ListProduct();
        listProduct.generate_sample_product_dataset();
        adapter.addAll(listProduct.getProducts());
    }
}