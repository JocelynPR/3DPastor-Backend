package com.pokemonplace.app.entity;

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
	@Column(name="categoria_id", nullable= false)
	private Long category;
	@Column(name="cantidad_disponible", nullable= false)
	private long cuantity;
<<<<<<< HEAD
	@Column (name="activo", nullable= false)
	private boolean active;
=======
	@Column(name="activo", nullable=false)
	private boolean active = true;

>>>>>>> 6c328793719bf890924f4f999b8f8ddbdcb4e522
}
