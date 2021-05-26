/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.RegisteredCourse;

/**
 * @author vivek
 *
 */
public interface GradeCardDaoInterface {
	
	public float calculateCGPA(int studentID);

	public boolean addRegisteredCourse(RegisteredCourse regCourse);

}
