package com.example.gulnara.fairsplit;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gulnara on 06.05.2016.
 */
public class FirstTabAdapter extends BaseAdapter {
    Context context;
    ArrayList<Dish> rowItem;

    FirstTabAdapter(Context context, ArrayList<Dish> rowItem) {
        this.context = context;
        this.rowItem = rowItem;
    }

    @Override
    public int getCount() {
        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.first_tab_box, null);
        }

        TextView txtDishName = (TextView) convertView.findViewById(R.id.dishName);
        TextView txtAmount = (TextView) convertView.findViewById(R.id.dishAmount);
        TextView txtPrice = (TextView) convertView.findViewById(R.id.dishPrice);

        Dish row_pos = rowItem.get(position);

        txtDishName.setText(row_pos.getName());
        txtAmount.setText(row_pos.getAmount());
        txtPrice.setText(row_pos.getPrice());



        return convertView;
    }
}

