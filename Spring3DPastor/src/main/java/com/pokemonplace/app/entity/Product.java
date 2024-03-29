package com.pokemonplace.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productos")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="producto_id", nullable= false)
	private Long id;
	@Column(name="nombre_producto", nullable= false, length= 200, unique= true)
	private String nameProduct;
	@Column(name="precio", nullable= false)
	private float price;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", nullable = false)
    @JsonIgnoreProperties("categoryId")
    private Category category;
	@Column(name="cantidad_disponible", nullable= false)
	private Long qty;
	@Column(name="activo", nullable=false)
	private boolean active = true;
	@OneToMany(mappedBy = "product")
	@JsonIgnoreProperties({"imageId", "product", "active"})
	private List<Image> images;
}