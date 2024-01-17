package com.pokemonplace.app.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokemonplace.app.entity.Shopping;
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
public class ShoppingHasProductsInfoForShoppingEntity {

	@EmbeddedId 
	ShoppingProductKey id;

	@Column( name = "cantidad_compra")
	private int purchasedQty;

	@JoinColumn (name = "compras_id")
	@ManyToOne
	@MapsId("shoppingId" )
	private Shopping shopping;

	@JoinColumn (name = "productos_id")
	@ManyToOne
	@MapsId("productId" )
	@JsonIgnoreProperties({"id", "qty", "active"})
	private ProductInfoForShoppingEntity product;

}
