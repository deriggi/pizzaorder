package com.sidecar.controller.request;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrderRequest {

    private List<String> toppings = new ArrayList<>();
    private String username;
    
    public PizzaOrderRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    
    
}