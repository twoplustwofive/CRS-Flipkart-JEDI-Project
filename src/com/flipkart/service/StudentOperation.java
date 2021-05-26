package com.flipkart.service;

import com.flipkart.bean.SemRegistration;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.service.*;

public class StudentOperation implements StudentInterface {

	private static volatile StudentOperation instance=null;
	StudentDaoInterface studentDaoInterface=StudentDaoOperation.getInstance();

	
	public StudentOperation()
	{
		
	}
	
	/**
	 * Method to make StudentOperation Singleton
	 * @return
	 */
	public static StudentOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentOperation.class){
				instance=new StudentOperation();
			}
		}
		return instance;
	}
	
    /**
     * Method to register a student, although student can't login until it's approved by admin
     * @param name
     * @param userID
     * @param password
     * @param gender
     * @param batch
     * @param branch
     * @param address
     * @param country
     * @return Student ID
     * @throws StudentNotRegisteredException
     */
    @Override
    public int register() 
    {	
    	
    	//
    	
    	SemRegistration semReg = new SemRegistration();
    	
    	RegistrationOperation Rop = new RegistrationOperation();
    	
    	List<Course> regCrs = new ArrayList<Course>();
    	
    	int t = 1;
    	Scanner in = new Scanner(System.in);
    	while(t)
    	{
    		int choice;
    		System.out.println("Please enter your op: ");
        	choice = in.nextInt();
        	
        	switch(choice)
        	{
		    	case 1:
					Rop.addCourse(,,regCrs);
					break;
					
				case 2:
					dropCourse(studentId);
					break;
					
				case 3:
					viewCourse(studentId);
					break;
					
				case 4:
					viewRegisteredCourse(studentId);
					break;
        	}
        	
    	}
    	
    	
    	
    	
    	
    	
        return 0;
    }


    /**
     * Method to get Student ID from User ID
     * @param userId
     * @return Student ID
     */
    @Override
    public String getStudentId(String userId) {
        // TODO Auto-generated method stub
        return studentDaoInterface.getStudentId(userId);
;
    }


    /**
     * Method to check if student is approved by Admin or not
     * @param studentId
     * @return boolean indicating if student is approved
     */
    @Override
    public boolean isApproved(int studentId) {
        // TODO Auto-generated method stub
		return studentDaoInterface.isApproved(studentId);
    }

}