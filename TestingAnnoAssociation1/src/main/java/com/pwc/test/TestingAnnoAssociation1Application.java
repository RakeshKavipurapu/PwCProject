package com.pwc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.pwc.test.dao.UserDAO;
import com.pwc.test.repositories.OrderRepository;
import com.pwc.test.repositories.UserRepository;

@SpringBootApplication
/*ComponentScan specifies the spring container from which packages 
 * it should pick up the required class for instantiation
   */
@ComponentScan(basePackages = "com.pwc")
public class TestingAnnoAssociation1Application {

	
	public static void main(String[] args) {
	SpringApplication.run(TestingAnnoAssociation1Application.class, args);
		
	}

}
