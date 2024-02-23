package service;

import java.util.List;

import dao.Doctor;
import exceptions.InvalidDataException;

public interface HospitalMangement {
	
	public void createDoctor(List<Doctor> doctors);
	public void addAppointment(List<Doctor> doctors) throws InvalidDataException;
	public void displayDoctor(List<Doctor> doctors);
	public void displayAllDoctors(List<Doctor> doctors);

}
