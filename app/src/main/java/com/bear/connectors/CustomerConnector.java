package com.bear.connectors;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bear.models.Customer;
import com.bear.models.ListCustomer;

import java.util.ArrayList;

public class CustomerConnector {
    ListCustomer listCustomer;
    public CustomerConnector()
    {
        listCustomer=new ListCustomer();
        listCustomer.generate_sample_dataset();
    }
    public ArrayList<Customer> get_all_customers()
    {
        if (listCustomer==null)
        {
            listCustomer=new ListCustomer();
            listCustomer.generate_sample_dataset();
        }
        return listCustomer.getCustomers();
    }
    public ArrayList<Customer> get_customers_by_provider(String provider)
    {
        if (listCustomer==null)
        {
            listCustomer=new ListCustomer();
            listCustomer.generate_sample_dataset();
        }
        ArrayList<Customer>results=new ArrayList<>();
        for(Customer c : listCustomer.getCustomers())
        {
            if(c.getPhone().startsWith(provider))
            {
                results.add(c);
            }
        }
        return results;
    }
    public boolean isExist(Customer c)
    {
        return listCustomer.isExist(c);
    }
    public void addCustomer(Customer c)
    {
        listCustomer.addCustomer(c);
    }

    /**
     * Đây là hàm truy vấn toàn bộ dữ liệu khách hàng
     * Sau đó mô hình hoá đối tượng
     * @param database
     * @return trả về ListCustomer
     */
    public ListCustomer getAllCustomers(SQLiteDatabase database)
    {
        listCustomer = new ListCustomer();
        Cursor cursor = database.rawQuery("SELECT * FROM Customer ", null);
        while (cursor.moveToNext()) {
            int ID = cursor.getInt(0);
            String Name = cursor.getString(1);
            String Email = cursor.getString(2);
            String Phone = cursor.getString(3);
            String Username = cursor.getString(4);
            String Password = cursor.getString(5);
            Customer c = new Customer();
            c.setId(ID);
            c.setName(Name);
            c.setEmail(Email);
            c.setPhone(Phone);
            c.setUsername(Username);
            c.setPassword(Password);
            listCustomer.addCustomer(c);
            //To do something ….
        }
        cursor.close();
        return listCustomer;
    }
    public long saveNewCustomer(Customer c, SQLiteDatabase database)
    {
        ContentValues values=new ContentValues();
        values.put("Name",c.getName());
        values.put("Email",c.getEmail());
        values.put("Phone",c.getPhone());
        values.put("Username",c.getUsername());
        values.put("Password",c.getPassword());
        long flag=database.insert("Customer",null,values);
        return flag;
    }
    public long saveUpdateCustomer(Customer c, SQLiteDatabase database)
    {
        ContentValues values=new ContentValues();
        values.put("Name",c.getName());
        values.put("Email",c.getEmail());
        values.put("Phone",c.getPhone());
        values.put("Username",c.getUsername());
        values.put("Password",c.getPassword());
        long flag=database.update("Customer",values,"Id=?", new String[]{c.getId()+""});
        return flag;
    }
    public long removeCustomer(String Id, SQLiteDatabase database)
    {
        int flag=database.delete("Customer","Id=?", new String[]{Id});
        return flag;
    }
}
