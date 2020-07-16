package com.sidecar.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "topping")
public class Topping {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "toppings")
    @JsonIgnore
    Set<Pizza> pizzas;

    public Topping(String name){
        this.name = name;
    }
    public Topping(){
    }

    public String getName(){
        return this.name;
    }

    public Set<Pizza> getPizzas(){
        return this.pizzas;
    }

    public void setPizzas(Set<Pizza> pizzas){
        this.pizzas = pizzas;
    }
    
}