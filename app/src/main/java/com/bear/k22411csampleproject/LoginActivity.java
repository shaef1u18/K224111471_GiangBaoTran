package com.bear.k22411csampleproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast; // Import Toast

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bear.connectors.EmployeeConnector;
import com.bear.models.Employee;
import com.example.k22411csampleproject.R;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    CheckBox chkSaveLoginInfor;
    Button btnLogin;
    ImageView btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        addViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        chkSaveLoginInfor = findViewById(R.id.chkSaveLoginInfor);
        btnLogin=findViewById(R.id.btnLogin);
        btnExit=findViewById(R.id.btnExit);
    }

    public void do_login(View view) {
        String usr = edtUsername.getText().toString();
        String pwd = edtPassword.getText().toString();
        EmployeeConnector ec = new EmployeeConnector();

        Employee emp = ec.login(usr, pwd);
        if (emp != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            // Toast for login failure
            Toast.makeText(this, "Login failed - please check your account again", Toast.LENGTH_LONG).show();
        }
    }

    public void do_exit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        Resources res = getResources();

        // Title
        builder.setTitle(res.getText(R.string.confirm_exit_title));
        // Message
        builder.setMessage(res.getText(R.string.confirm_exit_message));
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        // YES button
        builder.setPositiveButton(res.getText(R.string.confirm_exit_yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        // NO button
        builder.setNegativeButton(res.getText(R.string.confirm_exit_no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }
}
