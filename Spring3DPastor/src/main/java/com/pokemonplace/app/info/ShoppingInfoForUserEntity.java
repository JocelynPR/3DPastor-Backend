package com.pokemonplace.app.info;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokemonplace.app.entity.Status;
import com.pokemonplace.app.entity.User;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="compras")
public class ShoppingInfoForUserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name= "compras_id", nullable= false)
	private Long id;
	@ManyToOne
	@JoinColumn(name= "usuario_id", nullable= false)
	private User user;
	@Column(name= "fecha_compra", length= 150)
	private Timestamp date;
	@ManyToOne
	@JoinColumn(name= "estado_id", nullable= false)
	@JsonIgnoreProperties("statusId")
	private Status status;
	@OneToMany(mappedBy="shopping")
	@JsonIgnoreProperties({"id", "shopping"})
	private List<ShoppingHasProductsInfoForUserEntity> products;

}
