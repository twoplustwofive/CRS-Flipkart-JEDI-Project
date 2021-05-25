/**
 * 
 */
package com.flipkart.service;

import com.flipkart.constant.NotificationType;
import com.flipkart.constant.PaymentMode;

/**
 * @author vijayrathod
 *
 */
public class NotificationOperation implements NotificationInterface{
	
	/**
	 * Method to send notification
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @param modeOfPayment: payment mode used
	 * @return notification id for the record added in the database
	 */
	@Override
	public int sendNotification(NotificationType type, int studentId,PaymentMode modeOfPayment,double amount) {
		return 0;
		
	}
	
	/**
	 * Method to return UUID for a transaction
	 * @param notificationId: notification id added in the database
	 * @return transaction id of the payment
	 */
	
	
	
}