package com.flipkart.service;

import com.flipkart.bean.SemRegistration;
import com.flipkart.constant.Role;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.StudentNotRegisteredException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.service.*;

public class StudentOperation implements StudentInterface {

	private static volatile StudentOperation instance=null;
	StudentDaoInterface studentDaoInterface=StudentDaoOperation.getInstance();

	
	private StudentOperation()
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
	public int register(String name,String userId,String password,Gender gender,int batch,String branch,String address,String country) throws StudentNotRegisteredException{
		int studentId;
		try
		{
			//call the DAO class, and add the student record to the DB
			Student newStudent=new Student(userId,name,Role.STUDENT,password,gender,address,country,branch,0,batch,false);
			studentId=studentDaoInterface.addStudent(newStudent);
			
		}
		catch(StudentNotRegisteredException ex)
		{
			throw ex;
		}
		return studentId;
	}


    /**
     * Method to get Student ID from User ID
     * @param userId
     * @return Student ID
     */
    @Override
    public String getStudentId(String userId) {
        // TODO Auto-generated method stub
        return StudentDaoInterface.getStudentId(userId);
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