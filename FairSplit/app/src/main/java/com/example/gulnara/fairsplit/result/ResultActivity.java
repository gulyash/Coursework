package com.example.gulnara.fairsplit.result;

import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.widget.ExpandableListView;

import com.example.gulnara.fairsplit.R;

public class ResultActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
        ResultAdapter resultAdapter = new ResultAdapter(this);
        expandableListView.setAdapter(resultAdapter);
    }
}
