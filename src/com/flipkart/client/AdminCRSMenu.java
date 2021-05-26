/**
 * 
 */
package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.constant.Gender;
import com.flipkart.constant.NotificationType;
import com.flipkart.constant.Role;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.NotificationInterface;
import com.flipkart.service.NotificationOperation;

/**
 * @author Goenka
 *
 */
public class AdminCRSMenu {

	private static Logger logger = Logger.getLogger(AdminCRSMenu.class);

	AdminInterface adminOperation = AdminOperation.getInstance();
	Scanner in = new Scanner(System.in);
	NotificationInterface notificationInterface=NotificationOperation.getInstance();
	
	/**
	 * Method to Create Admin Menu
	 */
	public void createMenu(){
		
		while(CRSApplication.loggedin) {
			logger.info("*****************************");
			logger.info("**********Admin Menu*********");
			logger.info("*****************************");
			logger.info("1. View course in catalog");
			logger.info("2. Add Course to catalog");
			logger.info("3. Delete Course from catalog");
			logger.info("4. Approve Students");
			logger.info("5. View Pending Approvals");
			logger.info("6. Add Professor");
			logger.info("7. Assign Professor To Courses");
			logger.info("8. Generate Report Card");
			logger.info("9. Logout");
			logger.info("*****************************");
			
			
			int choice = in.nextInt();
			
			switch(choice) {
			case 1:
				viewCoursesInCatalogue();
				break;
				
			case 2:
				addCourseToCatalogue();
				break;
				
			case 3:
				removeCourse();
				break;
				
			case 4:
				approveStudent();
				break;
			
			case 5:
				viewPendingAdmissions();
				break;
			
			case 6:
				addProfessor();
				break;
			
			case 7:
				assignCourseToProfessor();
				break;
				
			case 8:
				generateReportCard();
				break;
			
			case 9:
				CRSApplication.loggedin = false;
				return;

			default:
				logger.warn("***** Wrong Choice *****");
			}
		}
	}
	
	private void generateReportCard() 
	{
		
		System.out.print("Enter The StudentId for generating report card : ");
		String studentId = in.next(); 
		List<RegisteredCourse> CoursesOfStudent = adminOperation.generateGradeCard(studentId);
		logger.info("*************************** Report Card *************************** ");
		logger.info("***************************" + studentId + "*************************** ");
		
		logger.info(String.format("%20s | %20s | %20s ", "CourseCode", "CourseName", "Grade"));
		for(RegisteredCourse obj : CoursesOfStudent) {
			logger.info(String.format("%20s | %20s | %20s ", obj.getCourse().getCourseCode(), obj.getCourse().getCourseName(), obj.getGrade()));	
		}
		logger.info("**********************************************************************");
	}

	/**
	 * Method to assign Course to a Professor
	 */
	private void assignCourseToProfessor() {
		List<Professor> professorList= adminOperation.viewProfessors();
		logger.info("*************************** Professor *************************** ");
		logger.info(String.format("%20s | %20s | %20s ", "ProfessorId", "Name", "Designation"));
		for(Professor professor : professorList) {
			logger.info(String.format("%20s | %20s | %20s ", professor.getUserId(), professor.getName(), professor.getDesignation()));
		}
		
		
		logger.info("\n\n");
		List<Course> courseList= adminOperation.viewCourses();
		logger.info("**************** Course ****************");
		logger.info(String.format("%20s | %20s", "CourseCode", "CourseName"));
		for(Course course : courseList) {
			logger.info(String.format("%20s | %20s ", course.getCourseCode(), course.getCourseName()));
		}
		
		logger.info("Enter Course Code:");
		String courseCode = in.next();
		
		logger.info("Enter Professor's User Id:");
		String userId = in.next();
		
		try {
			
			adminOperation.assignCourse(courseCode, userId);
		
		}
		catch(CourseNotFoundException | UserNotFoundException  e) {
			
			logger.error(e.getMessage());
		}
		
	}

