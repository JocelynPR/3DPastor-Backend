package com.pokemonplace.app.service;

import java.util.List;

import com.pokemonplace.app.entity.User;

public interface UserService {

	User getUserById(Long id);
	User getUserByEmail(String email);
	User createUser(User user);
	User updateUser(User user, Long id);
<<<<<<< HEAD
	void deleteUser(Long id);
=======
>>>>>>> 6c328793719bf890924f4f999b8f8ddbdcb4e522
	List<User> getAllUsers();
	void deactivateUser(Long id);
}
