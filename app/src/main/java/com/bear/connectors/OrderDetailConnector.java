package com.bear.connectors;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bear.models.OrderDetail;

import java.util.ArrayList;

public class OrderDetailConnector {
    public ArrayList<OrderDetail> getDetailsByOrderId(SQLiteDatabase db, int orderId) {
        ArrayList<OrderDetail> list = new ArrayList<>();

        String sql = "SELECT ProductID, Price, Quantity, Discount, VAT, Subtotal FROM OrderDetails WHERE OrderID = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(orderId)});

        while (cursor.moveToNext()) {
            OrderDetail detail = new OrderDetail();
            detail.setProductID(cursor.getInt(0));      // ProductID
            detail.setPrice(cursor.getDouble(1));       // Price
            detail.setQuantity(cursor.getInt(2));       // Quantity
            detail.setDiscount(cursor.getDouble(3));    // Discount
            detail.setVat(cursor.getDouble(4));         // VAT
            detail.setSubtotal(cursor.getDouble(5));    // Subtotal
            list.add(detail);
        }

        cursor.close();
        return list;
    }
}
