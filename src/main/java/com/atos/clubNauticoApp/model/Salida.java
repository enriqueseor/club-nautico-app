package com.atos.clubNauticoApp.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "SALIDAS")
@AllArgsConstructor
@NoArgsConstructor

public class Salida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5515882341519430199L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_salida")
	private Long id;
	
	private Date fecha;
	
	private String hora;
	
	private String destino;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_persona")
	private Persona persona;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_barco")
	private Barco barco;

	public Salida(Date fecha, String hora, String destino, Persona persona, Barco barco) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.destino = destino;
		this.persona = persona;
		this.barco = barco;
	}

	public Salida(Date fecha, String hora, String destino) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.destino = destino;
	}
	
	public Salida() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Barco getBarco() {
		return barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}
}
