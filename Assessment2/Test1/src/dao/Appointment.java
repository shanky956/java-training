package dao;

import java.util.Date;

import exceptions.InvalidDataException;

public class Appointment {

	private Date appDate;
	private int noOfPatients;

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public int getNoOfPatients() {
		return noOfPatients;
	}

	public void setNotOfPatients(int noOfPatients) throws InvalidDataException {
		
		if(noOfPatients >=1 && noOfPatients <=15) {
			this.noOfPatients = noOfPatients;
		}
		else {
			throw new InvalidDataException("Number of appointments should be in the range 1- 15");
		}
		
	}

	@Override
	public String toString() {
		return "Appointment Date: " + appDate + ", No. Of Patients:" + noOfPatients;
	}

}
