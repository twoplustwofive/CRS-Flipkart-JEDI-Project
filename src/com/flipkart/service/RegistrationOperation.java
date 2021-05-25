/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.exception.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;

/**
 * @author Aditya
 *
 */
public class RegistrationOperation implements RegistrationInterface 
{

	@Override
	public boolean addCourse(String crsCode, int stdID, List<Course> courseCart) 
	{
		Course crs = new Course();
		
		/*
		 * Fetch from the DATABASE
		 * 
		 * */
		
		
		courseCart.add(crs);
		
		return true;
	}

	@Override
	public boolean dropCourse(String crsCode, int stdId, List<Course> courseCart) throws CourseNotFoundException
	{
		
		try
		{	
			for(Course i : courseCart)
			{ 
				if(i.getCourseCode() == crsCode)
					courseCart.remove(i);
			}
		}
		
		catch(CourseNotFoundException e)
		{
			throw e;
		}
		
		
		return false;
	}

	@Override
	public List<Course> viewCourses(int stdId) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> viewRegisteredCourses(int stdId) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grade> viewGradeCard(int stdId) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateFee(int stdId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getRegistrationStatus(int stdId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRegistrationStatus(int stdId) {
		// TODO Auto-generated method stub
		
	}

}
