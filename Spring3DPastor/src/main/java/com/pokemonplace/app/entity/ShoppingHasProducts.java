package com.pokemonplace.app.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokemonplace.app.entity.compositeKey.ShoppingProductKey;
import jakarta.persistence.*;
import lombok. *;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="compras_has_productos")

public class ShoppingHasProducts {
	
	

	
	
		@EmbeddedId 
		ShoppingProductKey id;
		
		@Column( name = "cantidad_compra")
		private int quantity;
		
		@JoinColumn (name = "compras_id")
		@ManyToOne
		@MapsId("shoppingId" )
		@JsonIgnoreProperties("userId")
		private Shopping shopping;
		
		
		@JoinColumn (name = "productos_id")
		@ManyToOne
		@MapsId("productId" )
		private Product product;
		
	
	
	

}
