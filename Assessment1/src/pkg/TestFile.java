package pkg;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TestFile {

	public static void main(String[] args) {

		String grades[] = { "U1", "U2", "U3", "U4", "P1", "P2" };
		Scanner scanner = new Scanner(System.in);
		int empId;
		String empName;
		String empGrade;

		System.out.print("Enter the total number of employees:");
		int num = scanner.nextInt();

		Employee emps[] = new Employee[num];

		for (int i = 0; i < num; i++) {
			try {

				emps[i] = new Employee();
				System.out.print("Enter Employee Id: ");
				empId = scanner.nextInt();

				System.out.print("Enter Employee Name: ");
				empName = scanner.next();

				boolean matchFound = false;

				System.out.print("Enter Employee Grade: ");
				empGrade = scanner.next();
				for (String grade : grades) {
					if (grade.equalsIgnoreCase(empGrade)) {
						matchFound = true;
						emps[i].setEmpId(empId);
						emps[i].setEmpName(empName);
						emps[i].setGrade(empGrade);
						break;
					}
				}
				if (!matchFound) {
					throw new InvalidGradeException("Employee grade is not valid!");

				}
				System.out.println();
			} catch (InvalidGradeException e) {
				System.out.println("Enter proper grades!! \n");
				System.out.println("Re-enter the details");
				i--;
			}
		}

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empdetails.txt"));
			for (Employee emp2 : emps) {
				oos.writeObject(emp2);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\nEmployee details saved to file!!! \n");

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empdetails.txt"))) {
			System.out.println("\nEmployee details read from file!!! \n");

			// Read objects in a loop until EOFException is thrown
			while (true) {
				try {
					Employee readEmployee = (Employee) ois.readObject();
					System.out.println("Employee Details Read from file:");
					System.out.println("Employee Id: " + readEmployee.getEmpId());
					System.out.println("Employee Name: " + readEmployee.getEmpName());
					System.out.println("Employee Grade: " + readEmployee.getGrade() + "\n");
				} catch (EOFException eof) {
					// EOFException is expected when reaching the end of the file
					break; // Exit the loop when EOF is reached
				} catch (ClassNotFoundException e) {
					System.err.println("Class not found: " + e.getMessage());
					break; // Exit the loop on ClassNotFoundException
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading from file: " + e.getMessage());
		}
		finally {
			scanner.close();
		}

	}

}
