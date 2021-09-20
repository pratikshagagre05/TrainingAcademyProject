package com.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//import com.dao.StudentDaoImplimentation;
import com.dao.*;
import com.model.*;
//import com.model.Result;
//import com.model.Student;
import com.service.*;
//import com.service.StudentService;
//import com.service.StudentServiceImplimentation;

public class Client {
	public static void main(String[] args)
	{
		String str;
		StudentService studentService= new StudentServiceImplimentation();
		ResultService resultService=new ResultServiceImplimentation();
		
		do
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Student Details"+"\t\t"+"2.Add Students"+"\n"+"3.Delete Record"+"\t\t"+"4.Update Student Record."+"\n5.Add Result");
		System.out.println("\nEnter Choice:");
		int choice=sc.nextInt();
		//StudentDaoImplimentation studentDaoImplimentation=new StudentDaoImplimentation();
		//StudentService studentService= new StudentServiceImplimentation(studentDaoImplimentation);
		//StudentService studentService= new StudentServiceImplimentation();
		//ResultService resultService=new ResultServiceImplimentation();
		
		List<Student> studentList=studentService.getAllStudents();
		Iterator<Student> itr=studentList.iterator();
		switch(choice)
		{
		case 1:
		System.out.println("**********All Student Datails*************");
		
		while (itr.hasNext()) {
			Student student = (Student) itr.next();
			System.out.println("Student Id:- "+ student.getStudId());
			System.out.println("Student Name:- "+ student.getStudName());
			System.out.println("MobileNo:- "+ student.getMobNo());
			System.out.println("Gmail Id:- "+student.getGmail());
			System.out.println("Batch No:- "+ student.getBatchId());
			
			System.out.println("**************************************");
			
		}
		break;
		case 2:
		System.out.println(" ");
		System.out.println("******* Enter Student information ************");
		System.out.println("Enter Student Id:- ");
		int studId=sc.nextInt();
		System.out.println("Enter Student Name:- ");
		String studName=sc.next();
		System.out.println("Enter Mobile No:- ");
		long mobNo=sc.nextLong();
		System.out.println("Enter Gmail:- ");
		String gmail=sc.next();
		System.out.println("Enter Batch id:- ");
		int batchId=sc.nextInt();
		
		
		Student student=new Student(studId, studName, mobNo, gmail, batchId);
		int status=studentService.addStudent(student);
		if(status>0) {
			System.out.println("Student added successfully.......");
		}
		else
		{
			System.out.println("Unable to add student.......");
		}
		break;
		
		case 3:
			System.out.println("Enter record number to delete :");
			int studid=sc.nextInt();
			studentService.removeStudent(studid);
			break;
		
		
		  case 4:
			  System.out.println("Enter record number to update :");
		     int studid1 =sc.nextInt(); 
		     System.out.println("Enter student updated name  :");
		     String studname1=sc.next();
		     System.out.println("Enter students updated mobile no  :");
		     long mobno1=sc.nextLong();
		     studentService.updateRecord(studid1,studname1,mobno1);
		     break;
		 
		  case 5:
			  System.out.println(" ");
				System.out.println("******* Enter Student Marks ************");
				System.out.println("Enter Student Id:- ");
				int studId1=sc.nextInt();
				System.out.println("Enter test 1 marks :- ");
				int test1=sc.nextInt();
				System.out.println("Enter test 2 marks :- ");
				int test2=sc.nextInt();
				System.out.println("Enter test 3 marks:- ");
				int test3=sc.nextInt();
				int totalMarks=test1+test2+test3;
				System.out.println("Total marks obtained :- "+totalMarks);
				int percent=(int)((totalMarks*100)/150);
				System.out.println("Enter percentage :- "+percent);
				
				
				
				Result result=new Result(studId1,test1,test2,test3,totalMarks, percent);
				int status1=resultService.addMarks(result);
				if(status1>0) {
					System.out.println("Result added successfully.......");
				}
				else
				{
					System.out.println("Unable to add Result.......");
				}
				break;
		}
		System.out.println();
			System.out.println("Do you wish to continue(y/n) ? ");
			str=sc.next();
		}while(str.equals("y")||str.equals("Y"));
		
	}

}
