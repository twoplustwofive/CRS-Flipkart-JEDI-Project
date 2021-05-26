/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.RegisteredCourse;
import com.flipkart.constant.SQLQueries;
import com.flipkart.utils.DBUtils;

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
	
	private float grade2float(String grade) {
		switch (grade) {
		case "A":
		case "A*":
		case "a":
		case "a*":
			return 10;
		case "B":
		case "b":
			return 8;
		case "C":
		case "c":
			return 6;
		case "D":
		case "d":
			return 4;
		case "E":
		case "e":
			return 2;
		default:
			return 0;
		}
	}

	@Override
	public float calculateCGPA(int studentID) {
		Connection connection = DBUtils.getConnection();
		float grade = 0;
		int count = 0;
		try {
			statement = connection.prepareStatement(SQLQueries.GET_GRADES);
			statement.setInt(1, studentID);
			
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				grade += grade2float(results.getString("grade"));
				count++;
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (count == 0) return 0;
		return grade / (float)count;
	}

}
