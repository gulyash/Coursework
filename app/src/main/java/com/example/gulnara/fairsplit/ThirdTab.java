package com.example.gulnara.fairsplit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.ListFragment;
import android.widget.ViewFlipper;

/**
 * Created by Gulnara on 27.04.2016.
 */

public class ThirdTab extends ListFragment {
    ViewFlipper flipper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second_tab,
                container, false);

        // Получаем объект ViewFlipper
        flipper = (ViewFlipper)v.findViewById(R.id.viewFlipper);
        // Создаем View и добавляем их в уже готовый flipper
        //LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int pages = (((MainActivity)getActivity()).mGuestAmount);
        int layouts[] = new int[pages];
        layouts[0]=R.layout.dummy;
        for (int i = 1; i < pages; i++ ) {
            layouts[i] = R.layout.second_tab_guest;
        }
        for (int i=0; i<pages;i++) {
            flipper.addView(inflater.inflate(layouts[i], null));
        }

        Button prev = (Button)v.findViewById(R.id.prevButton);
        Button next = (Button)v.findViewById(R.id.nextButton);
        prev.setOnClickListener(mOnClickListener);
        next.setOnClickListener(mOnClickListener);
        return v;
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener(){
        public void onClick(View v){
            switch (v.getId()){
                case R.id.nextButton : flipper.showNext(); break;
                case R.id.prevButton : flipper.showPrevious(); break;
            }
        }
    };

}