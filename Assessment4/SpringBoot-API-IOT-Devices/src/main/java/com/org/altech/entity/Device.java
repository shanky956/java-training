package com.org.altech.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long timestamp;

    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operating_parameters_id", referencedColumnName = "id")
    private OperatingParameters operatingParameters;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_id", referencedColumnName = "id")
    private Asset asset;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Parent parent;

    public Device() {
        // Default constructor
    }

    // Constructor with parameters
    public Device(Long timestamp, String status, OperatingParameters operatingParameters, Asset asset, Parent parent) {
        this.timestamp = timestamp;
        this.status = status;
        this.operatingParameters = operatingParameters;
        this.asset = asset;
        this.parent = parent;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OperatingParameters getOperatingParameters() {
		return operatingParameters;
	}

	public void setOperatingParameters(OperatingParameters operatingParameters) {
		this.operatingParameters = operatingParameters;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
    
    
}
