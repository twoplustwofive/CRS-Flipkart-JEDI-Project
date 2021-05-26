/**
 * 
 */
package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.service.*;

import java.sql.SQLException;
import java.util.ArrayList;
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
	NotificationInterface notificationInterface = NotificationOperation.getInstance();
	private boolean is_registered;
	

	
	public void create_menu(String studentId) {
		
		is_registered = getRegistrationStatus(studentId);
		
		while(CRSApplication.loggedin) {
			
				System.out.println("*****************************");
				System.out.println("**********Student Menu*********");
				System.out.println("*****************************");
				System.out.println("1. Course Registration");
				System.out.println("2. Add Course");
				System.out.println("3. Drop Course");
				System.out.println("4. View Course");
				System.out.println("5. View Registered Courses");
				System.out.println("6. View grade card");
				System.out.println("7. Make Payment");
				System.out.println("8. Logout");
				System.out.println("*****************************");
			
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
	if(is_registered)
	{
		System.out.println(" Registration is already completed");
		return;
	}
	
	int count = 0;
	while(count < 6)
	{
		try
		{
			List<Course> courseList=viewCourse(studentId);
			
			if(courseList==null)
				return;
			
			System.out.println("Enter Course Code : " + (count+1));
			String courseCode = sc.next();
			
			if(registrationInterface.addCourse(courseCode,studentId,courseList))
			{
				System.out.println("Course " + courseCode + " registered sucessfully.");
				count++;
			}
			else
			{
				System.out.println(" You have already registered for Course : " + courseCode);
			}
		}	
		catch(CourseNotAvailableException | CourseLimitExceededException | SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	System.out.println("Registration Successful");	
    is_registered = true;
    
    try 
    {
		registrationInterface.setRegistrationStatus(studentId);
	} 
    catch (SQLException e) 
    {
    	System.out.println(e.getMessage());
	}
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