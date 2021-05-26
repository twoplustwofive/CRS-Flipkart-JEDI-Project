/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.constant.Grade;
import com.flipkart.constant.SQLQueries;
import com.flipkart.utils.DBUtils;

/**
 * @author vivek
 *
 */
public class GradeCardDaoOperation implements GradeCardDaoInterface {
	
	private static volatile GradeCardDaoOperation instance = null;
	private static Logger logger = Logger.getLogger(AdminDaoOperation.class);
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
		
		case grade.:
			return 10;
		case Grade.B:
			return 8;
		case Grade.C:
			return 6;
		case Grade.D:
			return 4;
		case Grade.E:
			return 2;
		case Grade.F:
			return 0;
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
			logger.error(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
		}
		if (count == 0) return 0;
		return grade / (float)count;
	}

}
