package com.bear.k22411csampleproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bear.adapters.TelephonyInforAdapter;
import com.bear.models.TelephonyInfor;
import com.example.k22411csampleproject.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TelephonyActivity extends AppCompatActivity {

    ListView lvTelephony;
    TelephonyInforAdapter adapter;
    private static final int REQUEST_CONTACTS_PERMISSION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephony);

        addViews();

        // Xin quyền đọc danh bạ
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    REQUEST_CONTACTS_PERMISSION);
        } else {
            getAllContacts();
        }

        addEvents();
    }

    private void addViews() {
        lvTelephony = findViewById(R.id.lvTelephonyInfor);
        adapter = new TelephonyInforAdapter(this, R.layout.item_telephony_infor, new ArrayList<>());
        lvTelephony.setAdapter(adapter);
    }

    private void addEvents() {
        lvTelephony.setOnItemClickListener((adapterView, view, i, l) -> {
            TelephonyInfor ti = adapter.getItem(i);
            makeAPhoneCall(ti);
        });
    }

    private void makeAPhoneCall(TelephonyInfor ti) {
        Uri uri = Uri.parse("tel:" + ti.getPhone());
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    private void getAllContacts() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor == null) return;

        adapter.clear();

        while (cursor.moveToNext()) {
            int nameIndex = cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            int phoneIndex = cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER);

            String name = cursor.getString(nameIndex);
            String phone = cursor.getString(phoneIndex);

            TelephonyInfor ti = new TelephonyInfor();
            ti.setName(name);
            ti.setPhone(phone);
            adapter.add(ti);
        }

        cursor.close();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_viettel) {
            filterContactsByCarrier("viettel");
            return true;
        } else if (id == R.id.menu_mobifone) {
            filterContactsByCarrier("mobifone");
            return true;
        } else if (id == R.id.menu_other) {
            filterContactsByCarrier("other");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void directCall(TelephonyInfor ti) {
        Uri uri = Uri.parse("tel:" + ti.getPhone());
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Chưa có quyền CALL_PHONE", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(intent);
    }

    public void dialupCall(TelephonyInfor ti) {
        Uri uri = Uri.parse("tel:" + ti.getPhone());
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }


    private void filterContactsByCarrier(String carrier) {
        List<String> viettelPrefixes = Arrays.asList("086", "096", "097", "098", "032", "033", "034", "035", "036", "037", "038", "039");
        List<String> mobifonePrefixes = Arrays.asList("089", "090", "093", "070", "079", "077", "076", "078");

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor == null) return;

        adapter.clear();

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER)).replaceAll("\\s", "");

            if (phone.length() >= 10) {
                String prefix = phone.substring(phone.length() - 10, phone.length() - 7);

                boolean isMatch = false;
                if (carrier.equals("viettel") && viettelPrefixes.contains(prefix)) {
                    isMatch = true;
                } else if (carrier.equals("mobifone") && mobifonePrefixes.contains(prefix)) {
                    isMatch = true;
                } else if (carrier.equals("other")
                        && !viettelPrefixes.contains(prefix)
                        && !mobifonePrefixes.contains(prefix)) {
                    isMatch = true;
                }

                if (isMatch) {
                    TelephonyInfor ti = new TelephonyInfor();
                    ti.setName(name);
                    ti.setPhone(phone);
                    adapter.add(ti);
                }
            }
        }

        cursor.close();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CONTACTS_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getAllContacts();
            } else {
                Toast.makeText(this, "Contacts permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
