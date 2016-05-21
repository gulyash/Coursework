package com.example.gulnara.fairsplit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AskGuestsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_guests);
        EditText guestNum = (EditText) findViewById(R.id.inputGuestNum);
        guestNum.setText("2");
    }

    public void onAcceptGuestsClick(View view) {
        Intent intent = new Intent();
        EditText guestNum = (EditText) findViewById(R.id.inputGuestNum);
        int guestAmount = Integer.parseInt(guestNum.getText().toString());
        intent.putExtra("num",guestAmount);
        setResult(RESULT_OK,intent);
        finish();
    }
}
