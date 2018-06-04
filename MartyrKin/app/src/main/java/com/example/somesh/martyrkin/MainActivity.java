package com.example.somesh.martyrkin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    public void registerIntent(View view){
        Intent intent = new Intent(this, AdminLogin.class);
        startActivity(intent);
    }

    public void userIntent(View view){

        Intent intent = new Intent(this,UserActivity.class);
        startActivity(intent);
    }


}
