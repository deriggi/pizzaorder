package com.sidecar.dao;

import com.sidecar.domain.Topping;

import org.springframework.data.repository.CrudRepository;

public interface ToppingDao extends CrudRepository<Topping, Integer> {
    Topping findByName(String name);
}