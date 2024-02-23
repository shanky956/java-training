package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.Appointment;
import dao.Doctor;
import exceptions.InvalidDataException;

public class HospitalManagementImpl implements HospitalMangement {

	Scanner scanner = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	@Override
	public void createDoctor(List<Doctor> doctors) {
		
			System.out.print("Enter Doctor Id: ");
			String docId = scanner.next();

			System.out.print("Enter Doctor Name: ");
			String docName = scanner.next();

			Doctor doc = new Doctor(docId, docName);
			doctors.add(doc);
			System.out.println("Doctor with docId " + docId + " is created successfully!!");


	}

	@Override
	public void addAppointment(List<Doctor> doctors) throws InvalidDataException {
		System.out.print("Enter Doctor Id: ");
		String docId = scanner.next();
		boolean exists = false;
		try {

			for (Doctor doc : doctors) {
				if (doc.getDocId().equalsIgnoreCase(docId)) {
					exists = true;
					System.out.print("Enter Appointment Date: ");
					String appDate = scanner.next(); // Need to convert to date type

					System.out.print("Enter Number Of Patients: ");
					int noOfPatients = scanner.nextInt();

					Appointment app = new Appointment();

					app.setAppDate(sdf.parse(appDate));
					app.setNotOfPatients(noOfPatients);
					doc.getApptList().add(app);
				}
			}
			if(!exists) {
				System.out.println("Doctor Id does not exists");
			}

		}catch (ParseException e) {
			throw new InvalidDataException("Invalid date format. Please use dd/MM/yyyy.");
			// TODO: handle exception
		}
		
		catch (InvalidDataException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void displayDoctor(List<Doctor> doctors) {

		System.out.print("Enter Doctor Id: ");
		String docId = scanner.next();
		
		boolean exists = false;

		for (Doctor doc : doctors) {

			if (doc.getDocId().equalsIgnoreCase(docId)) {
				
				exists = true;

				System.out.println("\n__________________________");
				System.out.println("Doctor Id: " + doc.getDocId());
				System.out.println("Doctor Name: " + doc.getDocName());
				System.out.println("Appointment List: ");
				doc.printAppointment();
				System.out.println("\n__________________________");
			}

		}
		if(!exists) {
			System.out.println("Doctor Id does not exists");
		}

	}

	@Override
	public void displayAllDoctors(List<Doctor> doctors) {
		// TODO Auto-generated method stub
		
		for (Doctor doc : doctors) {

				System.out.println("\n__________________________");
				System.out.println("Doctor Id: " + doc.getDocId());
				System.out.println("Doctor Name: " + doc.getDocName());
				System.out.println("Appointment List: ");
				doc.printAppointment();
				System.out.println("__________________________");

		}

	}

}
