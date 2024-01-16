package com.pokemonplace.app.entity.compositeKey;

import java.io.Serializable;

import org.springframework.stereotype.*;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;


@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable

public class ShoppingProductKey implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Column( name = "compras_id" )
	Long shoppingId;
	@Column( name = "producto_id" )
	Long productId;

}
