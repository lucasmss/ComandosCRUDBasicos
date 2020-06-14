package com.lucas.projetocrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.projetocrud.model.User;
import com.lucas.projetocrud.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable String id){
		
		Optional<User> user = service.findById(id);
		
		return ResponseEntity.ok().body(user);
		
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		
		User users = service.add(user);
		
		return ResponseEntity.ok().body(users);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) {
		
		service.update(id, user);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deletUser(@PathVariable String id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
