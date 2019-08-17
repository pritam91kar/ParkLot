package com.skillenza.parkinglotjava;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "parkinglots")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class ParkingLot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@CreationTimestamp
	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime created_at;
	
	@Column(name = "lot")
	private int lot;
	
	@Column(name = "parking_amount")
	private int parking_amount;
	
	@Column(name = "parking_duration")
	private int parking_duration;
	
	@UpdateTimestamp
	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updated_at;
	
	@Column(name = "vaichel_number")
	private int vaichel_number;
	
	public ParkingLot() {
		super();
	}
	
	public ParkingLot(int id,LocalDateTime created_at,int lot,int parking_amount,int parking_duration,LocalDateTime updated_at,int vaichel_number) {
		super();
		this.id = id;
		this.created_at = created_at;
		this.lot = lot;
		this.parking_amount = parking_amount;
		this.parking_duration = parking_duration;
		this.updated_at = updated_at;
		this.vaichel_number = vaichel_number;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = LocalDateTime.now();
	}

	public int getLot() {
		return lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	public int getParking_amount() {
		return parking_amount;
	}

	public void setParking_amount(int parking_amount) {
		this.parking_amount = parking_amount;
	}

	public int getParking_duration() {
		return parking_duration;
	}

	public void setParking_duration(int parking_duration) {
		this.parking_duration = parking_duration;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = LocalDateTime.now();
	}

	public int getVaichel_number() {
		return vaichel_number;
	}

	public void setVaichel_number(int vaichel_number) {
		this.vaichel_number = vaichel_number;
	}
    
}
