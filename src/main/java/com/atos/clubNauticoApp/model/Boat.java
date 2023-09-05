package com.atos.clubNauticoApp.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Barcos")
public class Boat implements Serializable{

	private static final long serialVersionUID = 2229450999885454481L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroMatricula;
	
	private String nombre;
	
	private int numeroAmarre;
	
	private double cuota;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_socio")
	private Skipper skipper;
	
	public Boat(String nombre, int numeroAmarre, double cuota, Skipper skipper) {
		this.nombre = nombre;
		this.numeroAmarre = numeroAmarre;
		this.cuota = cuota;
		this.skipper = skipper;
	}

	public Boat(Long numeroMatricula, String nombre, int numeroAmarre, double cuota) {
		super();
		this.numeroMatricula = numeroMatricula;
		this.nombre = nombre;
		this.numeroAmarre = numeroAmarre;
		this.cuota = cuota;
	}

	public Boat() {
	}

	public Long getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Long numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroAmarre() {
		return numeroAmarre;
	}

	public void setNumeroAmarre(int numeroAmarre) {
		this.numeroAmarre = numeroAmarre;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public Skipper getSocio() {
		return skipper;
	}

	public void setSocio(Skipper skipper) {
		this.skipper = skipper;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}