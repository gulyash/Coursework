package com.example.gulnara.fsbeta;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gulnara.fsbeta.FirstTab.FirstTabFragment;

/**
 * Created by Gulnara on 23.05.2016.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            default: return FirstTabFragment.newInstance();
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
                return "КТО";
            case 1:
                return "ЧТО";
            case 2:
                return "СКОЛЬКО";
        }
        return null;
    }
}