package com.sidecar;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.sidecar.dao.CustomerDao;
import com.sidecar.dao.OrderDao;
import com.sidecar.dao.PizzaDao;
import com.sidecar.dao.ToppingDao;
import com.sidecar.domain.Customer;
import com.sidecar.domain.Order;
import com.sidecar.domain.Pizza;
import com.sidecar.domain.Topping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataPopulator {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PizzaDao pizzaDao;
    
    @Autowired
    private ToppingDao toppingDao;

    @Autowired
	private PasswordEncoder bcryptEncoder;
 
    @PostConstruct
    private void postConstruct() {

        Customer c= new Customer();
        c.setUsername("sidecar");
        c.setPassword(bcryptEncoder.encode("password"));
        c = customerDao.save(c);

        Set<Topping> toppings = new HashSet<Topping>();
        Topping pepperoni = new Topping("pepperoni");
        toppings.add(new Topping("artichoke"));
        toppings.add(pepperoni);
        toppings.add(new Topping("anchovy"));
        toppingDao.save(toppings);

        Pizza p = new Pizza();
        p.setToppings(toppings);
        pizzaDao.save(p);

        Pizza meatPizza = new Pizza();
        Set<Topping> meatToppings = new HashSet<Topping>();
        meatToppings.add(new Topping("sausage"));
        meatToppings.add(pepperoni);
        toppingDao.save(meatToppings);
        meatPizza.setToppings(meatToppings);
        pizzaDao.save(meatPizza);
        
        Order o = new Order(c);
        o.addPizza(p);
        o = orderDao.save(o);

    }
    
}