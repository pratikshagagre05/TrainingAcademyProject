package com.dao;

import com.model.Result;

public interface ResultDao 
{
	int addMarks(Result result);
	int removeResult(int resultId);
	int updateResult(int resultId,int test1,int test2,int test3,int totalMarks,float percent) ;
		

}
