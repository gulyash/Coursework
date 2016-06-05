package com.example.gulnara.fairsplit.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Gulnara on 04.06.2016.
 */
public class GuestModel {
    public double toPay;
    public ArrayList<CheckedModel> order ;
    public ArrayList<String> result;

    GuestModel(){
        toPay=0;
        order = new ArrayList<>();
        result = new ArrayList<>();
    }

    public void addFromBill(DishModel dish){
        for (int i=0; i< dish.amount; i++) {
            order.add(new CheckedModel(dish));
        }
    }

}
