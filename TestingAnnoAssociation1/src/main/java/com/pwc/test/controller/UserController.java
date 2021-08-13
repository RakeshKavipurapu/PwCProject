package com.pwc.test.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.pwc.test.entities.Order;
import com.pwc.test.entities.User;
import com.pwc.test.service.IUserService;
//Controller layer is useful to route the requests to specific endpoints that perform specific actions
@RestController
//Base endpoint for usercontroller to differentiate among several controllers
@RequestMapping("/user")
public class UserController {

	/*
	 * Autowired automatically picks up the required implementation class
	 * instantiates it and then assigns that object to the below ref variable
	 */
	@Autowired
	//autowiring the service reference variable
	private IUserService userservice;

	/*
	 * Postmapping is used when we want to send some data through the request body
	 */
	@PostMapping("/saveUserData")
	/*
	 * The @ResponseBody annotation tells a controller that the object returned is
	 * automatically serialized into JSON and passed back into the HttpResponse
	 * object.
	 */
	@ResponseBody
	public String saveData(@RequestBody String jsonData) throws JsonMappingException, JsonProcessingException {

		// for sample project we are using only Order and User table

		/*
		 * // populating the order table through order entity object List<Order>
		 * ordersList = Arrays.asList(new Order(true, "spring-book"), new Order(true,
		 * "java-book"));
		 * 
		 * // populating the user table through user entity object User user = new
		 * User("Ramesh", "Hyderabad", "ramesh1545@gmail.com", "rammish2345",
		 * ordersList);
		 */
		//To convert the jsondata to java object we need objectmapper
		ObjectMapper objectmapper=new ObjectMapper();
	    User user=	objectmapper.readValue(jsonData, User.class);
		
		// now the function call will be going to service layer
		userservice.saveUserData(user);
		// returning a simple status to the browser
		return "The data is Saved";
	}

	@GetMapping("/getUserDataById/{id}")
	@ResponseBody
	public User getUserDataById(@PathVariable String id) {
		User user = userservice.getUserDataById(Integer.parseInt(id));
		//returning the gathered user object to the browser or postman 
		return user;
	}

}
