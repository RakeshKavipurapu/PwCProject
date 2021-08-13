package com.pwc.test.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pwc.test.entities.Order;
import com.pwc.test.entities.User;
import com.pwc.test.repositories.OrderRepository;
import com.pwc.test.repositories.UserRepository;
//This is the layer where we interact directly with the database
@Repository("userdao")
public class UserDAO implements IUserDAO{
	@Autowired
	private  UserRepository userrepo;
	@Autowired
	private OrderRepository orderrepo;
	//method for inserting user data to the database
	public void saveUserData(User user)
	{
		userrepo.save(user);
	
	}
	
	//method for getting the required user data by id
	public User getUserDataById( int id)
	{
		Optional<User> optionalUser=userrepo.findById(id);
	    User user=optionalUser.get();
	
          	return user;
	}
	
	
}
