package com.example.gulnara.fairsplit.guestchoice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gulnara.fairsplit.R;
import com.example.gulnara.fairsplit.model.BillModel;
import com.example.gulnara.fairsplit.model.CheckedModel;
import com.example.gulnara.fairsplit.model.DishModel;
import com.example.gulnara.fairsplit.model.GuestModel;

import java.util.ArrayList;

/**
 * Created by Gulnara on 29.05.2016.
 */
public class GuestChoiceListAdapter extends BaseAdapter {
    ArrayList<CheckedModel>order;
    LayoutInflater layoutInflater;
    int guestNum;

    GuestChoiceListAdapter(Context context, int num){
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        guestNum=num;
        order = BillModel.getOrder(guestNum);
    }

    @Override
    public int getCount() {
        return (BillModel.guests.get(guestNum)).order.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return order.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.guest_choice_row_item, parent, false);
        }

        CheckedModel dish = order.get(position);

        ((TextView) view.findViewById(R.id.dish_gc)).setText(dish.name + ", " + dish.price + "р.");
        CheckBox cb = (CheckBox) view.findViewById(R.id.checkBox);

        //here goes a big and horrible onClickListener. I'm not proud of it, hope I will
        // todo fix it someday, it makes my eyes bleed

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox)v).isChecked()){ //галочку поставили
                    (BillModel.getOrder(guestNum)).get(position).isChecked = true;

                    //посчитать количество гостей, заказывавших отмеченное блюдо
                    int denum = BillModel.howManyPeopleOrderedThis(position);

                    for(int i=1; i<=BillModel.guestAmount;i++){
                        //если гость заказывал это блюдо
                        if ((BillModel.getOrder(i)).get(position).isChecked){
                            //отметившему гостю - просто прибавить, а всем остальным - пересчитать с учетом всех гостей
                            if (i==guestNum){
                                BillModel.guests.get(i).toPay+=(double) ((BillModel.getOrder(i)).get(position).price)/denum;
                            }
                            else{
                                BillModel.guests.get(i).toPay-=(double) ((BillModel.getOrder(i)).get(position).price)/(denum-1);
                                BillModel.guests.get(i).toPay+=(double) ((BillModel.getOrder(i)).get(position).price)/denum;
                            }
                        }
                    }
                }
                else{ //галочку убрали
                    (BillModel.getOrder(guestNum)).get(position).isChecked = false;

                    //посчитать количество гостей, заказывавших отмеченное блюдо
                    int denum = BillModel.howManyPeopleOrderedThis(position);

                    BillModel.guests.get(guestNum).toPay-=(double) ((BillModel.getOrder(guestNum)).get(position).price)/(denum+1);

                    for(int i=1; i<=BillModel.guestAmount;i++){
                        //если гость заказывал это блюдо
                        if ((BillModel.getOrder(i)).get(position).isChecked){
                            BillModel.guests.get(i).toPay-=(double) ((BillModel.getOrder(i)).get(position).price)/(denum+1);
                            BillModel.guests.get(i).toPay+=(double) ((BillModel.getOrder(i)).get(position).price)/denum;
                        }
                    }
                }
            }
        });

        cb.setChecked(dish.isChecked);

        //todo make a beautiful checkbox someday
        return view;
    }
}
