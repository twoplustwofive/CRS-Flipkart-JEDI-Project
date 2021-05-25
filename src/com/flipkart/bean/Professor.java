/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * @author vivek
 *
 */
public class Professor extends User {
	private String professorID;
	private String department;
	private String designation;
	private Date dateOfJoining;
	
	public Professor(int userID) {
		super(userID);
	}
	public Professor(int userID, String name, Gender gender, Role role, String password, String address) {
		super(userID, name, gender, role, password, address);
	}
	/**
	 * @return the professorID
	 */
	public String getProfessorID() {
		return professorID;
	}
	/**
	 * @param professorID the professorID to set
	 */
	public void setProfessorID(String professorID) {
		this.professorID = professorID;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
