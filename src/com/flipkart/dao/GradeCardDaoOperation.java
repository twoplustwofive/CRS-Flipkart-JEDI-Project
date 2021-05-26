/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.RegisteredCourse;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author vivek
 *
 */
public class GradeCardDaoOperation implements GradeCardDaoInterface {
	
	private static volatile GradeCardDaoOperation instance = null;
	
	private PreparedStatement statement = null;
	
	/**
	 * Default Constructor
	 */
	private GradeCardDaoOperation() {}
	
	/**
	 * Method to make GradeCardDaoOperation Singleton
	 * @return
	 */
	public static GradeCardDaoOperation getInstance() {
		if(instance == null) {
			synchronized(GradeCardDaoOperation.class) {
				instance = new GradeCardDaoOperation();
			}
		}
		return instance;
	}

	@Override
	public float calculateCGPA(int studentID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addRegisteredCourse(RegisteredCourse regCourse) {
		// TODO Auto-generated method stub
		return false;
	}

}
