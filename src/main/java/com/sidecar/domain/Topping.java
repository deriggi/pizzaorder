package com.sidecar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topping")
public class Topping {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    
}