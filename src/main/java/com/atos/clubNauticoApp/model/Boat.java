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
@Table(name="BOAT")
public class Boat implements Serializable{

	private static final long serialVersionUID = 2229450999885454481L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boatRegistration;
	private String name;
	private int mooringNUmber;
	private double fee;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_member")
	private Skipper skipper;
	
	public Boat(String name, int mooringNUmber, double fee, Skipper skipper) {
		this.name = name;
		this.mooringNUmber = mooringNUmber;
		this.fee = fee;
		this.skipper = skipper;
	}

	public Boat(Long boatRegistration, String name, int mooringNUmber, double fee) {
		super();
		this.boatRegistration = boatRegistration;
		this.name = name;
		this.mooringNUmber = mooringNUmber;
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
		return mooringNUmber;
	}

	public void setMooringNumber(int mooringNumber) {
		this.mooringNUmber = mooringNumber;
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