package com.sidecar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sidecar.controller.request.PizzaOrderRequest;
import com.sidecar.dao.OrderDao;
import com.sidecar.dao.PizzaDao;
import com.sidecar.dao.ToppingDao;
import com.sidecar.domain.Customer;
import com.sidecar.domain.Order;
import com.sidecar.domain.Pizza;
import com.sidecar.domain.Topping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PizzaOrderService{

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PizzaDao pizzaDao;

    @Autowired
    private ToppingDao toppingDao;

    public Set<Order> findByCustomer(Customer customer){
        return orderDao.findByCustomer(customer);
    }

    public Pizza processOrderRequest(PizzaOrderRequest request){
        Pizza p = new Pizza();
        List<String> toppings = request.getToppings();
        Set<Topping> toppingsToSave = new HashSet<>();

        for(String t : toppings){
            Topping foundT = toppingDao.findByName(t);
            if(foundT != null){
                toppingsToSave.add(foundT);                
            }
        }
        if( !toppingsToSave.isEmpty() ){
            p.setToppings(toppingsToSave);
        }
        
        return pizzaDao.save(p);
    }

}