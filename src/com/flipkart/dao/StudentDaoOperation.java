/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueries;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.utils.DBUtils;

/**
 * 
 * @author Aditya
 * Class to implement Student Dao Operations
 *
 */
public class StudentDaoOperation implements StudentDaoInterface {
	
	private static volatile StudentDaoOperation instance=null;
	
	/**
	 * Default Constructor
	 */
	private StudentDaoOperation()
	{
		
	}
	
	/**
	 * Method to make StudentDaoOperation Singleton
	 * @return
	 */
	public static StudentDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentDaoOperation.class){
				instance=new StudentDaoOperation();
			}
		}
		return instance;
	}

	/**
	 * Method to add student to database
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 */
	@Override
	public String addStudent(Student student) throws StudentNotRegisteredException{
		Connection connection=DBUtils.getConnection();
		String studentId=null;
		try
		{
			//open db connection
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueries.ADD_USER_QUERY);
			preparedStatement.setString(1, student.getUserId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getPassword());
			preparedStatement.setString(4, student.getRole().toString());
			preparedStatement.setString(5, student.getGender().toString());
			preparedStatement.setString(6, student.getAddress());
			
			int rowsAffected=preparedStatement.executeUpdate();
			if(rowsAffected==1)
			{
				//add the student record
				//"insert into student (userId,branchName,batch,isApproved) values (?,?,?,?)";
				PreparedStatement preparedStatementStudent;
				preparedStatementStudent=connection.prepareStatement(SQLQueries.ADD_STUDENT,Statement.RETURN_GENERATED_KEYS);
				preparedStatementStudent.setString(1,student.getUserId());
				preparedStatementStudent.setString(2, student.getDepartment());
				preparedStatementStudent.setInt(3, student.getGradYear());
				preparedStatementStudent.setBoolean(4, false);
				preparedStatementStudent.executeUpdate();
				ResultSet results=preparedStatementStudent.getGeneratedKeys();
				if(results.next())
					studentId=results.getString(1);
			}
			
			
		}
		catch(Exception ex)
		{
			throw new StudentNotRegisteredException(student.getName());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"SQL error");
				e.printStackTrace();
			}
		}
		return studentId;
	}
	
	/**
	 * Method to retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 */
	@Override
	public String getStudentId(String userId) {
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueries.GET_STUDENT_ID);
			statement.setString(1, userId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getString("studentId");
			}
				
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	/**
	 * Method to check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	@Override
	public boolean isApproved(String studentId) {
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueries.IS_APPROVED);
			statement.setString(1, studentId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getBoolean("isApproved");
			}
				
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return false;
	}

}