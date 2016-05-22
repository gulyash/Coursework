package com.example.gulnara.fairsplit;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gulnara on 15.05.2016.
 */
public class SecondTabAdapter extends BaseAdapter {

    Context context;
    ArrayList<CheckDish> rowItem;

    SecondTabAdapter(Context context, ArrayList<CheckDish> rowItem) {
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
        View view=convertView;
        if (view == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.second_tab_box, null);
        }

        TextView txtDishName = (TextView) view.findViewById(R.id.dishName);
        //TextView txtAmount = (TextView) view.findViewById(R.id.dishAmount);
        TextView txtPrice = (TextView) view.findViewById(R.id.dishPrice);
        CheckBox cbBuy = (CheckBox) view.findViewById(R.id.checkBox);
        // присваиваем чекбоксу обработчик
        cbBuy.setOnCheckedChangeListener(myCheckChangList);
        // пишем позицию
        cbBuy.setTag(position);
        // заполняем данными из товаров: в корзине или нет


        CheckDish row_pos = rowItem.get(position);

        cbBuy.setChecked(row_pos.box);


        txtDishName.setText(row_pos.getName());
        txtPrice.setText(row_pos.getPrice());

        return view;
    }

    // обработчик для чекбоксов
    CompoundButton.OnCheckedChangeListener myCheckChangList = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            // меняем данные товара (в корзине или нет)
            Dishes.guestchoice.get((Integer) buttonView.getTag()).box = isChecked;
        }
    };
}
