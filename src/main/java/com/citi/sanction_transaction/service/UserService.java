package com.citi.sanction_transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.sanction_transaction.model.User;
import com.citi.sanction_transaction.repository.UserRepository;

@Service
public class UserService {

@Autowired
private UserRepository repo;

	public User login(String username, String password) {
		User user = repo.findByUsernameAndPassword(username, password);
		return user;
	}
}
