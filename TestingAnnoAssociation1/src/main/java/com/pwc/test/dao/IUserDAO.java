package com.pwc.test.dao;

import com.pwc.test.entities.User;
/*
Using the interfaces gives us softcoding so that if we add any new methods 
or remove any methods we will not interact directly with the classes*/

public interface IUserDAO {

	public void saveUserData(User user);
	public User getUserDataById( int id);
}
