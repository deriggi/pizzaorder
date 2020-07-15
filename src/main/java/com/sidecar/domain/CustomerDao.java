package com.sidecar.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class CustomerDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    @Column
    private String username;
    
    @Column
    private String email;
    
    @Column
	private String address;
    
    @Column
	@JsonIgnore
    private String password;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<OrderDao> orders;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
    }
    
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }



}