package com.pokemonplace.app.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table( name="estado_compra" )
public class Status {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="estado_id", nullable=false)
	private Long statusId;
	@Column(name="estado_compra", nullable=false, length=60)
	private String status;

}
