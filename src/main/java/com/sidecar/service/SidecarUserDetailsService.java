package com.sidecar.service;

import java.util.ArrayList;

import com.sidecar.dao.CustomerDao;
import com.sidecar.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SidecarUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	

	public Customer loadCustomerByUsername(String username) throws UsernameNotFoundException {
		Customer customer = userDao.findByUsername(username);
		if (customer == null) {
			throw new UsernameNotFoundException("Customer does not exist with uname: " + username);
		}
		return customer;

	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = userDao.findByUsername(username);

		if (customer == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(customer.getUsername(), customer.getPassword(),
				new ArrayList<>());

		// if ("sidecar".equals(username)) {
		// 	return new User("sidecar", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
		// 			new ArrayList<>());
		// } else {
		// 	throw new UsernameNotFoundException("user not found");
		// }
	}

	public Customer save(Customer customer) {
		return userDao.save(customer);
	}
}