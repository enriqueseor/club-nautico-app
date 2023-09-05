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

@Data
@Entity
@Table(name = "SALIDAS")
@AllArgsConstructor
public class Trip implements Serializable{

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
	private Member member;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_barco")
	private Boat boat;

	public Trip(Date fecha, String hora, String destino, Member member, Boat boat) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.destino = destino;
		this.member = member;
		this.boat = boat;
	}

	public Trip(Date fecha, String hora, String destino) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.destino = destino;
	}
	
	public Trip() {
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

	public Member getPersona() {
		return member;
	}

	public void setPersona(Member member) {
		this.member = member;
	}

	public Boat getBarco() {
		return boat;
	}

	public void setBarco(Boat boat) {
		this.boat = boat;
	}
}