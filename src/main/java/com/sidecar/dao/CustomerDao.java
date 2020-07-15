package com.sidecar.dao;


import com.sidecar.domain.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

    Customer findByUsername(String username);
    

}