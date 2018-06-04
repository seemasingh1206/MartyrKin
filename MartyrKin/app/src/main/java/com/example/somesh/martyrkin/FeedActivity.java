package com.example.somesh.martyrkin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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


public class FeedActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    MartyrAdapter adapter;
    List<String> dataList;
    TextView userView;

    ProgressDialog progressDialog;

    String user = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        Bundle bundle = getIntent().getExtras();
     //   user = bundle.getString("User");


        userView = (TextView) findViewById(R.id.user);

        if (user != "") {
            userView.setText("Welcome " + user);
        }
        progressDialog = new ProgressDialog(FeedActivity.this);
        progressDialog.setMessage("Downloading Data");
        progressDialog.show();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        ListView martyrListView = (ListView) findViewById(R.id.list);
        adapter = new MartyrAdapter(this, R.layout.martyr_list, new ArrayList<Martyr>());
        getData();
        martyrListView.setAdapter(adapter);


        martyrListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = ((TextView) view.findViewById(R.id.serviceNo)).getText().toString();

                clickListItem(selected);

            }
        });


    }

    private void clickListItem(String serviceNumber) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("KEY", serviceNumber);
        startActivity(intent);
    }


    public void getData() {
        dataList = new ArrayList<>();
        Log.e("TAG", "IN DATA");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref2;
        ref2 = ref.child("Martyr");
        ref2.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            Boolean status = dataList.add(String.valueOf(dsp.getValue()));
                            Log.e("TAG", "success");
                            if (!status)
                                Toast.makeText(getApplicationContext(), "Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                         String name;
                         Long mobile;
                         Integer serviceNo;
                         Integer dateofmartyred;
                         String galantoryawards;
                         Long accountnunber;
                         String ifsccode;
                         String bankname;

                        List<Martyr> listOfMartyr = new ArrayList<Martyr>();

                        for (String parse : dataList) {
                            try {
                                Log.e("TAG", "JSON PARSE"+parse);
                                JSONObject object = new JSONObject(parse);
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

                                Martyr local = new Martyr(name, mobile, serviceNo, dateofmartyred, galantoryawards, accountnunber,ifsccode,bankname);
                                listOfMartyr.add(local);

                            Log.e("DATA", local.toString());
                                onPostExecute(listOfMartyr);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                        Toast.makeText(getApplicationContext(), "Database Error", Toast.LENGTH_SHORT).show();

                    }
                });

    }


    public void onPostExecute(List<Martyr> result) {
        // Clear the adapter of previous data
        adapter.clear();
       Log.e("TAG", "POST");

        // If there is a valid list of {@link Places}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (result != null && !result.isEmpty()) {
            adapter.addAll(result);
        }
    }
}
