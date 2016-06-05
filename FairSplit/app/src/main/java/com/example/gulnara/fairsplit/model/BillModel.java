package com.example.gulnara.fairsplit.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Gulnara on 29.05.2016.
 */
public class BillModel {
    //bill is a model of a check - just as it is brought to you by waiter
    public static ArrayList<DishModel> bill = new ArrayList<DishModel>();

    //This repeats every dish (bill.get(position)).amount times
    public static HashMap<Integer, GuestModel> guests = new HashMap<>();
    public static int guestAmount;


    //this inits needed quantity of guests with empty orders
    public static void initGuests(){
        for (int i=1; i<= guestAmount; i++){
            GuestModel guestModel = new GuestModel();
            guests.put(i,guestModel);
        }

    }

    public static void addDish(DishModel dish){
        //for the first tab
        bill.add(dish);
        //for the second tab and every guest
        for (int i=1; i<=guestAmount; i++) {
            GuestModel guest = guests.get(i);
            guest.addFromBill(dish);
            guests.put(i,guest);
        }
    }

    public static ArrayList<CheckedModel> getOrder(int i){
        return guests.get(i).order;
    }
    public static ArrayList<String> getResult(int i){
        return guests.get(i+1).result;
    }

    public static void prepareResults(){
        //for each guest
        for (int i=1; i<=guestAmount;i++){
            BillModel.guests.get(i).result.clear();
            for (CheckedModel line:getOrder(i)){
                //if he ordered a dish
                if (line.isChecked) {
                    //push it to results
                    BillModel.guests.get(i).result.add(line.name);
                }
            }
        }
    }

    public static void removeFromBill(int position){
        //проверяем заказы гостей
        //чиним суммы у всех гостей
        for (int i=1; i<=guestAmount;i++){
            //смотрим все доступные к заказу блюда
            for (int j=0; j<getOrder(i).size();j++){
                CheckedModel dish = getOrder(i).get(j);
                //проверяем все копии на совпадение с именем из первоначального чека
                if (dish.name==bill.get(position).name){
                    //вычитаем, поделив на число заказавших
                    int p=howManyPeopleOrderedThis(j);
                    if (dish.isChecked) BillModel.guests.get(i).toPay-=(dish.price/p);
                }
            }
        }
        //собственно стираем из заказов
        for (int i=1; i<=guestAmount;i++){
            //смотрим все доступные к заказу блюда
            for (int j=0; j<getOrder(i).size();j++){
                //проверяем все копии на совпадение с именем из первоначального чека
                CheckedModel dish = getOrder(i).get(j);
                if (dish.name==bill.get(position).name){
                    getOrder(i).remove(j);
                    j--;
                }
            }
        }
        bill.remove(position);

    }

    public static int howManyPeopleOrderedThis(int position){
        int g=0;
        for (int i=1; i<=guestAmount;i++){
            if(getOrder(i).get(position).isChecked)g++;
        }
        return g;
    }

    public static boolean allDishesArePicked(){

        for (int j=0; j<getOrder(1).size(); j++){
            boolean isPicked=false;

            for (int i=1; i<=guestAmount;i++){
                if(getOrder(i).get(j).isChecked) {
                    isPicked=true;
                    break;
                }
            }
            if (!isPicked){ return false;   }
        }
        return true;
    }

}
