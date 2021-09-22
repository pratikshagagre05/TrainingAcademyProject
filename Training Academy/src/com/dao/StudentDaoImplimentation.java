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
	public List<Student> getAllStudents()
	{
		final String QUERY = "select * from student";
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

			} catch (Exception e) 
			{
					e.printStackTrace();
			}
			finally
			{
				try 
				{
					if (resultSet != null)
						resultSet.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				try 
				{
					if (preparedStatement != null)
						preparedStatement.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				try
				{
					if (connection != null)
						connection.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			return studentList;
		}

	@Override
	public int addStudent(Student student)
	{
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

	
	public int removeStudent(int studId) 
	{
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
			
			try 
			{
				if (preparedStatement != null)
					preparedStatement.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return r;
	}

	@Override
	public int updateRecord(int studId,String studName,long mobNo) 
	{
		int r=0;
		try
		{
			connection = ConnectionFactory.getConnection();
			preparedStatement=connection.prepareStatement("update student set studName=?,mobNo=? where studId=?");
			
			preparedStatement.setString(1, studName);
			preparedStatement.setLong(2, mobNo);
			preparedStatement.setInt(3, studId);
			
			r=preparedStatement.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r;
	}
	
	public void meritListTopFiveStudent(int batchid) {

		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
	
		String 	query="select s.studId,s.studName,r.percent from student s inner join result r on s.studId=r.studid where batchid=? and percent>50 order by percent desc limit 2";
		try
		{
			connection = ConnectionFactory.getConnection();
			preparedStatement=connection.prepareStatement(query);
		
			preparedStatement.setInt(1, batchid);
			System.out.println("Student Id   Student Name   percent");
			
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.print(resultSet.getInt("studId"));
				System.out.print("            ");
				System.out.print(resultSet.getString("studName"));
				System.out.print("       ");
				System.out.print(resultSet.getFloat("percent"));
				System.out.println();
				/*
				 * System.out.println(resultSet.getInt("studId")); System.out.print("     ");
				 * System.out.print(resultSet.getString("studName")); System.out.print("    ");
				 * System.out.print(resultSet.getFloat("percent"));
				 */
			}
			
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void topFiveStudentFromAllBatches() {
		// TODO Auto-generated method stub
				Connection connection=null;
				PreparedStatement preparedStatement=null;
				ResultSet resultSet=null;
			
				String 	query="\r\n"
						+ "select s.studId,s.studName,r.percent,b.batch_name from student s inner join result r on s.studId = r.studId inner join batches b on  b.Batch_id=s.batchid where percent>50 order by percent desc limit 10;";
				try
				{
					connection = ConnectionFactory.getConnection();
					preparedStatement=connection.prepareStatement(query);
				
					//preparedStatement.setInt(1, batchid);
					System.out.println("Student Id       Student Name     percent  Batch Name");
					
					resultSet=preparedStatement.executeQuery();
					while (resultSet.next()) {
						System.out.print(resultSet.getInt("studId"));
						System.out.print("               ");
						System.out.print(resultSet.getString("studName"));
						System.out.print("        ");	
						System.out.print(resultSet.getFloat("percent"));
						System.out.print("       ");
						System.out.print(resultSet.getString("batch_name"));
						System.out.println();
						
					}
								
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				finally {
					try {
						if (resultSet != null)
							resultSet.close();
					} catch (SQLException e) 
					{
						e.printStackTrace();
					}
				
					try {
						if (preparedStatement != null)
							preparedStatement.close();
					} catch (SQLException e) 
					{
						e.printStackTrace();
					}
					try {
						if (connection != null)
							connection.close();
					} 
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
				
	public void topBatchAndTrainerr()
	{
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			String 	query="select b.batch_id,b.batch_name, t.Trainer_name, avg(r.percent) as average\r\n"
					+ "from student s join trainer t join batches b join result r on s.batchid=b.batch_id \r\n"
					+ "and s.studId=r.studid and b.Batch_id=t.Batch_id group by b.batch_id,t.trainer_name order by average desc limit 1;";
			try
			{
				connection = ConnectionFactory.getConnection();
				preparedStatement=connection.prepareStatement(query);
							
				resultSet=preparedStatement.executeQuery();
				while (resultSet.next()) {
					System.out.print(resultSet.getInt("batch_id"));
					System.out.print("            ");
					System.out.print(resultSet.getString("batch_name"));
					System.out.print("       ");
					System.out.print(resultSet.getString("Trainer_name"));
					System.out.println();
					
				}					
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally {
				try {
					if (resultSet != null)
						resultSet.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
				try {
					if (connection != null)
						connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	
	
	
	
	
	
}
	

	

