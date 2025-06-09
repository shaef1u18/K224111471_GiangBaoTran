package com.bear.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bear.adapters.OrdersViewerAdapter;
import com.bear.connectors.OrdersViewerConnector;
import com.bear.connectors.SQLiteConnector;
import com.bear.models.OrdersViewer;
import com.example.k22411csampleproject.R;

import java.util.ArrayList;

public class OrdersViewerActivity extends AppCompatActivity {

    ListView lvOrdersViewer;
    OrdersViewerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_orders_viewer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        lvOrdersViewer=findViewById(R.id.lvOrdersViewer);
        adapter=new OrdersViewerAdapter(this,R.layout.item_ordersviewer);
        lvOrdersViewer.setAdapter(adapter);

        SQLiteConnector connector=new SQLiteConnector(this);
        OrdersViewerConnector ovc=new OrdersViewerConnector();
        ArrayList<OrdersViewer> datasets=ovc.getAllOrdersViewer(connector.openDatabase());
        adapter.addAll(datasets);

        lvOrdersViewer.setOnItemClickListener((parent, view, position, id) -> {
            OrdersViewer selected = adapter.getItem(position);

            if (selected != null) {
                int orderId = selected.getID(); // 🔍 Đảm bảo getID() trả về ID thật
                Log.d("CLICK_EVENT", "Clicked order ID: " + orderId); // ✅ debug

                Intent intent = new Intent(OrdersViewerActivity.this, OrderDetailActivity.class);
                intent.putExtra("OrderID", orderId);
                startActivity(intent);
            } else {
                Log.e("CLICK_EVENT", "Selected order is null");
            }
        });




    }
}