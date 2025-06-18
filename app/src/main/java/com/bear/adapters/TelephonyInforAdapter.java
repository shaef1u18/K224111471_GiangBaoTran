package com.bear.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bear.k22411csampleproject.SendSMSActivity;
import com.bear.k22411csampleproject.TelephonyActivity;
import com.bear.models.TelephonyInfor;
import com.example.k22411csampleproject.R;

import java.util.List;

public class TelephonyInforAdapter extends ArrayAdapter<TelephonyInfor> {
    Activity context;
    int resource;

    public TelephonyInforAdapter(@NonNull Activity context, int resource, @NonNull List<TelephonyInfor> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = this.context.getLayoutInflater();
            convertView = inflater.inflate(this.resource, parent, false);
        }

        TextView txtTelephonyName = convertView.findViewById(R.id.txtTelephonyName);
        TextView txtTelephonyNumber = convertView.findViewById(R.id.txtTelephonyNumber);
        ImageView imgDirectCall = convertView.findViewById(R.id.imgDirectCall);
        ImageView imgDialUp = convertView.findViewById(R.id.imgDialUp);
        ImageView imgSendSms = convertView.findViewById(R.id.imgSendSms);

        TelephonyInfor ti = getItem(position);
        if (ti == null) return convertView;

        txtTelephonyName.setText(ti.getName());
        txtTelephonyNumber.setText(ti.getPhone());

        imgDirectCall.setOnClickListener(view -> {
            if (context instanceof TelephonyActivity) {
                ((TelephonyActivity) context).directCall(ti);
            }
        });

        imgDialUp.setOnClickListener(view -> {
            if (context instanceof TelephonyActivity) {
                ((TelephonyActivity) context).dialupCall(ti);
            }
        });

        imgSendSms.setOnClickListener(view -> {
            Intent intent = new Intent(context, SendSMSActivity.class);
            intent.putExtra("TI", ti);
            context.startActivity(intent);
        });

        return convertView;
    }
}
