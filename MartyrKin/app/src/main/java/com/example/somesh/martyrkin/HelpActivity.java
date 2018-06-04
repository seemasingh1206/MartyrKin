package com.example.somesh.martyrkin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HelpActivity extends AppCompatActivity {

    String name;
    Long accountNo;
    Integer ServiceNumber;
    Long mobile;
    String bankn;
    String IFSCm;

    TextView nameDetails;
    TextView MobileDetails;
    TextView ServiceDetails;
    TextView AccountDetails;
    TextView Bank;
    TextView IFCS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("Name");
        accountNo = Long.parseLong(bundle.getString("AccountNumber"));
        ServiceNumber = Integer.parseInt(bundle.getString("ServiceNumber"));
        mobile = Long.parseLong(bundle.getString("PhoneNo"));
        bankn=bundle.getString("BankName");
        IFSCm=bundle.getString("IFSC");




        nameDetails = (TextView) findViewById(R.id.nameDA);
        MobileDetails = (TextView) findViewById(R.id.phoneDA);
        ServiceDetails = (TextView) findViewById(R.id.serviceNoDA);
        AccountDetails = (TextView) findViewById(R.id.accountDA);
        Bank=(TextView)findViewById(R.id.bankDA);
        IFCS=(TextView)findViewById(R.id.ifscDA);

        nameDetails.setText("Name" + name);
        MobileDetails.setText("Mobile No" + mobile.toString());
        ServiceDetails.setText("Service No" + ServiceNumber.toString());
        AccountDetails.setText("Account No" + accountNo.toString());
        Bank.setText("Bank Name:"+bankn.toString());
        IFCS.setText("IFSC:"+IFSCm);

    }

    public void nextIntent(View view) {
        int id = view.getId();

        if (R.id.paytm == id) {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
            if (launchIntent != null) {
                startActivity(launchIntent);//null pointer check in case package name was not found
            } else
                Toast.makeText(getApplicationContext(), "Application Not Found", Toast.LENGTH_SHORT).show();
        }
        if (R.id.phonepe == id) {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.phonepe.app");
            if (launchIntent != null) {
                startActivity(launchIntent);//null pointer check in case package name was not found
            } else
                Toast.makeText(getApplicationContext(), "Application Not Found", Toast.LENGTH_SHORT).show();
        }
        if (R.id.bhim == id) {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("in.org.npci.upiapp");
            if (launchIntent != null) {
                startActivity(launchIntent);//null pointer check in case package name was not found
            } else
                Toast.makeText(getApplicationContext(), "Application Not Found", Toast.LENGTH_SHORT).show();
        }

    }


}
