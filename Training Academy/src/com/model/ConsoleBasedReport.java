package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.configuration.ConnectionFactory;

public class ConsoleBasedReport 
{
	Student s;
	Result r;
	Trainer t;
	Batches b;
	public ConsoleBasedReport()
	{
		s=new Student();
		r= new Result();
		t=new Trainer();
		b=new Batches();
		
	}
	public ConsoleBasedReport(Student s, Result r, Trainer t, Batches b) {
		this.s = s;
		this.r = r;
		this.t = t;
		this.b = b;
	}
	public Student getS() {
		return s;
	}
	public void setS(Student s) {
		this.s = s;
	}
	public Result getR() {
		return r;
	}
	public void setR(Result r) {
		this.r = r;
	}
	public Trainer getT() {
		return t;
	}
	public void setT(Trainer t) {
		this.t = t;
	}
	public Batches getB() {
		return b;
	}
	public void setB(Batches b) {
		this.b = b;
	}
}

class ShowReport
{
	ConnectionFactory ConnectionFactory;
	public ShowReport()
	{
		ConnectionFactory=new ConnectionFactory();
	}
	Connection connection = null;
	PreparedStatement preparedStatement1 = null;
	ResultSet resultSet1 = null;
	PreparedStatement preparedStatement2 = null;
	ResultSet resultSet2 = null;
	public void show()
	{
	
	 String query1 = "select studId,studName,batchid from student;";
	 String query2= "select percent from result order by percent;";
				 
		connection = ConnectionFactory.getConnection();
		preparedStatement1 = connection.prepareStatement(query1);
		resultSet1 = preparedStatement1.executeQuery();
		preparedStatement2 = connection.prepareStatement(query2);
		resultSet2 = preparedStatement2.executeQuery();

		while (resultSet2.next())
		{
			ArrayList<ShowReport> toppers=new ArrayList<>();
			 resultSet1.beforeFirst();
			 while(resultSet1.next())
			 {
				 
				 if(resultSet1.getInt(1)==resultSet2.getInt(1))
				 {
					 	toppers.add(resultSet1.getString(2));
				 }
				// toppersmap.put(resultSet1.getString(2,toppers));

			 }
		}

	}

	public static void main(String[] args) {
		//+-
		ArrayList<ShowReport> toppers=new ArrayList<>();
		
		
	}
	

}
