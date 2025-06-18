package com.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        //khi có tin nhắn SMS tới nó tự động nhảy vào đây
        Bundle bundle=intent.getExtras();
        Object[] arrMessages=(Object[])bundle.get("pdus");
        String phone, time, content;
        Date date;
        byte[] bytes;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for(int i=0;i<arrMessages.length;i++)
        {
            bytes=(byte[])arrMessages[i];
            SmsMessage smsMessage=SmsMessage.createFromPdu(bytes);
            phone=smsMessage.getOriginatingAddress();
            date=new Date(smsMessage.getTimestampMillis());
            content=smsMessage.getMessageBody();
            time=sdf.format(date);
            String infor=phone+"\n"+time+"\n"+content;
            //ta sẽ gửi lên Server của ta sau
            Toast.makeText(context,infor,Toast.LENGTH_LONG).show();
        }
    }
}
