package com.pokemonplace.app.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.pokemonplace.app.entity.*;
import com.pokemonplace.app.repository.UserRepository;
import com.pokemonplace.app.service.*;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if( userOptional.isPresent())return userOptional.get();
		else throw new IllegalStateException("Id not found " + id); 
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<User> userOptional = userRepository.findByEmail(email);
		if( userOptional.isPresent())return userOptional.get();
		else throw new IllegalStateException("Email not found " + email);
	}

	@Override
	public User createUser(User user) {
		user.setId(null);
		user.setActive(true);
		User newUser = userRepository.save(user);
		return newUser;
	}

	@Override
	public User updateUser(User user, Long id) {
		User existingUser = getUserById(id);
		existingUser.setFullName(user.getFullName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAddress(user.getAddress());
		existingUser.setPhone(user.getPhone());
		return userRepository.save(existingUser);
	}

	@Override
<<<<<<< HEAD
	public void deleteUser(Long id) {
		User existingUser = getUserById(id);
		userRepository.delete(existingUser);
	}
	
	@Override
=======
>>>>>>> 6c328793719bf890924f4f999b8f8ddbdcb4e522
	public List<User> getAllUsers(){
		List<User> users = (List<User>) userRepository.findAllByActive(true);
		return users;
	}
	
	@Override
	public void deactivateUser(Long id) {
		User existingUser = getUserById(id);
		existingUser.setActive(false);
		userRepository.save(existingUser);	
	}
}
