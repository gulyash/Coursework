package com.example.gulnara.fairsplit.fillbill;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gulnara.fairsplit.R;
import com.example.gulnara.fairsplit.guestchoice.GuestChoiceActivity;
import com.example.gulnara.fairsplit.model.BillModel;

public class FillBillActivity extends AppCompatActivity {
    DialogFragment dialogFragment;
    public FillBillAdapter fillBillAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_bill);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //todo проверить, как работает адаптер, в который не передали данных
        //todo проверить, чтобы надпись о пустом списке не выводиласб при существующем списке
        fillBillAdapter = new FillBillAdapter(this, BillModel.bill);
        ListView billList = (ListView)findViewById(R.id.billList);
        billList.setAdapter(fillBillAdapter);

        billList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(FillBillActivity.this);
                adb.setTitle("Удалить?");
                adb.setMessage("Позиция " + (position+1) + " будет удалена");
                final int positionToRemove = position;
                adb.setNegativeButton("Отменить", null);
                adb.setPositiveButton("Удалить", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        BillModel.removeFromBill(positionToRemove);
                        fillBillAdapter.notifyDataSetChanged();
                    }});
                adb.show();
            }
        });

        dialogFragment = new NewDishDialogFragment();

        FloatingActionButton goNext = (FloatingActionButton) findViewById(R.id.goNext);
        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Используйте жесты для навигации между пользователями", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getBaseContext(), GuestChoiceActivity.class));
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogFragment.show(getSupportFragmentManager(),"newDishDlg");
            }
        });
    }

    public void refresh(){
        fillBillAdapter.notifyDataSetChanged();
    }



}
