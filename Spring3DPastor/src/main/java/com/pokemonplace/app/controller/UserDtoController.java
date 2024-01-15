package com.pokemonplace.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pokemonplace.app.entity.User;
import com.pokemonplace.app.dto.UserDto;
import com.pokemonplace.app.service.UserDtoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v2/users")
public class UserDtoController {
	
	@Autowired
	UserDtoService userDtoService;
	
	@GetMapping("{id}")
	ResponseEntity<UserDto> getUserById(@PathVariable(name="id") Long id){
		UserDto userDto = userDtoService.getUserById(id);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	@GetMapping
	ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> usersDto = userDtoService.getAllUsers();
		return new ResponseEntity<>(usersDto, HttpStatus.OK);
	}
	@PostMapping
	ResponseEntity<UserDto> setUser(@RequestBody User user) {
		UserDto newUserDto = userDtoService.createUser(user);
		return new ResponseEntity<>(newUserDto, HttpStatus.OK);
	}
	@GetMapping("query")
	ResponseEntity<UserDto> getUserByEmail(@RequestParam(name="email") String email) {
		UserDto userDto = userDtoService.getUserByEmail(email);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	@PutMapping("{id}")
	ResponseEntity<UserDto> updateUser(@RequestBody User user, @PathVariable("id")Long id) {
		UserDto userDto = userDtoService.updateUser(user, id);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	@PutMapping("{id}/deactivate")
	ResponseEntity<String> deleteUser(@PathVariable("id")Long id) {
		userDtoService.deactivateUser(id);
		return new ResponseEntity<>("Üser id " + id + " deactivated ", HttpStatus.OK);
	}
}
