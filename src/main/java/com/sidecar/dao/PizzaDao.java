package com.sidecar.dao;

import java.util.Set;

import com.sidecar.domain.Pizza;

import org.springframework.data.repository.CrudRepository;

public interface PizzaDao extends CrudRepository<Pizza, Integer> {
    
}