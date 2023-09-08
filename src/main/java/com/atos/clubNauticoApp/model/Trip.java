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
@Table(name = "TRIPS")
@AllArgsConstructor
public class Trip implements Serializable{

	private static final long serialVersionUID = 5515882341519430199L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_trip")
	private Long id;
	private Date date;
	private String time;
	private String destination;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_skipper")
	private Skipper skipper;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_member")
	private Member member;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_boat")
	private Boat boat;

	public Trip(Date date, String time, String destination, Skipper skipper, Member member, Boat boat) {
		super();
		this.date = date;
		this.time = time;
		this.destination = destination;
		this.skipper = skipper;
		this.member = member;
		this.boat = boat;
	}

	public Trip(Date date, String time, String destination) {
		super();
		this.date = date;
		this.time = time;
		this.destination = destination;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Skipper getSkipper() {return skipper;}

	public void setSkipper(Skipper skipper) {this.skipper = skipper;}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}
}