package pkg;

import java.io.Serializable;

public class Employee implements Serializable{

	private int empId;
	private String empName;
	private String grade;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Employee Id:" + empId + ",\t Employee Name:" + empName + ",\t Employee Grade:" + grade;
	}

}
