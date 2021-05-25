/**
 * 
 */
package com.flipkart.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.service.NotificationImpl;
import com.flipkart.service.NotificationInterface;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.UserInterface;

/**
 * @author Goenka
 *
 */
public class CRSApplication {

	/**
	 * @param args
	 */
	StudentInterface studentInterface=new StudentImpl();
	ProfessorInterface profInterface =new ProfessorImpl();
	NotificationInterface notificationInterface=new NotificationImpl();
	static boolean loggedin = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		CRSApplication crsApplication=new CRSApplication();
		int userInput;	
		//create the main menu
		createMainMenu();
		userInput=sc.nextInt();
		try
		{
			
		//until user do not exit the application
		while(userInput!=4)
		{
			switch(userInput)
			{	
				case 1:
					//login
					crsApplication.loginUser();
					break;
				case 2:
					//student registration
					crsApplication.registerStudent();
					break;	
				case 3:
					crsApplication.updatePassword();
					break;
				default:
					System.out.println("Invalid Input");
			}
			createMainMenu();
			userInput=sc.nextInt();
		}
		}
		catch(Exception ex)
		{
			System.out.println("Error occured "+ex);
		}
		finally
		{
			sc.close();
		}
	}
	
	/**
	 * Method to Create Main Menu
	 */
	public static void createMainMenu()
	{
		System.out.println("----------Welcome to Course Management System---------");
		System.out.println("1. Login as Student");
		System.out.println("2. Student Registration");
		System.out.println("3. Update password");
		System.out.println("4. Exit");
		System.out.println("Enter user input");
	}
	
	/**
	 * Method for Login functionality
	 */
	public void loginUser()
	{
		//multiple exceptions are possible
		//invalid credential exception
		//user not found exception
		//user not approved exception
		Scanner sc=new Scanner(System.in);

		String userId,password;
		try
		{
			System.out.println("-----------------Login------------------");
			System.out.println("Email:");
			userId=sc.next();
			System.out.println("Password:");
			password=sc.next();
			
			//2 cases
			//true->role->student->approved
			if(loggedin)
			{
				 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
				 
				 LocalDateTime myDateObj = LocalDateTime.now();
				   
				 String formattedDate = myDateObj.format(myFormatObj);  
				 
				 
				    
				System.out.println("Welcome "+userId);
				
				Role userRole;
				switch(userRole)
				{
				case ADMIN:
					System.out.println(formattedDate + " Login Successful");
					AdminCRSMenu adminMenu=new AdminCRSMenu();
					adminMenu.createMenu();
					break;
				case PROFESSOR:
					System.out.println(formattedDate + " Login Successful");
					ProfessorCRSMenu professorMenu=new ProfessorCRSMenu();
					professorMenu.createMenu(userId);
					
					break;
				case STUDENT:
					
					int studentId=studentInterface.getStudentId(userId);
					boolean isApproved=studentInterface.isApproved(studentId);
					if(isApproved)
					{
						System.out.println(formattedDate + " Login Successful");
						StudentCRSMenu studentMenu=new StudentCRSMenu();
						studentMenu.create_menu(studentId);
						
					}
					else
					{
						System.out.println("Failed to login, you have not been approved by the administration!");
						loggedin=false;
					}
					break;
				}
				
				
			}
			else
			{
				System.out.println("Invalid Credentials!");
			}
			
		}
		catch(UserNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}	
	}
	
	/**
	 * Method to help Student register themselves, pending admin approval
	 */
	public void registerStudent()
	{
		Scanner sc=new Scanner(System.in);

		String userId,name,password,address,country,branchName;
		Gender gender;
		int genderV, batch;
		try
		{
			//input all the student details
			System.out.println("---------------Student Registration-------------");
			System.out.println("Name:");
			name=sc.nextLine();
			System.out.println("Email:");
			userId=sc.next();
			System.out.println("Password:");
			password=sc.next();
			System.out.println("Gender: \t 1: Male \t 2.Female\t 3.Other");
			genderV=sc.nextInt();
			sc.nextLine();
			System.out.println("Branch:");
			branchName=sc.nextLine();
			System.out.println("Batch:");
			batch=sc.nextInt();
			sc.nextLine();
			System.out.println("Address:");
			address=sc.nextLine();
			System.out.println("Country");
			country=sc.next();
			
			
			int newStudentId=studentInterface.register(name, userId, password, batch, address, country);
			notificationInterface.sendNotification(branchName, newStudentId, branchName, newStudentId);
			
		}
		catch(StudentNotRegisteredException ex)
		{
			System.out.println("Something went wrong! "+ex.getStudentName() +" not registered. Please try again");
		}
	}
	
	/**
	 * Method to update password of User
	 */
	public void updatePassword()
	{
		Scanner sc=new Scanner(System.in);
		String userId,newPassword;
		try
		{
			System.out.println("------------------Update Password--------------------");
			System.out.println("Email");
			userId=sc.next();
			System.out.println("New Password:");
			newPassword=sc.next();
			boolean isUpdated;
			
			// try to change the password
			
			if(isUpdated)
				System.out.println("Password updated successfully!");

			else
				System.out.println("Something went wrong, please try again!");
		}
		catch(Exception ex)
		{
			System.out.println("Error Occured "+ex.getMessage());
		}
	}
		
	}

}
