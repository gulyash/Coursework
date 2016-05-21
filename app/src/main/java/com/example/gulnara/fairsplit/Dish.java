package com.example.gulnara.fairsplit;

/**
 * Created by Gulnara on 06.05.2016.
 */
public class Dish {
    public String name;
    public int amount;
    public double price;

    public Dish(String n, int a, String p) {
        this.name=n;
        this.amount=a;
        this.price = Double.parseDouble(p);
    }
    public Dish(String n, int a, double p) {
        this.name=n;
        this.amount=a;
        this.price = p;
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