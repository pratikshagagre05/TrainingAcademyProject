package com.dao;

import java.util.ArrayList;
import com.model.Student;
import java.util.List;
import com.configuration.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImplimentation implements StudentDao
{
	ConnectionFactory ConnectionFactory;
	public StudentDaoImplimentation()
	{
		ConnectionFactory=new ConnectionFactory();
	}
	ArrayList<Student> studentList = new ArrayList<>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;


	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		/*
		 * ArrayList<Student> studentList = new ArrayList<>(); Connection connection =
		 * null; PreparedStatement preparedStatement = null; ResultSet resultSet = null;
		 */			final String QUERY = "select * from student";
			try {
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(QUERY);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Student student = new Student();
					student.setStudId(resultSet.getInt("studId"));
					student.setStudName(resultSet.getString("studName"));
					student.setMobNo(resultSet.getLong("mobNo"));
					student.setGmail(resultSet.getString("gmail"));
					student.setBatchId(resultSet.getInt("batchId"));
					
					studentList.add(student);

				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if (resultSet != null)
						resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return studentList;
		}

	@Override
	public int addStudent(Student student)
	{
		// TODO Auto-generated method stub
		System.out.println(student);
		int status=0;
		Connection connection=null;
		PreparedStatement preparedStatement =null;
		try
		{
			connection = ConnectionFactory.getConnection();
			preparedStatement=connection.prepareStatement("insert into student values(?,?,?,?,?)");
			preparedStatement.setInt(1, student.getStudId());
			preparedStatement.setString(2, student.getStudName());
			preparedStatement.setLong(3, student.getMobNo());
			preparedStatement.setString(4, student.getGmail());
			preparedStatement.setInt(5, student.getBatchId());
			
			status=preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(preparedStatement!=null)
					preparedStatement.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				if(connection!=null)
					connection.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return status;
	}

	
	public int removeStudent(int studId) {
		// TODO Auto-generated method stub
		//Connection connection=null;
		//PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int r=0;

		try
		{
			connection = ConnectionFactory.getConnection();
			preparedStatement=connection.prepareStatement("delete from student where studId=?");
			preparedStatement.setInt(1,studId);
			r=preparedStatement.executeUpdate();
			System.out.println("Number of rows deleted : "+r);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return r;
	}

	@Override
	public int updateRecord(int studId,String studName,long mobNo) {
		// TODO Auto-generated method stub
		
		int r=0;
		try
		{
			connection = ConnectionFactory.getConnection();
			preparedStatement=connection.prepareStatement("update student set studName=?,mobNo=? where studId=?");
			preparedStatement.setInt(1, studId);
			preparedStatement.setString(2, studName);
			preparedStatement.setLong(3, mobNo);
			
			r=preparedStatement.executeUpdate();
			System.out.println("Number of rows updated successfully : "+r);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return r;
	}
}
	

