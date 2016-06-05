package com.example.gulnara.fairsplit.guestchoice;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gulnara.fairsplit.R;
import com.example.gulnara.fairsplit.model.BillModel;
import com.example.gulnara.fairsplit.result.ResultActivity;

public class GuestChoiceActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_choice);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mSectionsPagerAdapter.notifyDataSetChanged();

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //todo переход на четвертую активити
        FloatingActionButton goNext = (FloatingActionButton) findViewById(R.id.goNext);
        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (BillModel.allDishesArePicked()) {
                    BillModel.prepareResults();
                    startActivity(new Intent(getBaseContext(), ResultActivity.class));
                }
                else Toast.makeText(getBaseContext(),"Все блюда должны быть выбраны хотя бы одним гостем", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return GuestChoiceFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return BillModel.guestAmount;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                default:
                    return getString(R.string.guest_format, position);
            }
        }
    }
}
