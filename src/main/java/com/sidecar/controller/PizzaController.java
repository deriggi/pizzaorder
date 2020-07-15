package com.sidecar.controller;

import java.util.Set;

import com.sidecar.domain.Order;
import com.sidecar.service.PizzaOrderService;
import com.sidecar.service.SidecarUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PizzaController {

    @Autowired
    private PizzaOrderService orderService;
    
    @Autowired
	private SidecarUserDetailsService userDetailsService;

    @RequestMapping(value = "/pizzaorders", method = RequestMethod.GET)
	public ResponseEntity<?> getPizzaOrders(@RequestParam String username) throws Exception {
		Set<Order> orders = orderService.findByCustomer(userDetailsService.loadCustomerByUsername(username));
        return ResponseEntity.ok(orders);
	}
    
}