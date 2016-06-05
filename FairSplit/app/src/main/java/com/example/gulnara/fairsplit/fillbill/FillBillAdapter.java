package com.example.gulnara.fairsplit.fillbill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gulnara.fairsplit.R;
import com.example.gulnara.fairsplit.model.BillModel;
import com.example.gulnara.fairsplit.model.DishModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Gulnara on 29.05.2016.
 */
public class FillBillAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    ArrayList<DishModel> bill;

    FillBillAdapter(Context context, ArrayList<DishModel> b){
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        bill = b;
    }


    @Override
    public int getCount() {
        return BillModel.bill.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return BillModel.bill.get(position);
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.fill_bill_row_item, parent, false);
        }

        DishModel dish = bill.get(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.dish_name)).setText(dish.name);
        ((TextView) view.findViewById(R.id.dish_price)).setText(dish.price + " р.");
        ((TextView) view.findViewById(R.id.dish_amount)).setText("x" + dish.amount);


        return view;
    }



}
