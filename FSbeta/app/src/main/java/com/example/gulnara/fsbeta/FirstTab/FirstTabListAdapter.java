package com.example.gulnara.fsbeta.FirstTab;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.gulnara.fsbeta.Model.DishModel;
import com.example.gulnara.fsbeta.R;

import java.util.ArrayList;

/**
 * Created by Gulnara on 23.05.2016.
 */
public class FirstTabListAdapter extends BaseAdapter {
    Context context;
    ArrayList<DishModel> rowItem;

    FirstTabListAdapter(Context context, ArrayList<DishModel> rowItem) {
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
            convertView = mInflater.inflate(R.layout.first_tab_list_row, null);
        }

        TextView txtDishName = (TextView) convertView.findViewById(R.id.dishName);
        TextView txtAmount = (TextView) convertView.findViewById(R.id.dishAmount);
        TextView txtPrice = (TextView) convertView.findViewById(R.id.dishPrice);

        DishModel row_pos = rowItem.get(position);

        txtDishName.setText(row_pos.getName());
        txtAmount.setText(row_pos.getAmount());
        txtPrice.setText(row_pos.getPrice());

        return convertView;
    }
}