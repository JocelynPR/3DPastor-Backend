package com.pokemonplace.app.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="usuarios")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name= "usuario_id", nullable= false)
	private Long id;
	@Column(name= "usuario_nombre", nullable= false, length= 120)
	private String fullName;
	@Column(name= "email", nullable= false, length= 60, unique= true)
	private String email;
	@Column(name= "telefono", nullable= false, length= 20)
	private String phone;
	@Column(name= "contrasena", nullable= false, length= 20)
	private String password;
	@Column(name= "direccion", length= 150)
	private String address;
	@Column(name= "rol_id", nullable= false)
	private long roleId = 2;
	
	// Modifications 
	@Column(name= "activo", nullable= false)
	private boolean active;
}
