package com.define_labs.task;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private String name;
    private List<Task1> taxes;

    public Task2(String name) {
        this.name = name;
        this.taxes = new ArrayList<>();
    }

    public void addTax(Task1 tax) {
        taxes.add(tax);
    }

    public List<Task1> getTaxes() {
        return taxes;
    }

    public String getName() {
        return name;
    }
}