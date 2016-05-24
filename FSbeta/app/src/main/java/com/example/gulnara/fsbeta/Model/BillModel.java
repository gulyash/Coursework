package com.example.gulnara.fsbeta.Model;

import java.util.ArrayList;

/**
 * Created by Gulnara on 23.05.2016.
 */
public class BillModel {
    public static ArrayList<DishModel> bill=new ArrayList<DishModel>();
    //todo создать структуру данных для хранения выборов из n блюд для m пользователей
    //n - может изменяться в ходе программы
    // array[] - сколько человек ело конкретное блюдо
    //arraylist хранит заказы

    static{
        bill.add(new DishModel("food1", 2, "120"));
        bill.add(new DishModel("food2", 1, "100"));
        bill.add(new DishModel("food3", 1, "110"));
        bill.add(new DishModel("food4", 2, "130"));
        bill.add(new DishModel("food5", 1, "140"));
        bill.add(new DishModel("food6", 1, "20"));
        bill.add(new DishModel("food7", 1, "10"));
        bill.add(new DishModel("food8", 3, "1"));
        bill.add(new DishModel("food9", 3, "1"));
        bill.add(new DishModel("food10", 3, "1"));
        bill.add(new DishModel("food11", 3, "1"));
        bill.add(new DishModel("food12", 3, "1"));
        bill.add(new DishModel("food13", 3, "1"));
        bill.add(new DishModel("food14", 3, "1"));
        bill.add(new DishModel("food15", 3, "1"));
    }
    public static void addDishEveryWhere(String name, int amount, String price){
        bill.add(new DishModel(name, amount, price));
        //for (int i=0; i<amount; i++) {
            //guestchoice.add(new CheckedDishModel(name,price, false));
        //}
    }
    public static String BillSum(){
        double sum=0;
        for (DishModel dish:bill) {
            sum+=dish.price;
        }
        return Double.toString(sum);
    }
}
