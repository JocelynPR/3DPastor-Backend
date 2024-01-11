package com.pokemonplace.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pokemonplace.app.entity.User;

import com.pokemonplace.app.service.UserService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/users")
@Log4j2
public class UserController{
	
	@Autowired
	UserService userService;
	
	@GetMapping("{id}")
	User getUserById(@PathVariable(name= "id") Long id) {
		log.info("Datos del Id " + id);
		User user = userService.getUserById(id);
		return user;
	}
	
	@PostMapping
	User setUser(@RequestBody User user){
		log.info("Creando usuario");
		log.info(user);
		User newUser = userService.createUser(user);
		return newUser;
	}
	
	@GetMapping("query")
	User getUserByEmail(@RequestParam(name= "email") String email) {
		return userService.getUserByEmail(email);
	}
	
	@PutMapping("{id}")
	User updateUser(@RequestBody User user, @PathVariable("id") Long id){
		return userService.updateUser(user, id);
	}
	
	@DeleteMapping("{id}")
	String deleteUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return "Se eliminó el usuario con el id= " +id;
	}
	
	
	
}
