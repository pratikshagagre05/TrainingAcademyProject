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

}
