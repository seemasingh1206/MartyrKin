package com.example.somesh.martyrkin;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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

public class DetailActivity extends AppCompatActivity {

    String value;
    TextView nameEditText;
    TextView mobileEditText;
    TextView unitEditText;
    TextView dateofmatyredEditText;
    TextView galantoryawardEditText;
    TextView accountnumberEditText;
    TextView ifscEditText;
    TextView banknameEditText;
    List<String> dataList;
    Integer serviceNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        nameEditText =(TextView) findViewById(R.id.txtname);
        mobileEditText=(TextView)findViewById(R.id.mobileno);
        unitEditText=(TextView)findViewById(R.id.unit);
        dateofmatyredEditText=(TextView)findViewById(R.id.dom);
        galantoryawardEditText=(TextView)findViewById(R.id.ga);
        accountnumberEditText=(TextView)findViewById(R.id.accountno);
        ifscEditText=(TextView)findViewById(R.id.ifsccode);
        banknameEditText=(TextView)findViewById(R.id.bankname);
        Bundle bundle = getIntent().getExtras();
        value = bundle.getString("KEY");
        //The key argument here must match that used in the other activity
        serviceNo = Integer.parseInt(value);

        getData();
    }


    public void populateView(String name, Long mobile, Integer serviceNo, Integer dateofmartyred,String galantoryawards,Long accountnumber,String ifsccode,String bankname){

        nameEditText.setText(name);
        mobileEditText.setText(mobile.toString());
       unitEditText.setText(serviceNo.toString());
        dateofmatyredEditText.setText(dateofmartyred.toString());
        accountnumberEditText.setText(accountnumber.toString());
        ifscEditText.setText(ifsccode.toString());
        banknameEditText.setText(bankname.toString());
    }


    public void backIntent(View view) {
        Intent intent = new Intent(this, HelpActivity.class);
        intent.putExtra("AccountNumber", accountnumberEditText.getText().toString().trim());
        intent.putExtra("BankName",banknameEditText.getText().toString());
        intent.putExtra("IFSC",ifscEditText.getText().toString());
        intent.putExtra("Name", nameEditText.getText()).toString();
        intent.putExtra("ServiceNumber", unitEditText.getText().toString());
        intent.putExtra("PhoneNo", mobileEditText.getText().toString());
        startActivity(intent);
    }

    public void getData() {
        dataList = new ArrayList<>();
        Log.e("TAG", "IN DATA 2");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref2;
        ref2 = ref.child("Martyr");
        DatabaseReference ref3;
        ref3 = ref2.child("ServiceNo" + serviceNo);
        ref3.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                         String name;
                         Long mobile;
                         Integer serviceNo;
                         Integer dateofmartyred;
                         String galantoryawards;
                         Long accountnunber;
                         String ifsccode;
                         String bankname;

                        String resultString = dataSnapshot.getValue().toString();

                        Log.e("Detail Activity", resultString);

                        try {
                            JSONObject object = new JSONObject(resultString);
                            name = object.getString("name");
                            Log.e("Name",name);
                            mobile = object.getLong("mobile");
                            serviceNo = object.getInt("serviceNo");
                            dateofmartyred = object.getInt("dateofmartyred");
                            galantoryawards = object.getString("galantoryawards");
                            accountnunber = object.getLong("accountnunber");
                            ifsccode=object.getString("ifsccode");
                            bankname=object.getString("bankname");
                            Log.e("DATA", name + mobile + serviceNo + dateofmartyred + galantoryawards + accountnunber+ifsccode+bankname);

                            populateView(name, mobile, serviceNo, dateofmartyred, galantoryawards, accountnunber,ifsccode,bankname);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                        Toast.makeText(getApplicationContext(), "Database Error", Toast.LENGTH_SHORT).show();
                    }
                });

    }


}

