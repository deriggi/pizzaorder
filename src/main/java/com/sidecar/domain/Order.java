package com.sidecar.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "delivery_order")
public class Order {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    public Order(){

    }
    public Order(Customer c){
        customer = c;
        createdAt = new Date();
    }
    


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Pizza> pizza;

    public Set<Pizza> getPizza(){
        return pizza;
    }
    public void setPizza(Set<Pizza> pizza){
        this.pizza = pizza;
    }

    public void addPizza(Pizza p){
        if(pizza == null){
            pizza = new HashSet<>();
        }
        pizza.add(p);
    }

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Date getCreatedAt(){
        return createdAt;
    }


}