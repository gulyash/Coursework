package com.example.gulnara.fairsplit;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gulnara on 20.05.2016.
 * Second tab viewflipper item - list for guests to choose ordered dishes
 */
public class SecondTabList  extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity)getActivity()).secondTabAdapter = new SecondTabAdapter(getActivity(), Dishes.guestchoice);
        getListView().setAdapter(((MainActivity)getActivity()).secondTabAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_tab_layout, null);
    }
}
