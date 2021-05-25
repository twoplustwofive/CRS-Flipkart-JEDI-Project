package com.flipkart.service;

public class StudentImpl implements StudentInterface {



    /**
     * Method to register a student, although student can't login until it's approved by admin
     * @param name
     * @param userID
     * @param password
     * @param gender
     * @param batch
     * @param branch
     * @param address
     * @param country
     * @return Student ID
     * @throws StudentNotRegisteredException
     */
    @Override
    public int register(String name, String userID, String password, int batch, String address, String country) {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * Method to get Student ID from User ID
     * @param userId
     * @return Student ID
     */
    @Override
    public int getStudentId(String userId) {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * Method to check if student is approved by Admin or not
     * @param studentId
     * @return boolean indicating if student is approved
     */
    @Override
    public boolean isApproved(int studentId) {
        // TODO Auto-generated method stub
        return false;
    }

}