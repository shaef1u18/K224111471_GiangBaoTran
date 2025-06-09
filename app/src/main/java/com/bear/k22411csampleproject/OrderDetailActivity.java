package com.bear.k22411csampleproject;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bear.adapters.OrderDetailAdapter;
import com.bear.connectors.OrderDetailConnector;
import com.bear.connectors.SQLiteConnector;
import com.bear.models.OrderDetail;
import com.example.k22411csampleproject.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class OrderDetailActivity extends AppCompatActivity {

    ListView lvOrderDetails;
    TextView txtOrderTotal;
    OrderDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        lvOrderDetails = findViewById(R.id.lvOrderDetails);
        txtOrderTotal = findViewById(R.id.txtOrderTotal); // phải khai báo trong XML

        int orderId = getIntent().getIntExtra("OrderID", -1);

        if (orderId == -1) {
            Toast.makeText(this, "Không tìm thấy hóa đơn.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        SQLiteConnector connector = new SQLiteConnector(this);
        OrderDetailConnector detailConnector = new OrderDetailConnector();
        ArrayList<OrderDetail> details = detailConnector.getDetailsByOrderId(connector.openDatabase(), orderId);

        if (details.isEmpty()) {
            Toast.makeText(this, "Không có chi tiết nào cho hóa đơn này.", Toast.LENGTH_SHORT).show();
        }

        adapter = new OrderDetailAdapter(this, R.layout.item_order_detail, details);
        lvOrderDetails.setAdapter(adapter);

        double total = 0;
        for (OrderDetail d : details) {
            double lineTotal = (d.getPrice() * d.getQuantity()) * (1 - d.getDiscount() / 100.0) * (1 + d.getVat() / 100.0);
            total += lineTotal;
        }

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        txtOrderTotal.setText("Tổng giá trị hóa đơn: " + currencyFormat.format(total));
    }
}
