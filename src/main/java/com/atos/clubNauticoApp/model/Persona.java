package com.atos.clubNauticoApp.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@Table(name = "PERSONAS")
@AllArgsConstructor
public class Persona implements Serializable {

	private static final long serialVersionUID = -4692544910217024117L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DNI", unique = true)
	private String dni;
	
	@NotBlank
	@Size(min = 3)
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="PATRON")
	private Boolean patron;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getPatron() {
		return patron;
	}

	public void setPatron(Boolean patron) {
		this.patron = patron;
	}

	public Persona(String dni, @NotBlank @Size(min = 3) String nombre, Boolean patron) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.patron = patron;
	}

	public Persona() {
		super();
	}
}