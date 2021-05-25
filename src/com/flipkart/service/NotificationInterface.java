/**
 *
 */
package com.flipkart.service;


import java.util.UUID;

import com.flipkart.constant.NotificationType;
import com.flipkart.constant.PaymentMode;


/**
 * @author vijayrathod
 *
 */
public interface NotificationInterface {

    /**
     * Method to send notification
     * @param type: type of the notification to be sent
     * @param studentId: student to be notified
     * @param modeOfPayment: payment mode used
     * @return notification id for the record added in the database
     */


    public int sendNotification(NotificationType type,int studentId,PaymentMode modeOfPayment,double amount);


    /**
     * Method to return UUID for a transaction
     * @param notificationId: notification id added in the database
     * @return transaction id of the payment
     */
   // public UUID getReferenceId(int notificationId);


}