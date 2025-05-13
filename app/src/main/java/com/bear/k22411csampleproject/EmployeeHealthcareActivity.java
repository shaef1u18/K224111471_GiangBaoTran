package com.bear.k22411csampleproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k22411csampleproject.R;
import com.utils.BMIResult;
import com.utils.Healthcare;

public class EmployeeHealthcareActivity extends AppCompatActivity {
    EditText edtHeight;
    EditText edtWeight;
    Button btnCalculate;
    Button btnClear;
    Button btnClose;
    TextView txtResult;

    View.OnClickListener myClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_healthcare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        myClick=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kiểm tra các View sử dụng biến sự kiện ở đây
                if(view.equals(btnCalculate))
                {
                    //View Calculate dang su dung su kien nay
                    double h=Double.parseDouble(edtHeight.getText().toString());
                    double w=Double.parseDouble(edtWeight.getText().toString());
                    BMIResult result= Healthcare.calculate(h,w,EmployeeHealthcareActivity.this);
                    txtResult.setText(result.getBMI()+"="+result.getDescription());
                }
                else if(view.equals(btnClear))
                    {
                    //View Clear dang su dung su kien nay
                        edtHeight.setText("");
                        edtWeight.setText("");
                        txtResult.setText("");
                        edtWeight.requestFocus();
                }
                else if(view.equals(btnClose))
                {
                    //View Close dang su dung su kien nay
                    finish();
                }
            }
        };
        //giúp biến sự kiện cho các view (sharing events):
        btnCalculate.setOnClickListener(myClick);
        btnClear.setOnClickListener(myClick);
        btnClose.setOnClickListener(myClick);
    }

    private void addViews() {
        edtHeight=findViewById(R.id.edtHeight);
        edtWeight=findViewById(R.id.edtWeight);
        btnCalculate=findViewById(R.id.btnCalculate);
        btnClear=findViewById(R.id.btnClear);
        btnClose=findViewById(R.id.btnClose);
        txtResult=findViewById(R.id.txtResult);

    }
}