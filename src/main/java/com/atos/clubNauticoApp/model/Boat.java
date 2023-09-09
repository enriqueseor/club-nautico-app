package com.atos.clubNauticoApp.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="BOATS")
public class Boat implements Serializable{

	private static final long serialVersionUID = 2229450999885454481L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BOATREGISTRATION")
	private Long boatRegistration;
	@Column(name="NAME")
	private String name;
	@Column(name="MOORINGNUMBER",  unique = true)
	private int mooringNumber;
	@Column(name="FEE")
	private double fee;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_member")
	private Skipper skipper;
	
	public Boat(String name, int mooringNumber, double fee, Skipper skipper) {
		this.name = name;
		this.mooringNumber = mooringNumber;
		this.fee = fee;
		this.skipper = skipper;
	}

	public Boat(Long boatRegistration, String name, int mooringNumber, double fee) {
		super();
		this.boatRegistration = boatRegistration;
		this.name = name;
		this.mooringNumber = mooringNumber;
		this.fee = fee;
	}

	public Boat() {}

	public Long getBoatRegistration() {
		return boatRegistration;
	}

	public void setBoatRegistration(Long boatRegistration) {
		this.boatRegistration = boatRegistration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMooringNumber() {
		return mooringNumber;
	}

	public void setMooringNumber(int mooringNumber) {
		this.mooringNumber = mooringNumber;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public Skipper getSkipper() {
		return skipper;
	}

	public void setSkipper(Skipper skipper) {
		this.skipper = skipper;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}