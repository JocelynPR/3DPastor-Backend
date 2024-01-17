package com.pokemonplace.app.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="compras")

public class Shopping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name= "compras_id", nullable= false)
	private Long id;
	@ManyToOne
	@JoinColumn(name= "usuario_id", nullable= false)
	@JsonIgnoreProperties({"password", "roleId", "active"})
	private User user;
	@Column(name= "fecha_compra", length= 150)
	private Timestamp date;
	@ManyToOne
	@JoinColumn(name= "estado_id", nullable= false)
	@JsonIgnoreProperties("statusId")
	private Status status;

}
