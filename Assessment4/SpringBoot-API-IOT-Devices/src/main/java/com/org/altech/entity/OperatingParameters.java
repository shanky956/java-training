package com.org.altech.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "operating_parameters")
public class OperatingParameters {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double rotorSpeed;

	private int slack;

	private double rootThreshold;

	public OperatingParameters() {
		// Default constructor
	}

	public OperatingParameters(double rotorSpeed, int slack, double rootThreshold) {
		this.rotorSpeed = rotorSpeed;
		this.slack = slack;
		this.rootThreshold = rootThreshold;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getRotorSpeed() {
		return rotorSpeed;
	}

	public void setRotorSpeed(double rotorSpeed) {
		this.rotorSpeed = rotorSpeed;
	}

	public int getSlack() {
		return slack;
	}

	public void setSlack(int slack) {
		this.slack = slack;
	}

	public double getRootThreshold() {
		return rootThreshold;
	}

	public void setRootThreshold(double rootThreshold) {
		this.rootThreshold = rootThreshold;
	}

}
