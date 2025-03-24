package com.define_labs.task;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    private List<Task3> products;

    public Task4() {
        products = new ArrayList<>();
    }

    public void addProduct(Task3 product) {
        products.add(product);
    }

    public Task3 findProductByName(String name) {
        for (Task3 product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null; 
    }


}