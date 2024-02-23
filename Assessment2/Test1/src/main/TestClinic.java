package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.Doctor;
import exceptions.InvalidDataException;
import service.HospitalManagementImpl;

public class TestClinic {
	
	public static void main(String args[]) throws InvalidDataException {
		
		Scanner scanner = new Scanner(System.in);
		List<Doctor> doctors = new ArrayList<Doctor>();
		HospitalManagementImpl hpmgmt = new HospitalManagementImpl();
		while(true) {
			
			System.out.println("\n********|Menu|********");
			System.out.println("1. Add Doctor");
			System.out.println("2. Create Appointment");
			System.out.println("3. Display A Doctor");
			System.out.println("4. Diplay All Doctors");
			System.out.println("5. Exit");
			System.out.print("Enter your choice:");
			int choice = scanner.nextInt();
			
			switch(choice) {
			
			case 1:
				hpmgmt.createDoctor(doctors);
				break;
			case 2:
				hpmgmt.addAppointment(doctors);
				break;
			case 3:
				hpmgmt.displayDoctor(doctors);
				break;
			case 4:
				hpmgmt.displayAllDoctors(doctors);
				break;
			case 5:
				System.out.println("Thank You!!");
				System.exit(0);
			}
			
		}
	}

}
