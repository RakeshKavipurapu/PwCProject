package com.pwc.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pwc.test.entities.Order;
@Repository
//Using JPARepository interface we can perform simple crud 
//operations directly with predefined methods
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
