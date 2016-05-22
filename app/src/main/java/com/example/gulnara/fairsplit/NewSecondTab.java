package com.example.gulnara.fairsplit;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gulnara on 22.05.2016.
 */
public class NewSecondTab extends Fragment {
    static final String TAG = "myLogs";
    static int PAGE_COUNT=2;
    static SecondTabPagerAdapter[] adapters=new SecondTabPagerAdapter[PAGE_COUNT];

    ViewPager pager;
    SecondTabPagerAdapter pagerAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PAGE_COUNT = ((MainActivity)getActivity()).mGuestAmount;
        pager = (ViewPager)getView().findViewById(R.id.secondTabViewPager);
        pagerAdapter = new SecondTabPagerAdapter(getFragmentManager());
        pager.setAdapter(pagerAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.new_second_tab_layout, null);
    }

    public static class SecondTabPagerAdapter extends FragmentPagerAdapter {

        SecondTabAdapter[] adapters=new SecondTabAdapter[PAGE_COUNT];

        public SecondTabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            switch (position) {
                //case 0: return new FirstTab();
                default: return new SecondTab();
            }
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                default:
                    return "Гость " + (position + 1);
            }
        }
    }


    public void refresh(){
        for(int i=0; i<PAGE_COUNT;i++) {

        }
    };


}