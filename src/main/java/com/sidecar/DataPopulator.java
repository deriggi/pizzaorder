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
        // User admin = new User("admin", "admin password");
        // User normalUser = new User("user", "user password");
        // userRepository.save(admin, normalUser);

        Customer c= new Customer();
        c.setUsername("sidecar");
        c.setPassword(bcryptEncoder.encode("password"));
        c = customerDao.save(c);

        Topping anchovy = new Topping("anchovy");
        Set<Topping> toppings = new HashSet<Topping>();
        toppings.add(anchovy);
        toppingDao.save(toppings);

        Pizza p = new Pizza();
        p.setToppings(toppings);
        p = pizzaDao.save(p);
        
        Order o = new Order(c);
        o.addPizza(p);
        

        o = orderDao.save(o);
        System.out.println(o.getPizza().size() + " is the size");
        System.out.println(o.getPizza().iterator().next().getToppings().size() + " are the toppings on this"); 

    }
    
}