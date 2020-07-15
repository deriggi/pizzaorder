package com.sidecar.security;

import java.util.Set;

import com.sidecar.dao.OrderDao;
import com.sidecar.domain.Customer;
import com.sidecar.domain.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PizzaOrderService{

    @Autowired
    private OrderDao orderDao;

    public Set<Order> findByCustomer(Customer customer){
        return orderDao.findByCustomer(customer);
    }

}