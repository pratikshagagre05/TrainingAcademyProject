package com.service;

import com.model.Result;
import com.dao.ResultDao;
import com.dao.ResultDaoImplimentation;
import com.dao.StudentDaoImplimentation;
public class ResultServiceImplimentation implements ResultService
{
    ResultDao resultDao;
    public ResultServiceImplimentation() {
		// TODO Auto-generated constructor stub
    	resultDao=new ResultDaoImplimentation();
	}
	@Override
	public int addMarks(Result result) {
			
			return resultDao.addMarks(result);
	}
	@Override
	public int removeResult(int resultId) {
		// TODO Auto-generated method stub
		return resultDao.removeResult(resultId);
	}
	@Override
	public int updateResult(int resultId,int test1,int test2,int test3,int totalMarks,float percent) 
		{
		// TODO Auto-generated method stub
		return resultDao.updateResult(resultId,test1,test2,test3,totalMarks,percent);
	}

}
