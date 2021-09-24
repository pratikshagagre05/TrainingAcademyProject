
package com.controller;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
//import com.configuration.ConnectionFactory;
//import com.dao.StudentDaoImplimentation;
//import com.dao.*;
import com.model.*;
//import com.model.Result;
//import com.model.Student;
import com.service.*;

public class Client {


	public static void main(String[] args) {
		String str;
		StudentService studentService = new StudentServiceImplimentation();
		ResultService resultService = new ResultServiceImplimentation();
		System.out.println();
		System.out.println("***************** TQ Training Academy *****************");

		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("\t1.Student Details" + "\t\t" + "2.Add Students" + "\n\t" + "3.Delete Record" + "\t\t"
					+ "\t4.Update Student Record." + "\n\t5.Add Result" + "\t\t" + "\t6.Dlete Result"
					+ "\n\t7.Update Student Marks" + "\t\t8.Tooppers"+"\n\t9.Toppers from all Batches"+"\t10.Best batch and trainer"+"\n\t11."
							+ "Worst batch ");
			System.out.println("\nEnter Choice:");
			int choice = sc.nextInt();
			List<Student> studentList = studentService.getAllStudents();
			Iterator<Student> itr = studentList.iterator();
			switch (choice) {
			case 1:
				System.out.println("************* All Student Datails *************"); 

				while (itr.hasNext()) {
					Student student = (Student) itr.next();
					System.out.println("Student Id:- " + student.getStudId());
					System.out.println("Student Name:- " + student.getStudName());
					System.out.println("MobileNo:- " + student.getMobNo());
					System.out.println("Gmail Id:- " + student.getGmail());
					System.out.println("Batch No:- " + student.getBatchId());

					System.out.println("**************************************");

				}
				break;
			case 2:
				System.out.println(" ");
				System.out.println("************* Enter Student information ************");
				System.out.println("Enter Student Id:- ");
				int studId = sc.nextInt();
				System.out.println("Enter Student Name:- ");
				String studName = sc.next();
				System.out.println("Enter Mobile No:- ");
				long mobNo = sc.nextLong();
				System.out.println("Enter Gmail:- ");
				String gmail = sc.next();
				System.out.println("Enter Batch id:- ");
				int batchId = sc.nextInt();

				Student student = new Student(studId, studName, mobNo, gmail, batchId);

				String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
						+ "A-Z]{2,7}$";

				Pattern pat = Pattern.compile(emailRegex);

				if (pat.matcher(gmail).matches() && String.valueOf(mobNo).length() == 10) {
					// Student student=new Student(studId, studName, mobNo, gmail, batchId);
					int status = studentService.addStudent(student);
					if (status > 0) {
						System.out.println("Student added successfully.......");
					} else {
						System.out.println("Unable to add student.......");
					}
				} else {
					System.out.println("Gmail or Mobile number is not valid");
				}
				break;

			case 3:
				System.out.println("Enter record number to delete :");
				int studid = sc.nextInt();
				studentService.removeStudent(studid);
				break;

			case 4:
				System.out.println("Enter record number to update :");
				int studid1 = sc.nextInt();
				System.out.println("Enter student name to update  :"); 
				String studname1 = sc.next();
				System.out.println("Enter students  mobile no to update :");
				long mobno1 = sc.nextLong();
				int status = studentService.updateRecord(studid1, studname1, mobno1);
				if (status > 0) {
					System.out.println("Student updated successfully ......");
				} else
					System.out.println("Unable to update......");
				break;

			case 5:
				System.out.println(" ");
				System.out.println("************* Enter Student Marks ************");

				System.out.println("Enter Result Id:- ");
				int resultId = sc.nextInt();
				System.out.println("Enter Student Id:- ");
				int studId1 = sc.nextInt();
				System.out.println("Enter test 1 marks :- ");
				int test1 = sc.nextInt();
				System.out.println("Enter test 2 marks :- ");
				int test2 = sc.nextInt();
				System.out.println("Enter test 3 marks:- ");
				int test3 = sc.nextInt();
				int totalMarks = test1 + test2 + test3;
				System.out.println("Total marks obtained :- " + totalMarks);
				float percent = ((totalMarks * 100) / 150);
				System.out.println("Enter percentage :- " + percent);

				Result result = new Result(resultId, studId1, test1, test2, test3, totalMarks, percent);
				if (test1 >= 51 || test2 >= 51 || test3 >= 51) {
					System.out.println("All Marks must be out of 50 ");
				} else {
					int status1 = resultService.addMarks(result);
					if (status1 > 0) {
						System.out.println("Result added successfully.......");
					} else {
						System.out.println("Unable to add Result.......");
					}
				}
				break;

			case 6:

				System.out.println("Enter result id to delete :");
				int resultd = sc.nextInt();
				resultService.removeResult(resultd);
				break;
				
			case 7:
				System.out.println("Enter result id to update marks :");
				int resultId1 = sc.nextInt();
				System.out.println("Enter test1 marks  :");
				int test11 = sc.nextInt();
				System.out.println("Enter test2 marks  :");
				int test22 = sc.nextInt();
				System.out.println("Enter test3 marks  :");
				int test33 = sc.nextInt();
				int totalMarks1 = test11 + test22 + test33;
				float percent1 = ((totalMarks1 * 100) / 150);

				int status1=resultService.updateResult(resultId1, test11, test22, test33, totalMarks1, percent1);
				if(status1>0)
				{
					System.out.println("Result updated successfully.....");
					
				}
				else
				{
					System.out.println("Result not updated.....");
				}
				break;

			case 8:
				System.out.println("Enter batch Id :");
				int batchid = sc.nextInt();
				studentService. meritListTopFiveStudent( batchid);
				break;
				
			case 9: 
				studentService.topFiveStudentFromAllBatches();
			    break;
			    
			case 10:
				System.out.println("The Best Batch And Trainer.......");
				System.out.println();
				studentService.topBatchAndTrainerr();
				break;
				
			case 11:
				System.out.println("Worst Batch........");
				System.out.println();
				studentService.worstBatch();
			
			}

			System.out.println();
			System.out.println("Do you wish to continue(y/n) ? ");
			str = sc.next();
		} while (str.equals("y") || str.equals("Y"));

	}

}
