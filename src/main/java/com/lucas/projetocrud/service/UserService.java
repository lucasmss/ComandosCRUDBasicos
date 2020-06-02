package com.lucas.projetocrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.projetocrud.domain.User;
import com.lucas.projetocrud.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		
		return repo.findAll();
		
	}
	
	public Optional<User> findById(String id) {
		
		Optional<User> user = repo.findById(id);
		
		return user;
	}

	
	public User add(User user) {
		
		return repo.save(user);
		
	}
	
	public User update(String id, User user) {
		
		findById(id);
		
		return repo.save(user);
	}
	
	public void delete(String id) {
	
		findById(id);
		
		repo.deleteById(id);
	}
	
}
