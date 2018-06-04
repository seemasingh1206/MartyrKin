package com.example.somesh.martyrkin;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Somesh on 5/22/2017.
 */

public class MartyrAdapter extends ArrayAdapter<Martyr> {


    ArrayList<Martyr> martyrList = new ArrayList<>();

    public MartyrAdapter(Context context, int resource, ArrayList<Martyr> martyrList) {
        super(context, resource,martyrList);
        this.martyrList = martyrList;
    }



    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.martyr_list, parent, false);

        }

        Martyr currentMartyr = getItem(position);


        TextView MartyrName = (TextView) convertView.findViewById(R.id.Martyr_Name);
        MartyrName.setText(currentMartyr.getName());


        TextView MobileNo = (TextView) convertView.findViewById(R.id.serviceNo);
       MobileNo.setText(currentMartyr.getServiceNo().toString());

        return convertView;


    }


}
