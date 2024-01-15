package com.pokemonplace.app.controller;

import java.util.List;

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
	
	// Modifications 1
	@GetMapping
	List<User> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return users;
	}
	
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
	
	// Modifications 1
	// Para verificarlo en Postman, elegir PUT y la siguiente ruta
	// http://localhost:8080/api/v1/users/{id}/deactivate

	@PutMapping("{id}/deactivate")
	String deactivateUser(@PathVariable("id") Long id) {
		userService.deactivateUser(id);
		return "Se desactivó el usuario con el id= " +id;
	}

}
