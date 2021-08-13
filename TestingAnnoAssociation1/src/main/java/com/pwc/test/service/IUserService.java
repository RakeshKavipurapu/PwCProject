package com.pwc.test.service;

import com.pwc.test.entities.User;
/*
Using the interfaces gives us softcoding so that if we add any new methods 
or remove any methods we will not interact directly with the classes*/

public interface IUserService {

	
	public void saveUserData(User user);
	public User getUserDataById( int id);
}
