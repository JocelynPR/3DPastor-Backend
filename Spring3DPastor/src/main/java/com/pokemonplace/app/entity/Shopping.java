package com.pokemonplace.app.entity;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokemonplace.app.info.ShoppingHasProductsInfoForShoppingEntity;
import com.pokemonplace.app.info.UserInfoForShoppingEntity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="compras")

public class Shopping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name= "compras_id", nullable= false)
	private Long id;
	@ManyToOne
	@JoinColumn(name= "usuario_id", nullable= false)
	@JsonIgnoreProperties({"password", "roleId", "active", "orders"})
	private UserInfoForShoppingEntity user;
	@Column(name= "fecha_compra", length= 150)
	private Timestamp date;
	@ManyToOne
	@JoinColumn(name= "estado_id", nullable= false)
	@JsonIgnoreProperties("statusId")
	private Status status;
	@OneToMany(mappedBy="shopping")
	@JsonIgnoreProperties({"id", "shopping"})
	private List<ShoppingHasProductsInfoForShoppingEntity> products;
	

}
