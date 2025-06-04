package com.bear.connectors;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bear.models.ListPaymentMethod;
import com.bear.models.PaymentMethod;

public class PaymentMethodConnector {

    public ListPaymentMethod getAllPaymentMethods(SQLiteDatabase db) {
        ListPaymentMethod list = new ListPaymentMethod();
        Cursor cursor = db.rawQuery("SELECT * FROM PaymentMethod", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);

                PaymentMethod pm = new PaymentMethod(id, name, description);
                list.add(pm);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }
}
