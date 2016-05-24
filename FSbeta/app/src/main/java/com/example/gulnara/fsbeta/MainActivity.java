package com.example.gulnara.fsbeta;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.example.gulnara.fsbeta.FirstTab.NewDishDialog;
import com.example.gulnara.fsbeta.Model.BillModel;

//работает ввод количества гостей

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    public static int mGuestAmount;
    DialogFragment addDishDlg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //запустить активити, в котором спрашиваем количество гостей
        Intent guestNumIntent = new Intent(MainActivity.this, GuestAmountActivity.class);
        startActivityForResult(guestNumIntent, 1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addDishDlg = new NewDishDialog();
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //это viewpager для вкладок
        //todo мб перегрузить его, чтобы не свайпил, но и не крашил приложение
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //собственно вкладки
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    //из активити на старте получаем количество гостей
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data==null) return;
        mGuestAmount = data.getIntExtra("num", 2);
    }

    //вызов диалогового окна для ввода нового блюда из чека
    public void onAddButtonClick(View view) {
        addDishDlg.show(getFragmentManager(), "addDishDlg");
    }


    //когда в диалоге ввели блюдо и нажали "ОК"
    public void addNewDish(String name, int amount, String price) {
        BillModel.addDishEveryWhere(name, amount, price);
        //firstTabListAdapter.notifyDataSetChanged();

    }




}
