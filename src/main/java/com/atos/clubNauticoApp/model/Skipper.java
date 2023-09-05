package com.atos.clubNauticoApp.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "SOCIOS")
@AllArgsConstructor
public class Skipper implements Serializable{

	private static final long serialVersionUID = -6612176685983969125L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_socio", unique = true)
	private Long id;
	
	@Column(name = "DNI", unique = true)
	private String dni;
	
	@NotBlank
	@Size(min = 3)
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="PATRON")
	private Boolean patron;
	
	@OneToMany(mappedBy="socio", fetch = FetchType.LAZY)
	@Column(name="Barcos")
	private List<Boat> boat;

	
	public Skipper(String dni, @NotBlank @Size(min = 3) String nombre, Boolean patron, List<Boat> boat) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.patron = patron;
		this.boat = boat;
	}

	public Skipper(String dni, @NotBlank @Size(min = 3) String nombre, Boolean patron) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.patron = patron;
	}

	public Skipper() {
		super();
	}

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

	public List<Boat> getBarco() {
		return boat;
	}

	public void setBarco(List<Boat> boat) {
		this.boat = boat;
	}
}