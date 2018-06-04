package com.example.somesh.martyrkin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText nameEditText;
    EditText mobileEditText;
    EditText unitEditText;
    EditText dateofmatyredEditText;
    EditText galantoryawardEditText;
    EditText accountnumberEditText;
    EditText ifscEditText;
    EditText banknameEditText;
    FirebaseDatabase database;
    DatabaseReference myRef;
    String TAG = "AI";

    List<String> martyrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText =(EditText)findViewById(R.id.txtname);
        mobileEditText=(EditText)findViewById(R.id.mobileno);
        unitEditText=(EditText)findViewById(R.id.unit);
        dateofmatyredEditText=(EditText)findViewById(R.id.dom);
        galantoryawardEditText=(EditText)findViewById(R.id.ga);
        accountnumberEditText=(EditText)findViewById(R.id.accountno);
        ifscEditText=(EditText)findViewById(R.id.ifsccode);
        banknameEditText=(EditText)findViewById(R.id.bankname);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

    }


    public void AddData(String name, Long mobile, int serviceNo, Integer dateofmartyred,String galantoryawards,Long accountnumber,String ifsccode,String bankname){

        Martyr martyr = new Martyr(name, mobile, serviceNo, dateofmartyred, galantoryawards, accountnumber,ifsccode,bankname);

        myRef.child("Martyr").child("ServiceNo" + serviceNo).setValue(martyr);

    }


    public void getResultFromEditText(){

        String name = nameEditText.getText().toString();
        Long mobile= Long.parseLong(mobileEditText.getText().toString());
        Integer serviceNo= Integer.parseInt(unitEditText.getText().toString());
        Integer dateofmartyred= Integer.parseInt(dateofmatyredEditText.getText().toString());
        String galantoryawards=galantoryawardEditText.getText().toString();
        Long accountnumber=Long.parseLong(accountnumberEditText.getText().toString());
        String ifsccode=ifscEditText.getText().toString();
        String bankname=banknameEditText.getText().toString();
        AddData(name,mobile,serviceNo,dateofmartyred,galantoryawards,accountnumber,ifsccode,bankname);

    }

    public void AccountActivity(View view){
        getResultFromEditText();
        Intent intent = new Intent(this,AccountActivity.class);
        startActivity(intent);
        finish();

    }


}

