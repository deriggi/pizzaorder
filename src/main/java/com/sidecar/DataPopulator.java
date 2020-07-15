package com.sidecar;

import javax.annotation.PostConstruct;

import com.sidecar.dao.CustomerDao;
import com.sidecar.dao.OrderDao;
import com.sidecar.domain.Customer;
import com.sidecar.domain.Order;

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

        Order o = new Order(c);
        orderDao.save(o);


    }
    
}