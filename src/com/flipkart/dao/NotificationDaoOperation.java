/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.flipkart.constant.NotificationType;
import com.flipkart.constant.PaymentMode;
import com.flipkart.constant.SQLQueries;
import com.flipkart.utils.DBUtils;

/**
 * @author vijayrathod
 *
 */
public class NotificationDaoOperation implements NotificationDaoInterface{

	
	private static volatile NotificationDaoOperation instance=null;
	
	/**
	 * Default Constructor
	 */
	private NotificationDaoOperation()
	{

	}
	
	/**
	 * Method to make NotificationDaoOperation Singleton
	 * @return
	 */
	public static NotificationDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(NotificationDaoOperation.class){
				instance=new NotificationDaoOperation();
			}
		}
		return instance;
	}
	
	/**
	 * Send Notification using SQL commands
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @param modeOfPayment: mode of payment used, defined in enum
	 * @param amount
	 * @return notification id for the record added in the database
	 * @throws SQLException
	 */
	@Override
	public int sendNotification(NotificationType type, int studentId,PaymentMode modeOfPayment,double amount) throws SQLException{
		int notificationId=0;
		Connection connection=DBUtils.getConnection();
		try
		{
			//INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
			PreparedStatement ps = connection.prepareStatement(SQLQueries.INSERT_NOTIFICATION,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, studentId);
			ps.setString(2,type.toString());
			if(type==NotificationType.PAYED)
			{
				//insert into payment, get reference id and add here
				UUID referenceId=addPayment(studentId, modeOfPayment,amount);
				ps.setString(3, referenceId.toString());	
			}
			else
				ps.setString(3,"");
				
			ps.executeUpdate();
			ResultSet results=ps.getGeneratedKeys();
			if(results.next())
				notificationId=results.getInt(1);
			
			switch(type)
			{
			case REGISTRATION:
				System.out.println("Registration successfull. Administration will verify the details and approve it!");
				break;
			case APPROVED:
				System.out.println("Student with id "+studentId+" has been approved!");
				break;
			case PAYED:
				System.out.println("Student with id "+studentId+" fee has been paid");
			}
			
		}
		catch(SQLException ex)
		{
			throw ex;
		}
		return notificationId;
	}

	/**
	 * Perform Payment actions using SQL commands
	 * @param studentId: Id of the student for which the payment is done
	 * @param modeOfPayment: mode of payment used, defined in enum
	 * @param amount 
	 * @return: reference id of the transaction
	 * @throws SQLException
	 */
	public UUID addPayment(int studentId, PaymentMode modeOfPayment,double amount) throws SQLException
	{
		UUID referenceId;
		Connection connection=DBUtils.getConnection();
		try
		{
			referenceId=UUID.randomUUID();
			//INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
			PreparedStatement statement = connection.prepareStatement(SQLQueries.INSERT_PAYMENT);
			statement.setInt(1, studentId);
			statement.setString(2, modeOfPayment.toString());
			statement.setString(3,referenceId.toString());
			statement.setDouble(4, amount);
			statement.executeUpdate();
			//check if record is added
		}
		catch(SQLException ex)
		{
			throw ex;
		}
		return referenceId;
	}
	
}
