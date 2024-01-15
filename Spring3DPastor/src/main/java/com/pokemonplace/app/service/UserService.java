package com.pokemonplace.app.service;

import java.util.List;

import com.pokemonplace.app.entity.User;

public interface UserService {

	User getUserById(Long id);
	User getUserByEmail(String email);
	User createUser(User user);
	User updateUser(User user, Long id);
	void deleteUser(Long id);
	List<User> getAllUsers();
	void deactivateUser(Long id);
}
