package com.flipkart.bean;

import java.util.Date;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Admin extends User
{
		public Admin(int userID, String name, Gender gender, Role role, String password, String address) 
		{
			super(userID, name, gender, role, password, address);
		}	

		private Date dateOfJoining;
		public Date getDateOfJoining() 
		{
			return dateOfJoining;
		}

		/**
		 * Method to set Date of joining
		 * @param dateOfJoining
		 */
		public void setDateOfJoining(Date dateOfJoining) 
		{
			this.dateOfJoining = dateOfJoining;
		}
}
