package com.Vehicle;

public abstract class Vehicle {

	private int vehicleNo;
	private String engineStatus;
	private int currentGear;

	public Vehicle(int vehicleNo, String engineStatus, int currentGear) {
		super();
		this.vehicleNo = vehicleNo;
		this.engineStatus = engineStatus;
		this.currentGear = currentGear;
	}

	abstract public void ignite();

	abstract public int changeGear(int flag);

	abstract public void stop();

	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getEngineStatus() {
		return engineStatus;
	}

	public void setEngineStatus(String engineStatus) {
		this.engineStatus = engineStatus;
	}

	public int getCurrentGear() {
		return currentGear;
	}

	public void setCurrentGear(int currentGear) {
		this.currentGear = currentGear;
	}

	protected void showVehicleDetails() {
		System.out.println("\nVehicle No: " + this.getVehicleNo());
		System.out.println("Engine Status: " + this.getEngineStatus());
		System.out.println("Current Gear: " + this.getCurrentGear());
	}

}
