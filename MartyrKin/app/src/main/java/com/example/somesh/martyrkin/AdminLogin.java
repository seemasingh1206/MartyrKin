package com.example.somesh.martyrkin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AdminLogin extends AppCompatActivity {
    public static final String Username = "Mirage";
    public static final String Password = "Wolfpack";
    EditText editText;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        editText = (EditText) findViewById(R.id.usernameU);
        editText1 = (EditText) findViewById(R.id.passwordO);


    }

    public void check(View view) {
        Log.e("HU", editText.getText().toString());

        if (editText.getText().toString().equals(Username) && editText1.getText().toString().equals(Password)) {
            Log.e("HU", editText.getText().toString());
            Log.e("HU", editText1.getText().toString());
            Intent intent = new Intent(AdminLogin.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        }
    }


}
