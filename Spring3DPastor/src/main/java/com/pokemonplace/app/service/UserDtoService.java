package com.pokemonplace.app.service;

import java.util.List;

import com.pokemonplace.app.dto.UserDto;
import com.pokemonplace.app.entity.User;

public interface UserDtoService {
	
	UserDto getUserById(Long id);
	UserDto getUserByEmail(String email);
	UserDto createUser(User user);
	UserDto updateUser(User user, Long id);
	List<UserDto> getAllUsers();
	void deactivateUser(Long id);
}
