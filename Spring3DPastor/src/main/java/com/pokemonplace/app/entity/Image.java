package com.pokemonplace.app.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table( name="imagenes_productos" )
public class Image {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "imagen_id", nullable = false )
	private Long imageId;
	@Column( name = "nombre_imagen", nullable = false, length = 120 )
	private String imageName;
	@Column( name = "producto_id", nullable = false )
	private Long productId;
	@Column( name = "activo", nullable = false )
	private boolean active;
}
