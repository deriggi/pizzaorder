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
public class Pizza {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @OneToMany
    Set<Topping> toppings;
    public Set<Topping> getToppings(){
        return toppings;
    }

    public void setToppings(Set<Topping> toppings){
        this.toppings = toppings;
    }

}