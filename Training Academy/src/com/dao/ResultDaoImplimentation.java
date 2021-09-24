package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.configuration.ConnectionFactory;
import com.model.Result;
import com.model.Student;

public class ResultDaoImplimentation implements ResultDao 
{

	ConnectionFactory ConnectionFactory;
	public ResultDaoImplimentation()
	{
		ConnectionFactory=new ConnectionFactory();
	}
	ArrayList<Result> resultList = new ArrayList<>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public int addMarks(Result result) {
		{
			// TODO Auto-generated method stub
			System.out.println(result);
			int status=0;
			Connection connection=null;
			PreparedStatement preparedStatement =null;
			try
			{
				connection = ConnectionFactory.getConnection();
				preparedStatement=connection.prepareStatement("insert into result values(?,?,?,?,?,?,?)");
				preparedStatement.setInt(1, result.getResultId());
				preparedStatement.setInt(2, result.getStudId());
				preparedStatement.setInt(3, result.getTest1());
				preparedStatement.setInt(4, result.getTest2());
				preparedStatement.setInt(5, result.getTest3());
				preparedStatement.setInt(6, result.getTotalMarks());
				preparedStatement.setFloat(7, result.getPercent());
			
				
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
		}
		
		public int removeResult(int resultId) {
						ResultSet resultSet = null;
			int r=0;

			try
			{
				connection = ConnectionFactory.getConnection();
				preparedStatement=connection.prepareStatement("delete from result where resultId=?");
				preparedStatement.setInt(1,resultId);
				r=preparedStatement.executeUpdate();
				System.out.println("Number of rows deleted : "+r);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally 
			{
				try {
					if (resultSet != null)
						resultSet.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

			return r;
		
	}

		@Override
			public int updateResult(int resultId,int test1,int test2,int test3,int totalMarks,float percent) {
				
				int r=0;
				try
				{
					connection = ConnectionFactory.getConnection();
					preparedStatement=connection.prepareStatement("update result set test1=?,test2=?,test3=?,totalMarks=?,percent=? where resultId=?");
					preparedStatement.setInt(1, test1);
					preparedStatement.setInt(2, test2);
					preparedStatement.setInt(3, test3);
					preparedStatement.setInt(4, totalMarks);
					preparedStatement.setFloat(5, percent);
					preparedStatement.setInt(6, resultId);
					
					r=preparedStatement.executeUpdate();
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
						
						e.printStackTrace();
					}
					try {
						if (preparedStatement != null)
							preparedStatement.close();
					} catch (SQLException e) {
												e.printStackTrace();
					}
					try {
						if (connection != null)
							connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return r;
			}

}
