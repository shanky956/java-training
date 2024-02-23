package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Doctor {

	private String docId;
	private String docName;

	private List<Appointment> apptList;

	public Doctor(String docId, String docName) {
		this.docId = docId;
		this.docName = docName;
		this.apptList = new ArrayList<Appointment>();
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public List<Appointment> getApptList() {
		return apptList;
	}

	public void setApptList(List<Appointment> apptList) {
		this.apptList = apptList;
	}

	public void addAppointment(Appointment appointment) {
		this.apptList.add(appointment);

	}

	public void printAppointment() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		for (Appointment app : this.apptList) {
			System.out.println("******");
			System.out.println("Appointment Date: " + sdf.format(app.getAppDate()));
			System.out.println("Number of patients: " + app.getNoOfPatients());
		}
	}

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", docName=" + docName + ", apptList=" + apptList + "]";
	}

}
