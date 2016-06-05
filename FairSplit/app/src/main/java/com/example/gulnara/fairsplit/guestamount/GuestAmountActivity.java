package com.example.gulnara.fairsplit.guestamount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.gulnara.fairsplit.R;
import com.example.gulnara.fairsplit.fillbill.FillBillActivity;
import com.example.gulnara.fairsplit.model.BillModel;

public class GuestAmountActivity extends AppCompatActivity {

    NumberPicker np;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_amount);
        np=(NumberPicker)findViewById(R.id.guest_amount_picker);
        np.setMaxValue(10);
        np.setMinValue(2);
        np.setWrapSelectorWheel(false);
    }

    public void onAcceptGuestAmountClick(View view) {
        BillModel.guestAmount = np.getValue();
        BillModel.initGuests();
        startActivity(new Intent(this, FillBillActivity.class));
        Toast toast = Toast.makeText(getBaseContext(),"Заполните чек:",Toast.LENGTH_SHORT);
        toast.show();
    }
}
