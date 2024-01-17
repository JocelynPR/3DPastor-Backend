package com.pokemonplace.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokemonplace.app.entity.Shopping;

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
	@JsonIgnoreProperties("user")
	private List<Shopping> orders;
}
