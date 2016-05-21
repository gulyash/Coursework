package com.example.gulnara.fairsplit;

import java.util.ArrayList;

/**
 * Created by Gulnara on 07.05.2016.
 */
public class Dishes {
    public static ArrayList<Dish> order=new ArrayList<Dish>();
    public static ArrayList<CheckDish> guestchoice = new ArrayList<CheckDish>();
    public static double[] GuestPayables=new double[5];
    public int getByPosition(){return 3;}
}