	/**
	 * Method to add Professor to DB
	 */
	private void addProfessor() {
		
		logger.info("Enter User Id(integer):");
		String userId = in.next();
		Professor professor = new Professor(userId);
		
		logger.info("Enter Professor Name:");
		String professorName = in.next();
		professor.setName(professorName);
		
		logger.info("Enter Department:");
		String department = in.next();
		professor.setDepartment(department);
		
		logger.info("Enter Designation:");
		String designation = in.next();
		professor.setDesignation(designation);
		
		logger.info("Enter Password:");
		String password = in.next();
		professor.setPassword(password);
		
		logger.info("Enter Gender: \t 1: Male \t 2.Female \t 3.Other ");
		int gender = in.nextInt();
		
		if(gender==1)
			professor.setGender(Gender.MALE);
		else if(gender==2)
			professor.setGender(Gender.FEMALE);
		else if(gender==3)
			professor.setGender(Gender.OTHER);
		
		logger.info("Enter Address:");
		String address = in.next();
		professor.setAddress(address);
		
		professor.setRole(Role.PROFESSOR);
		
		try {
			adminOperation.addProfessor(professor);
		} catch (ProfessorNotAddedException | UserIdAlreadyInUseException e) {
			logger.error(e.getMessage());
		}

	}

	/**
	 * Method to view Students who are yet to be approved
	 * @return List of Students whose admissions are pending
	 */
	private List<Student> viewPendingAdmissions() {
		
		List<Student> pendingStudentsList= adminOperation.viewPendingAdmissions();
		if(pendingStudentsList.size() == 0) {
			return pendingStudentsList;
		}
		logger.info(String.format("%20s | %20s | %20s", "StudentId", "Name", "Gender"));
		for(Student student : pendingStudentsList) {
			logger.info(String.format("%20s | %20s | %20s", student.getStudentId(), student.getName(), student.getGender().toString()));
		}
		return pendingStudentsList;
	}

	/**
	 * Method to approve a Student using Student's ID
	 */
	private void approveStudent() {
		
		List<Student> studentList = viewPendingAdmissions();
		if(studentList.size() == 0) {
			return;
		}
		
		logger.info("Enter Student's ID:");
		String studentUserIdApproval = in.next();
		
		
		try {
			adminOperation.approveStudent(studentUserIdApproval, studentList);
			//send notification from system
			notificationInterface.sendNotification(NotificationType.REGISTRATION, studentUserIdApproval, null,0);
	
		} catch (StudentNotFoundForApprovalException e) {
			logger.error(e.getMessage());
		}
	
		
	}

	/**
	 * Method to delete Course from catalogue
	 * @throws CourseNotFoundException 
	 */
	private void removeCourse() {
		List<Course> courseList = viewCoursesInCatalogue();
		logger.info("Enter Course Code:");
		String courseCode = in.next();
		
		try {
			adminOperation.removeCourse(courseCode, courseList);
		} catch (CourseNotFoundException e) {
			
			logger.error(e.getMessage());
		}
		catch (CourseNotDeletedException e) {
			
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * Method to add Course to catalogue
	 * @throws CourseExistsAlreadyException 
	 */
	private void addCourseToCatalogue() {
		List<Course> courseList = viewCoursesInCatalogue();

		in.nextLine();
		logger.info("Enter Course Code:");
		String courseCode = in.nextLine();
		
		logger.info("Enter Course Name:");
		String courseName = in.next();
		
		Course course = new Course(courseCode, courseName,"", 10);
		course.setCourseCode(courseCode);
		course.setCourseName(courseName);
		course.setSeats(10);
		
		try {
		adminOperation.addCourse(course, courseList);		
		}
		catch (CourseExistsAlreadyException e) {
			logger.error("Course already existed "+e.getMessage());
		}

	}
	
	/**
	 * Method to display courses in catalogue
	 * @return List of courses in catalogue
	 */
	private List<Course> viewCoursesInCatalogue() {
		List<Course> courseList = adminOperation.viewCourses();
		if(courseList.size() == 0) {
			logger.info("Nothing present in the catalogue!");
			return courseList;
		}
		logger.info(String.format("%20s | %20s | %20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
		for(Course course : courseList) {
			logger.info(String.format("%20s | %20s | %20s", course.getCourseCode(), course.getCourseName(), course.getInstructorId()));
		}
		return courseList;
	}
}
