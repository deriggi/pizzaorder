package com.sidecar;



import java.util.Set;

import javax.websocket.server.PathParam;

import com.sidecar.domain.Customer;
import com.sidecar.domain.Order;
import com.sidecar.security.JwtRequest;
import com.sidecar.security.JwtResponse;
import com.sidecar.security.JwtTool;
import com.sidecar.security.PizzaOrderService;
import com.sidecar.security.SidecarUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTool jwtTokenUtil;

	@Autowired
	private SidecarUserDetailsService userDetailsService;

	@Autowired
	private PizzaOrderService orderService;

	@RequestMapping(value = "/pizzaorders", method = RequestMethod.POST)
	public ResponseEntity<?> getPizzaOrders(@RequestParam String username) throws Exception {
		Set<Order> orders = orderService.findByCustomer(userDetailsService.loadCustomerByUsername(username));
        return ResponseEntity.ok(orders);
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

                final String token = jwtTokenUtil.generateToken(userDetails);

                return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}