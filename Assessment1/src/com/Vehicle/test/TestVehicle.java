package com.Vehicle.test;

import java.util.Scanner;

import com.Vehicle.Car;

public class TestVehicle {

	public static void main(String[] args) throws InterruptedException {

		int vehicleNo;
		String engineStatus;
		int currentGear;
		boolean powerStearing;
		String fuelType;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Vehicle Number: ");
		vehicleNo = scanner.nextInt();

		System.out.print("Enter Engine Status(ON/OFF): ");
		engineStatus = scanner.next();

		System.out.print("Enter Current Gear(1-6): ");
		currentGear = scanner.nextInt();

		System.out.print("Enter Fuel Type(Gas/Petrol/Deisel): ");
		fuelType = scanner.next();

		System.out.print("Power Stearing Present?(True/False): ");
		String isPresent = scanner.next();
		powerStearing = Boolean.parseBoolean(isPresent);

		System.out.println();

		Car car = new Car(vehicleNo, engineStatus, currentGear, powerStearing, fuelType);

		while (true) {

			System.out.println("\n**********MENU**********");
			System.out.println("1. Ignite");
			System.out.println("2. Change Gear");
			System.out.println("3. Stop");
			System.out.println("4. Display Car");
			System.out.println("5. Exit");
			System.out.print("Enter your choice:");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				car.ignite();
				break;
			case 2:
				System.out.println("Enter 1 for Shift Up and 0 for Shift down");
				int checkGear = scanner.nextInt();
				if (checkGear == 1)
					car.changeGear(1);
				else if (checkGear == 0)
					car.changeGear(-1);
				else
					System.out.println("Invalid Input!");
				break;
			case 3:
				car.stop();
				break;
			case 4:
				car.showCarDetails();
				break;
			case 5:
				System.out.println("Thank You!");
				System.exit(0);
			}
		}

	}

}
