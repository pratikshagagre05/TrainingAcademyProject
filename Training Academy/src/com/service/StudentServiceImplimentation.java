package com.service;
import java.util.List;
import com.dao.StudentDao;
import com.dao.StudentDaoImplimentation;
import com.model.Student;

public class StudentServiceImplimentation implements StudentService
{
	StudentDao studentDao;
	public StudentServiceImplimentation()
	{
		studentDao=new StudentDaoImplimentation();
	}
	public StudentServiceImplimentation(StudentDao studentDao)
	{
		this.studentDao=studentDao;
	}

	public StudentDao getStudentDao()
	{
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao)
	{
		this.studentDao=studentDao;
	}
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudents();
	}
	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.addStudent(student);
	}
	@Override
	public int removeStudent(int studId) {
		// TODO Auto-generated method stub
		return studentDao.removeStudent(studId);
	}
	@Override
	public int updateRecord(int studId,String studName,long mobNo) {
		// TODO Auto-generated method stub
		return studentDao.updateRecord( studId,studName,mobNo);
	}
	@Override
	public void meritListTopFiveStudent(int batchid) {
		// TODO Auto-generated method stub
		studentDao.meritListTopFiveStudent(batchid);
		
	}
	@Override
	public void topFiveStudentFromAllBatches() {
		// TODO Auto-generated method stub
		studentDao.topFiveStudentFromAllBatches();
		
	}
	@Override
	public void topBatchAndTrainerr() {
		// TODO Auto-generated method stub
		studentDao.topBatchAndTrainerr();
		
	}
	
	
}
