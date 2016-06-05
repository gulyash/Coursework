package com.example.gulnara.fairsplit.result;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.gulnara.fairsplit.R;
import com.example.gulnara.fairsplit.model.BillModel;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Gulnara on 05.06.2016.
 */
public class ResultAdapter extends BaseExpandableListAdapter {
    private Context mContext;

    public ResultAdapter (Context context){
        mContext = context;
    }

    @Override
    public int getGroupCount() {
        return BillModel.guestAmount;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return BillModel.getResult(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return BillModel.getResult(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return BillModel.getResult(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group_view_result, null);
        }

        if (isExpanded){
            //Изменяем что-нибудь, если текущая Group раскрыта
        }
        else{
            //Изменяем что-нибудь, если текущая Group скрыта
        }

        TextView guest = (TextView) convertView.findViewById(R.id.guest);
        guest.setText("Гость " + Integer.toString(groupPosition+1));
        TextView sum = (TextView) convertView.findViewById(R.id.sum);
        DecimalFormat df = new DecimalFormat("#.00");
        sum.setText(df.format(BillModel.guests.get(groupPosition+1).toPay) + " р.");

        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_view_result, null);
        }

        TextView dish = (TextView) convertView.findViewById(R.id.dish);
        dish.setText(BillModel.getResult(groupPosition).get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
