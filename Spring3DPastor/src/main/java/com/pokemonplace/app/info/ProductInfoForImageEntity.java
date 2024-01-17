package com.pokemonplace.app.info;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokemonplace.app.entity.Category;
import com.pokemonplace.app.entity.Image;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productos")
public class ProductInfoForImageEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="producto_id", nullable= false)
	private Long id;
	@Column(name="nombre_producto", nullable= false, length= 200, unique= true)
	private String nameProduct;
	@Column(name="precio", nullable= false)
	private float price;
	@ManyToOne
	@JoinColumn(name="categoria_id", nullable= false)
	@JsonIgnoreProperties("categoryId")
	private Category category;
	@Column(name="cantidad_disponible", nullable= false)
	private Long availableQty;
	@Column(name="activo", nullable=false)
	private boolean active = true;
	@OneToMany(mappedBy = "product")
	@JsonIgnoreProperties({"imageId", "product", "active"})
	private List<Image> images;
}