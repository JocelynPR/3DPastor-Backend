package com.pokemonplace.app.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Long id;
	private String fullName;
	private String email;
	private String phone;
	private String address;
}
