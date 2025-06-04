package com.bear.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PaymentMethod {
    private int id;
    private String name;
    private String description;

    public PaymentMethod() {
    }

    public PaymentMethod(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // This method simulates finding a PaymentMethod by username and password
    public static PaymentMethod findByCredentials(SQLiteDatabase database, String username, String password) {
        Cursor cursor = database.rawQuery(
                "SELECT * FROM PaymentMethod WHERE Username = ? AND Password = ?",
                new String[]{username, password}
        );

        PaymentMethod pm = null;

        if (cursor.moveToFirst()) {
            pm = new PaymentMethod();
            pm.setId(cursor.getInt(0));
            pm.setName(cursor.getString(1));
            pm.setDescription(cursor.getString(2));
        }

        cursor.close();
        return pm;
    }
}
