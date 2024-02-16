package com.Vehicle;

public class Car extends Vehicle {

	private boolean powerStearing;
	private String fuelType;

	public Car(int vehicleNo, String engineStatus, int currentGear, boolean powerStearing, String fuelType) {
		super(vehicleNo, engineStatus, currentGear);
		this.fuelType = fuelType;
		this.powerStearing = powerStearing;
	}

	@Override
	public void ignite() {
		super.setEngineStatus("ON");
		super.setCurrentGear(1);
		System.out.println("\nEngine Started");
		System.out.println("Current Gear:"+super.getCurrentGear());

	}

	@Override
	public int changeGear(int flag) {
		int gear = super.getCurrentGear();

		if ((flag == 1) && (gear < 6)) {
			gear++;
		} else if ((flag == -1) && (gear > 1)) {
			--gear;
		}
		System.out.println("\n Current Gear:"+gear);
		
		super.setCurrentGear(gear);

		return gear;
	}

	@Override
	public void stop() {
		super.setEngineStatus("OFF");
		super.setCurrentGear(0);
		System.out.println("\nEngine OFF");
		System.out.println("Current Gear:"+super.getCurrentGear());

	}

	public void showCarDetails() {
		super.showVehicleDetails();
		System.out.println("Power Stearing: " + this.powerStearing);
		System.out.println("Fuel Type: " + this.fuelType);
	}

}
