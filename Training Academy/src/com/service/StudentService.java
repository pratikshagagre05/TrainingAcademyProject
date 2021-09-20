package com.service;
import com.model.Student;
import java.util.List;

public interface StudentService
{
	List<Student> getAllStudents();
	int addStudent(Student student);
	int removeStudent(int recNo);
	int updateRecord(int studId,String studName,long mobNo);

}
