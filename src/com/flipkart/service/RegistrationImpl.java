/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;

/**
 * @author Aditya
 *
 */
public class RegistrationImpl implements RegistrationInterface 
{

	@Override
	public boolean addCourse(String crsCode, int stdID, List<Course> courseList) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dropCourse(String crsCode, int stdId, List<Course> registeredCrsList) 
	{
		// TODO Auto-generated method stub
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
