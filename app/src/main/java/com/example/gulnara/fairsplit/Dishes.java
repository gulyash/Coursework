package com.example.gulnara.fairsplit;

import java.util.ArrayList;

/**
 * Created by Gulnara on 07.05.2016.
 */
public class Dishes {
    public static ArrayList<Dish> order=new ArrayList<Dish>();
    public static ArrayList<CheckDish> guestchoice = new ArrayList<CheckDish>();

    public static void addDishEveryWhere(String name, int amount, String price){
        order.add(new Dish(name, amount, price));
        for (int i=0; i<amount; i++) {
            guestchoice.add(new CheckDish(name,price, false));
        }

    }

}
