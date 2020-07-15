package com.sidecar.dao;

import java.util.Set;

import com.sidecar.domain.Customer;
import com.sidecar.domain.Order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer> {
    Set<Order> findByCustomer(Customer customer);
}