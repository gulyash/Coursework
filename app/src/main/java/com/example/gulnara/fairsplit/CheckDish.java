package com.example.gulnara.fairsplit;

/**
 * Created by Gulnara on 16.05.2016.
 */
public class CheckDish {
    String name;
    double price;
    boolean box;

    CheckDish(String _name, String _price, boolean _box) {
        name=_name;
        price=Double.parseDouble(_price);
        box=_box;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {return Double.toString(price);}
}
