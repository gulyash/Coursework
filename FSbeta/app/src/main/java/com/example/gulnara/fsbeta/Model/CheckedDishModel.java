package com.example.gulnara.fsbeta.Model;

/**
 * Created by Gulnara on 23.05.2016.
 * Класс для отображения пункта списка во второй вкладке.
 * Итерируя по DishModel.amount , выводим в каждый список второй вкладки нужное количество раз
 */
public class CheckedDishModel {
    String name;
    double price;
    boolean box; //для хранения значения чекбокса

    CheckedDishModel(String _name, String _price, boolean _box) {
        name=_name;
        price=Double.parseDouble(_price);
        box=_box;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {return Double.toString(price);}
}
