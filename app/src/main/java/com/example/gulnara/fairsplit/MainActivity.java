package com.example.gulnara.fairsplit;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.ListFragment;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    public FirstTabAdapter firstTabAdapter;
    public SecondTabAdapter secondTabAdapter;
    public static int mGuestAmount;

    private ViewPager mViewPager;
    //public ViewPager mSecondTabViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent guestNumIntent = new Intent(MainActivity.this, AskGuestsActivity.class);
        startActivityForResult(guestNumIntent, 1);
        super.onCreate(savedInstanceState);
        //activity is being constructed not here: see onActivityResult method below
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public ListFragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            switch (position) {
                //case 0: return new FirstTab();
                case 1: return new SecondTab();
                case 2: return new ThirdTab();
                default:
                    return new FirstTab();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Что";
                case 1:
                    return "Кто";
                case 2:
                    return "Сколько";
            }
            return null;
        }
    }


    public void addNewDish(String name, int amount, String price) {
        Dishes.order.add(new Dish(name, amount, price));
        for (int i=0; i<amount; i++) {
            Dishes.guestchoice.add(new CheckDish(name,price, false));
        }
        firstTabAdapter.notifyDataSetChanged();
        secondTabAdapter.notifyDataSetChanged();
    }

    DialogFragment adddishdlg;
    public void onAddButtonClick(View view) {
        adddishdlg.show(getFragmentManager(), "adddishdlg");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data==null) return;
        mGuestAmount = data.getIntExtra("num", 2);
        //todo перерисовать mainActivity
        setContentView(R.layout.activity_main);

        adddishdlg = new AddDishDialog();
        //TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        //mViewPager.setPagingEnabled(false);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


}

