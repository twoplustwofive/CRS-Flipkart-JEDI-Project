/**
 * 
 */
package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author vijayrathod
 *
 */
public class StudentCRSMenu {
	
	Scanner sc = new Scanner(System.in);

	
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
	List<Course> l = new ArrayList<Course>();
	return l;
}

private List<Course> viewRegisteredCourse(String studentId){
	List<Course> l = new ArrayList<Course>();
	return l;
}

private void viewGradeCard(String studentId) {
	return;
}

private void make_payment(String studentId) {
	return;
}
}