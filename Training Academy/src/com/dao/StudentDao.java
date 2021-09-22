package com.dao;

import java.util.List;
import com.model.Student;

public interface StudentDao 
{
	List<Student> getAllStudents();
	int addStudent(Student student);
	int removeStudent(int studId);
	int updateRecord(int studId,String studName,long mobNo);
	void meritListTopFiveStudent(int batchid);
	void topFiveStudentFromAllBatches();
	void topBatchAndTrainerr();
}
