package com.example.gulnara.fsbeta.FirstTab;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gulnara.fsbeta.MainActivity;
import com.example.gulnara.fsbeta.Model.BillModel;
import com.example.gulnara.fsbeta.R;


public class FirstTabFragment extends ListFragment {

    public static FirstTabFragment newInstance() {
        FirstTabFragment fragment = new FirstTabFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity)getActivity()).firstTabListAdapter = new FirstTabListAdapter(getActivity(), BillModel.bill);
        getListView().setAdapter(((MainActivity)getActivity()).firstTabListAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_first_tab, null);
        showNewSum(v);
        return v;
    }

    public static void showNewSum(View v){
        TextView txtFirstTabSum = (TextView)v.findViewById(R.id.firstTabSum);
        String sum = BillModel.BillSum();
        txtFirstTabSum.setText("Сумма по чеку: " + sum);
    }
}
