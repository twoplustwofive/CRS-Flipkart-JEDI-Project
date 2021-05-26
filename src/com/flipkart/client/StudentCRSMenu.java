/**
 * 
 */
package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.service.*;

import java.util.List;
import java.util.Scanner;

/**
 * @author vijayrathod
 *
 */
public class StudentCRSMenu {
	
	Scanner sc = new Scanner(System.in);
	RegistrationInterface registrationInterface = RegistrationOperation.getInstance();
	ProfessorInterface professorInterface = ProfessorOperation.getInstance();
	NotificationInterface notificationInterface=NotificationOperation.getInstance();
	private boolean is_registered;
	

	
	public void create_menu(String studentId) {
		
		
		while(true) {
			
				int choice = sc.nextInt();
			
				switch (choice) {
				
				case 1: 
					registerCourses(studentId);
					break;
					
				case 2:
					addCourse(studentId);
					break;
					
				case 3:
					dropCourse(studentId);
					break;
					
				case 4:
					viewCourse(studentId);
					break;
					
				case 5:
					viewRegisteredCourse(studentId);
					break;
					
				case 6:
					viewGradeCard(studentId);
					break;
					
				case 7:
					make_payment(studentId);
					break;
					
				case 8:
					CRSApplication.loggedin = false;
					break;			
					
				default:
					System.out.println("Incorrect Choice!");
		
		
			}
			
		}
		
	}






private void registerCourses(String studentId) 
{
	StudentOperation Sop = new StudentOperation();
	
	Sop.register();
	
	return;
}


private void addCourse(String studentId) {
	return;
}

private void dropCourse(String studentId) {
	return;
}

private List<Course> viewCourse(String studentId){
	return;
}

private List<Course> viewRegisteredCourse(String studentId){
	return;
}

private void viewGradeCard(String studentId) {
	return;
}

private void make_payment(String studentId) {
	return;
}
}