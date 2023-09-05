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
@Table(name = "MEMBER")
@AllArgsConstructor
public class Member implements Serializable {

	private static final long serialVersionUID = -4692544910217024117L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DNI", unique = true)
	private String dni;
	
	@NotBlank
	@Size(min = 3)
	@Column(name="NAME")
	private String name;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getPatron() {
		return patron;
	}

	public void setPatron(Boolean patron) {
		this.patron = patron;
	}

	public Member(String dni, @NotBlank @Size(min = 3) String name, Boolean patron) {
		super();
		this.dni = dni;
		this.name = name;
		this.patron = patron;
	}

	public Member() {
		super();
	}
}