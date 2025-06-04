package com.bear.connectors;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.bear.models.Employee;
import com.bear.models.ListEmployee;

public class EmployeeConnector {

    public Employee login(SQLiteDatabase database, String usr, String pwd) {
        Cursor cursor = database.rawQuery(
                "SELECT * FROM Employee WHERE Username = ? AND Password = ?",
                new String[]{usr, pwd});

        Employee emp = null;

        if (cursor.moveToFirst()) {
            emp = new Employee();
            emp.setId(cursor.getInt(0));
            emp.setName(cursor.getString(1));
            emp.setEmail(cursor.getString(2));
            emp.setPhone(cursor.getString(3));
            emp.setUsername(cursor.getString(4));
            emp.setPassword(cursor.getString(5));
        }

        cursor.close();
        return emp; // đã thêm return ở đây
    }

    public Employee login(String usr, String pwd) {
        ListEmployee le = new ListEmployee();
        le.gen_dataset();
        for (Employee emp : le.getEmployees()) {
            if (emp.getUsername().equalsIgnoreCase(usr) && emp.getPassword().equals(pwd)) {
                return emp;
            }
        }
        return null;
    }
}
