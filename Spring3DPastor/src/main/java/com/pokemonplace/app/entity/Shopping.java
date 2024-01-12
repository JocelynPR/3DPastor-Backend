package com.pokemonplace.app.entity;

import java.sql.Timestamp;

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
	@Column(name= "usuario_id", nullable= false)
	private Long userId;
	@Column(name= "fecha_compra", length= 150)
	private Timestamp date;
	@Column(name= "estado_id", nullable= false)
	private Long status;

}
