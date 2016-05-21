package com.example.gulnara.fairsplit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.support.v4.app.ListFragment;
import android.widget.Toast;
import android.widget.ViewFlipper;

/**
 * Created by Gulnara on 27.04.2016.
 */

public class ThirdTab extends ListFragment{
    String[] month ={
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    public ViewFlipper viewFlipper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListAdapter myListAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_multiple_choice,month);

        setListAdapter(myListAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.third_tab_layout, container, false);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        String prompt =
                "clicked item: " + getListView().getItemAtPosition(position).toString() + "\n\n";

        prompt += "selected items: \n";
        int count = getListView().getCount();
        SparseBooleanArray sparseBooleanArray = getListView().getCheckedItemPositions();
        for (int i = 0; i < count; i++){
            if (sparseBooleanArray.get(i)) {
                prompt += getListView().getItemAtPosition(i).toString() + "\n";
            }
        }

        Toast.makeText(
                getActivity(),
                prompt,
                Toast.LENGTH_LONG).show();
    }

}