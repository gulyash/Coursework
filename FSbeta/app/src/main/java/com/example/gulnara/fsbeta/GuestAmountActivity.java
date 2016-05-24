package com.example.gulnara.fsbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

public class GuestAmountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_amount);

        NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker1);
        np.setMaxValue(20);
        np.setMinValue(2);
        np.setWrapSelectorWheel(false);
    }

    public void acceptGuestAmount(View view) {
        Intent intent = new Intent();
        NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker1);
        int guestAmount = np.getValue();
        intent.putExtra("num",guestAmount);
        setResult(RESULT_OK,intent);
        finish();
    }
}
