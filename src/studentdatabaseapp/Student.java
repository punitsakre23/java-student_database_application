package studentdatabaseapp;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int  gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	// Constructor: prompt user to enter student's name and year
	public Student() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter student's first name: ");
		this.firstName = sc.nextLine();
		
		System.out.print("Enter student's second name: ");
		this.lastName = sc.nextLine();
		
		System.out.print("1 - First year\n2 - Second year\n3 - Third year\n4 - Fourth year\nEnter student's grade year: ");
		this.gradeYear = sc.nextInt();
		
		setStudentID();		
	}
	
	// Generate an ID
	private void setStudentID() {
		// Grade Level + ID
		id++;
		this.studentID =  gradeYear + "" + id;
	}
	
	// Enroll in courses
	public void enroll() {
		// Get inside a loop, user hits Q
		boolean temp = true;
		Scanner sc = new Scanner(System.in);
		while (temp == true) {
			System.out.print("Enter course to enroll (Q to quit): ");
			String course = sc.nextLine();
			if (course.equalsIgnoreCase("Q")) {
				temp = false;
			}
			else {
				courses += "\n " + course;
				tuitionBalance += costOfCourse;
			}
		}
	}
	
	// View Balance
	public void viewBalance() {
		System.out.println("Your Balance is: " + tuitionBalance);
	}
	
	// Pay tuition
	public void payTuition() {
		Scanner sc = new Scanner(System.in);
		viewBalance();
		System.out.print("Enter your payment: $");
		int payment = sc.nextInt();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}
	
	// Show info
	public String toString() {
		return "Name: " + firstName + " " + lastName +
				"\nGrade Level: " + gradeYear +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance;
	}
	
}
