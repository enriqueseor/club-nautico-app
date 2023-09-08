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
@Table(name = "SKIPPERS")
@AllArgsConstructor
public class Skipper implements Serializable{

	private static final long serialVersionUID = -6612176685983969125L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_member", unique = true)
	private Long id;
	
	@Column(name = "DNI", unique = true)
	private String dni;
	
	@NotBlank
	@Size(min = 3, max = 100)
	@Column(name="NAME")
	private String name;
	
	@Column(name="SKIPPER")
	private Boolean skipper;
	
	@OneToMany(mappedBy="skipper", fetch = FetchType.LAZY)
	@Column(name="Boat")
	private List<Boat> boat;

	public Skipper(String dni, @NotBlank @Size(min = 3) String name, Boolean skipper, List<Boat> boat) {
		super();
		this.dni = dni;
		this.name = name;
		this.skipper = skipper;
		this.boat = boat;
	}

	public Skipper(String dni, @NotBlank @Size(min = 3) String name, Boolean skipper) {
		super();
		this.dni = dni;
		this.name = name;
		this.skipper = skipper;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSkipper() {
		return skipper;
	}

	public void setSkipper(Boolean skipper) {
		this.skipper = skipper;
	}

	public List<Boat> getBoat() {
		return boat;
	}

	public void setBoat(List<Boat> boat) {
		this.boat = boat;
	}
}