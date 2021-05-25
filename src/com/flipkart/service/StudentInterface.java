/**
 *
 */
package com.flipkart.service;

/**
 * @author vijayrathod
 *
 */
public interface StudentInterface {


    /**
     * Method to register a student, although student can't login until it's approved by admin
     * @param name
     * @param userID
     * @param password
     * @param batch
     * @param branch
     * @param address
     * @param country
     * @return Student ID
     * @throws StudentNotRegisteredException
     */
    public int register(String name, String userID, String password, int batch, String address, String country);

    /**
     * Method to get Student ID from User ID
     * @param userId
     * @return Student ID
     */
    public int getStudentId(String userId);

    /**
     * Method to check if student is approved by Admin or not
     * @param studentId
     * @return boolean indicating if student is approved
     */
    public boolean isApproved(int studentId);

}