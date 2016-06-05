package com.example.gulnara.fairsplit.model;

/**
 * Created by Gulnara on 30.05.2016.
 */
public class CheckedModel {
    public String name;
    public double price;
    public boolean isChecked;

    public CheckedModel(DishModel dish) {
        name= dish.name;
        price = dish.price;
    }
}
