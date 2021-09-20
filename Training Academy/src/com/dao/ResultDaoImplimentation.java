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
				preparedStatement=connection.prepareStatement("insert into result values(?,?,?,?,?,?)");
				preparedStatement.setInt(1, result.getStudId());
				preparedStatement.setInt(2, result.getTest1());
				preparedStatement.setInt(3, result.getTest2());
				preparedStatement.setInt(4, result.getTest3());
				preparedStatement.setInt(5, result.getTotalMarks());
				preparedStatement.setInt(6, result.getPercent());
			
				
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

}
