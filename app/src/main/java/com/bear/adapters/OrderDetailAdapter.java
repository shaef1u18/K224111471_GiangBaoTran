package com.bear.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bear.models.OrderDetail;
import com.example.k22411csampleproject.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class OrderDetailAdapter extends ArrayAdapter<OrderDetail> {
    Context context;
    int resource;

    public OrderDetailAdapter(@NonNull Context context, int resource, @NonNull List<OrderDetail> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource, null);

        TextView txtProductID = view.findViewById(R.id.txtProductID);
        TextView txtPrice = view.findViewById(R.id.txtPrice);
        TextView txtQuantity = view.findViewById(R.id.txtQuantity);
        TextView txtDiscount = view.findViewById(R.id.txtDiscount);
        TextView txtVAT = view.findViewById(R.id.txtVAT);
        TextView txtSubtotal = view.findViewById(R.id.txtSubtotal);

        OrderDetail detail = getItem(position);

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        txtProductID.setText("Mã SP: " + detail.getProductID());
        txtPrice.setText("Đơn giá: " + nf.format(detail.getPrice()));
        txtQuantity.setText("Số lượng: " + detail.getQuantity());
        txtDiscount.setText("Chiết khấu: " + detail.getDiscount() + "%");
        txtVAT.setText("VAT: " + detail.getVat() + "%");
        txtSubtotal.setText("Tạm tính: " + nf.format(detail.getSubtotal()));

        return view;
    }
}
