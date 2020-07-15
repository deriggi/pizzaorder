package com.sidecar.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pizza")
public class PizzaDao {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @OneToMany
    Set<ToppingDao> toppings;
    public Set<ToppingDao> getToppings(){
        return toppings;
    }

    public void setToppings(Set<ToppingDao> toppings){
        this.toppings = toppings;
    }

}