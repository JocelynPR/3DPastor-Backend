package com.pokemonplace.app.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table( name="categorias" )
public class Category {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "categoria_id", nullable = false )
	private Long categoryId;
	@Column( name = "nombre_categoria", nullable = false, length = 45 )
	private String categoryName;
	
}
