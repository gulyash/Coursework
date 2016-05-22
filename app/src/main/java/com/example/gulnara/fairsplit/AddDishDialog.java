package com.example.gulnara.fairsplit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Gulnara on 07.05.2016.
 */
public class AddDishDialog extends DialogFragment implements View.OnClickListener {

    EditText dishName = null;
    EditText dishAmount = null;
    EditText dishPrice = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Новое блюдо:");

        //todo получать данные из полей

        View v = inflater.inflate(R.layout.add_button_dialog, null);
        //todo обнулять поля для ввода текста перед тем, как их выводить
        v.findViewById(R.id.accept).setOnClickListener(this);
        dishName = (EditText)v.findViewById(R.id.inputName);
        dishAmount = (EditText)v.findViewById(R.id.inputAmount);
        dishPrice = (EditText)v.findViewById(R.id.inputPrice);

        dishAmount.setText("1");

        return v;
    }

    public void onClick(View v) {
        //save dish
        ((MainActivity)getActivity()).addNewDish(dishName.getText().toString(),
                Integer.parseInt(dishAmount.getText().toString()), dishPrice.getText().toString());



        Toast toast = Toast.makeText(getActivity(),"Блюдо добавлено. " + dishName.getText().toString(), Toast.LENGTH_SHORT);
        toast.show();

        dishName.setText("");
        dishAmount.setText("1");
        dishPrice.setText("");

        dismiss();
    }


    public void onDismiss(DialogInterface dialog) {

        super.onDismiss(dialog);
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }
}
