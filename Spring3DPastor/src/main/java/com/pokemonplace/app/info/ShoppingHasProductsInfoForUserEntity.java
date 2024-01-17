package com.pokemonplace.app.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokemonplace.app.entity.compositeKey.ShoppingProductKey;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="compras_has_productos")
public class ShoppingHasProductsInfoForUserEntity {

	@EmbeddedId 
	ShoppingProductKey id;

	@Column( name = "cantidad_compra")
	private int purchasedQuantity;

	@JoinColumn (name = "compras_id")
	@ManyToOne
	@MapsId("shoppingId")
	private ShoppingInfoForUserEntity shopping;

	@JoinColumn (name = "productos_id")
	@ManyToOne
	@MapsId("productId" )
	@JsonIgnoreProperties({"qty", "active"})
	private ProductInfoForUserEntity product;

}
