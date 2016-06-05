package com.example.gulnara.fairsplit.fillbill;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.gulnara.fairsplit.R;
import com.example.gulnara.fairsplit.model.BillModel;
import com.example.gulnara.fairsplit.model.CheckedModel;
import com.example.gulnara.fairsplit.model.DishModel;

/**
 * Created by Gulnara on 29.05.2016.
 */
public class NewDishDialogFragment extends DialogFragment {
    NumberPicker np;
    EditText editName;
    EditText editPrice;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View v = inflater.inflate(R.layout.new_dish_dialog, null);

        editName = (EditText)v.findViewById(R.id.dish_name_edit);
        editName.setText(getString(R.string.food_format, (BillModel.bill.size()+1)));
        editPrice = (EditText)v.findViewById(R.id.dish_price_edit);

        np=(NumberPicker)v.findViewById(R.id.dish_amount_picker);
        np.setMaxValue(10);
        np.setMinValue(1);
        np.setWrapSelectorWheel(false);

        builder.setTitle("Новое блюдо:");
        builder.setView(v)
                // Add action buttons
                .setPositiveButton(R.string.add_dish, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        try{
                            String name = editName.getText().toString();
                            int amount = np.getValue();
                            int price = Integer.parseInt(editPrice.getText().toString());

                            BillModel.addDish(new DishModel(name,amount,price));
                            ((FillBillActivity)getActivity()).refresh();
                        }
                        catch (NumberFormatException e){
                            Toast.makeText(getContext(),"Не все поля заполнены", Toast.LENGTH_SHORT).show();
                        }


                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        NewDishDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.new_dish_dialog, null);
        return v;
    }
}
