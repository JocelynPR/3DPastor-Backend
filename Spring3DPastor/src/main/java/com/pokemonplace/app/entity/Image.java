package com.pokemonplace.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokemonplace.app.info.ProductInfoForImageEntity;

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
	@ManyToOne
	@JoinColumn( name = "producto_id", nullable = false )
	@JsonIgnoreProperties({"active", "images"})
	private ProductInfoForImageEntity product;
	@Column( name = "activo", nullable = false )
	private boolean active;
}