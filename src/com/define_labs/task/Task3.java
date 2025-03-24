package com.define_labs.task;

public class Task3 {
    private String name;
    private double price;
    private Task2 taxGroup;

    public Task3(String name, double price, Task2 taxGroup) {
        this.name = name;
        this.price = price;
        this.taxGroup = taxGroup;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Task2 getTaxGroup() {
        return taxGroup;
    }

    public double calculateTax() {
        double totalTax = 0;
        for (Task1 tax : taxGroup.getTaxes()) {
            totalTax += price * (tax.getPercentage() / 100);
        }
        return totalTax;
    }

    public double getTotalPrice() {
        return price + calculateTax();
    }
}