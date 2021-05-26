/**
 * 
 */
package com.flipkart.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.GradeNotAllotedException;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.validator.ProfessorValidator;


/**
 * @author vivek
 *
 */
public class ProfessorCRSMenu {
	
	private static Logger logger = Logger.getLogger(ProfessorCRSMenu.class);
	ProfessorInterface professorInterface = ProfessorOperation.getInstance();

	/**
	 * @param profID
	 */
	public void createMenu(String profID) {
		Scanner in = new Scanner(System.in);
		
		int input;
		while (CRSApplication.loggedin) {
			logger.info("--------------------------------");
			logger.info("-------Professor Menu-----------");
			logger.info("--------------------------------");
			logger.info("1. view Courses");
			logger.info("2. view Enrolled Students");
			logger.info("3. add Grades");
			logger.info("4. logout");
			logger.info("--------------------------------");
			System.out.printf("Choose From Menu: ");
			
			input = in.nextInt();
			switch (input) {
			case 1:
				getCourses(profID);
				break;
			case 2:
				viewEnrolledStudents(profID);
				break;
			case 3:
				addGrade(profID);
				break;
			case 4:
				CRSApplication.loggedin = false;
				return;
			default:
				logger.warn("Please select appropriate option...");
			}
		}
		in.close();
	}
	
	public void viewEnrolledStudents(String profID) {
		logger.info(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Student" ));
		try {
			List<EnrolledStudent> enrolledStudents = new ArrayList<EnrolledStudent>();
			enrolledStudents = professorInterface.viewEnrolledStudents(profID);
			for (EnrolledStudent obj: enrolledStudents) {
				logger.info(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
			}
			
		} catch(Exception ex) {
			logger.error(ex.getMessage()+"Something went wrong, please try again later!");
		}
	}
	
	public void getCourses(String profId) {
		try {
			List<Course> coursesEnrolled = professorInterface.viewCourses(profId);
			logger.info(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","No. of Students" ));
			for(Course obj: coursesEnrolled) {
				logger.info(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),10- obj.getSeats()));
			}		
		} catch(Exception ex) {
			logger.error("Something went wrong!"+ex.getMessage());
		}
	}
	
	public void addGrade(String profId) {	
		Scanner in = new Scanner(System.in);
		
		String courseCode, grade, studentId;
		try {
			List<EnrolledStudent> enrolledStudents = new ArrayList<EnrolledStudent>();
			enrolledStudents = professorInterface.viewEnrolledStudents(profId);
			logger.info(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Student ID" ));
			for (EnrolledStudent obj: enrolledStudents) {
				logger.info(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
			}
			List<Course> coursesEnrolled = new ArrayList<Course>();
			coursesEnrolled	= professorInterface.viewCourses(profId);
			logger.info("----------------Add Grade--------------");
			System.out.printf("Enter student id: ");
			studentId = in.nextLine();
			System.out.printf("Enter course code: ");
			courseCode = in.nextLine();
			logger.info("Enter grade: ");
			grade = in.nextLine();
			if (!(ProfessorValidator.isValidStudent(enrolledStudents, studentId)
			&& ProfessorValidator.isValidCourse(coursesEnrolled, courseCode))) {
				professorInterface.addGrade(studentId, courseCode, grade);
				logger.info("Grade added successfully for "+studentId);
			} else {
				logger.info("Invalid data entered, try again!");
			}
		} catch(GradeNotAllotedException ex) {
			logger.error("Grade cannot be added for"+ex.getStudentId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Grade not added, SQL exception occured "+e.getMessage());
		}
		
	}

}
