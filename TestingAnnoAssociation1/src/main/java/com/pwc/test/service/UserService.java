package com.pwc.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwc.test.dao.IUserDAO;
import com.pwc.test.entities.User;
/*
 * for now we will use service layer only to transmit the data from controller
 * to the dao layer or transmit the data from dao to the controller
 */
@Service("userservice")
public class UserService implements IUserService {

	@Autowired
	// autowiring the dao reference variable
	private IUserDAO dao;

	
	@Override
	public void saveUserData(User user) {
		dao.saveUserData(user);

	}

	@Override
	public User getUserDataById(int id) {

		User user = dao.getUserDataById(id);
		return user;
	}

}
