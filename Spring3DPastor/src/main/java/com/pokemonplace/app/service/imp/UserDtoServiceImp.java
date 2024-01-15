package com.pokemonplace.app.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonplace.app.dto.UserDto;
import com.pokemonplace.app.entity.User;
import com.pokemonplace.app.service.UserDtoService;
import com.pokemonplace.app.service.UserService;

@Service
public class UserDtoServiceImp implements UserDtoService{
	
	@Autowired
	UserService userService;

	@Override
	public UserDto getUserById(Long id) {
		User user = userService.getUserById(id);
		return userToUserDto(user);
	}


	@Override
	public UserDto getUserByEmail(String email) {
		User user = userService.getUserByEmail(email);
		return userToUserDto(user);
	}

	@Override
	public UserDto createUser(User user) {
		User newUser = userService.createUser(user);
		return userToUserDto(newUser);
	}

	@Override
	public UserDto updateUser(User user, Long id) {
		User updateUser = userService.createUser(user);
		return userToUserDto(updateUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userService.getAllUsers();
		List<UserDto> userDto = new ArrayList<>();
		for(User user: users) {
			userDto.add(userToUserDto(user));
		}
		return userDto;
	}

	@Override
	public void deactivateUser(Long id) {
		userService.deactivateUser(id);
	}

	private UserDto userToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFullName(user.getFullName());
		userDto.setEmail(user.getEmail());
		userDto.setPhone(user.getPhone());
		return userDto;
	}
}
