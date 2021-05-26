/**
 * 
 */
package com.flipkart.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;

/**
 * @author vijayrathod
 *
 */
public class RegistrationDaoOperation implements RegistrationDaoInterface {

	private static volatile RegistrationDaoOperation instance=null;
	private PreparedStatement stmt = null;
	
	/**
	 * Default Constructor
	 */
	private RegistrationDaoOperation() 
	{}
	
	/**
	 * Method to make RegistrationDaoOperation Singleton
	 * @return
	 */
	public static RegistrationDaoOperation getInstance()
	{
		if(instance==null)
		{
			synchronized(RegistrationDaoOperation.class){
				instance=new RegistrationDaoOperation();
			}
		}
		return instance;
	}
	
	
	@Override
	public boolean addCourse(String courseCode, int studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dropCourse(String courseCode, int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> viewCourses(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeCard> viewGradeCard(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateFee(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean seatAvailable(String courseCode) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numOfRegisteredCourses(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isRegistered(String courseCode, int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRegistrationStatus(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRegistrationStatus(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	
}
