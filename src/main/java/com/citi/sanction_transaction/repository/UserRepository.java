package com.citi.sanction_transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citi.sanction_transaction.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsernameAndPassword(final String username, final String password); 
}