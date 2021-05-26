/**
 * 
 */
package com.flipkart.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.constant.Gender;
import com.flipkart.constant.NotificationType;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserNotFoundException;

import com.flipkart.service.NotificationInterface;
import com.flipkart.service.NotificationOperation;


import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

/**
 * @author Goenka
 *
 */
public class CRSApplication {

	private static Logger logger = Logger.getLogger(CRSApplication.class);
	static boolean loggedin = false;
	StudentInterface studentInterface=StudentOperation.getInstance();
	UserInterface userInterface =UserOperation.getInstance();
	NotificationInterface notificationInterface=NotificationOperation.getInstance();
	
	public static void main(String[] args) {
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
					logger.info("Invalid Input");
			}
			createMainMenu();
			userInput=sc.nextInt();
		}
		}
		catch(Exception ex)
		{
			logger.error("Error occured "+ex);
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
		logger.info("----------Welcome to Course Management System---------");
		logger.info("1. Login");
		logger.info("2. Student Registration");
		logger.info("3. Update password");
		logger.info("4. Exit");
		logger.info("Enter user input");
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
		Scanner in = new Scanner(System.in);

		String userId,password;
		try
		{
			logger.info("-----------------Login------------------");
			logger.info("Email:");
			userId = in.next();
			logger.info("Password:");
			password = in.next();
			loggedin = userInterface.verifyCredentials(userId, password);
			if(loggedin)
			{
				 logger.info("Logged in");
				 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
				 
				 LocalDateTime myDateObj = LocalDateTime.now();
				   
				 String formattedDate = myDateObj.format(myFormatObj);  
				
				 String role = userInterface.getRole(userId);
			
			
				 
				 
				switch(role) {
				case "ADMIN":
					logger.info(formattedDate + " Login Successful");
					AdminCRSMenu adminMenu = new AdminCRSMenu();
					adminMenu.createMenu();
					break;
				case "PROFESSOR":
					logger.info(formattedDate + " Login Successful");
					ProfessorCRSMenu professorMenu=new ProfessorCRSMenu();
					professorMenu.createMenu(userId);
					
					break;
				case "STUDENT":
					
					String studentId = userId;
					boolean isApproved=studentInterface.isApproved(studentId);
					if(isApproved) {
						logger.info(formattedDate + " Login Successful");
						StudentCRSMenu studentMenu=new StudentCRSMenu();
						studentMenu.create_menu(studentId);
						
					} else {
						logger.warn("Failed to login, you have not been approved by the administration!");
						loggedin=false;
					}
					break;
				}
				
				
			}
			else
			{
				logger.error("Invalid Credentials!");
			}
			
		}
		catch(UserNotFoundException ex)
		{
			logger.error(ex.getMessage());
		}
		in.close();
	}
	
	/**
	 * Method to help Student register themselves, pending admin approval
	 */
	public void registerStudent()
	{
		Scanner sc=new Scanner(System.in);

		String userId,name,password,address,branchName;
		Gender gender;
		int genderV, batch;
		try
		{
			//input all the student details
			logger.info("---------------Student Registration-------------");
			logger.info("Name:");
			name=sc.nextLine();
			logger.info("Email:");
			userId=sc.next();
			logger.info("Password:");
			password=sc.next();
			logger.info("Gender: \t 1: Male \t 2.Female\t 3.Other");
			genderV=sc.nextInt();
			sc.nextLine();
			
			switch(genderV)
			{
			case 1:
				gender=Gender.MALE;
				break;
			case 2:
				gender=Gender.FEMALE;
				break;
				
			case 3:
				gender=Gender.OTHER;
				break;
			default: 
				gender=Gender.OTHER;
			}
			
			logger.info("Branch:");
			branchName=sc.nextLine();
			logger.info("Batch:");
			batch=sc.nextInt();
			sc.nextLine();
			logger.info("Address:");
			address=sc.nextLine();
			
			
			String newStudentId = studentInterface.register(name, userId, password, gender, batch, branchName, address);
			
			notificationInterface.sendNotification(NotificationType.REGISTRATION, newStudentId, null,0);
			
		}
		catch(StudentNotRegisteredException ex)
		{
			logger.error("Something went wrong! "+ex.getStudentName() +" not registered. Please try again");
		}
		sc.close();
	}
	
	/**
	 * Method to update password of User
	 */
	public void updatePassword() {
		Scanner in = new Scanner(System.in);
		String userId,newPassword;
		try {
			logger.info("------------------Update Password--------------------");
			logger.info("Email");
			userId=in.next();
			logger.info("New Password:");
			newPassword=in.next();
			boolean isUpdated=userInterface.updatePassword(userId, newPassword);
			if(isUpdated)
				logger.info("Password updated successfully!");

			else
				logger.error("Something went wrong, please try again!");
		} catch(Exception ex) {
			logger.error("Error Occured "+ex.getMessage());
		}
		in.close();
	}
		
}
