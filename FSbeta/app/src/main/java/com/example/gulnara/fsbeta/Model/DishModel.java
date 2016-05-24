package com.example.gulnara.fsbeta.Model;

/**
 * Created by Gulnara on 23.05.2016.
 */
public class DishModel {
    public String name;
    public int amount;
    public double price;

    public DishModel(String n, int a, String p) {
        this.name=n;
        this.amount=a;
        this.price = Double.parseDouble(p);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return Integer.toString(amount);
    }

    public void setPrice(String price) {
        this.price = Double.parseDouble(price);
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getPrice() {
        return Double.toString(price);
    }
}
