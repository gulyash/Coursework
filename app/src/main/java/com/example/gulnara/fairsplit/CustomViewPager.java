package com.example.gulnara.fairsplit;

import android.content.Context;

import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Gulnara on 17.05.2016.
 */
public class CustomViewPager extends android.support.v4.view.ViewPager {
    //private boolean enabled;

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context,attrs);
        //this.enabled=true;
    }

    public CustomViewPager(Context context) {
        super(context);
        //this.enabled=true;
    }
/*
    @Override
    public boolean onTouchEvent(MotionEvent event){
        return enabled?super.onTouchEvent(event):false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return enabled?super.onInterceptTouchEvent(event):false;
    }

    public void setPagingEnabled(boolean enabled) {
        this.enabled=enabled;
    }
    public boolean isPagingEnabled() {
        return enabled;
    }*/
}
