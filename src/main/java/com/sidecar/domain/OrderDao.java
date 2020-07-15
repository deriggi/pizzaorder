package com.sidecar.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "delivery_order")
public class OrderDao {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerDao customer;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Date getCreatedAt(){
        return createdAt;
    }


}