package com.datapromise.common;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapWrapper  {
	
	public static int insert(String mapperItemName, Object entity)
	{
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try
		{
			int effectedLines = sqlSession.insert(mapperItemName, entity);
			sqlSession.commit();
			return effectedLines;
		}
		finally
		{
			sqlSession.close();
		}
	}
	
	public static Object queryForObject(String mapperItemName, Object parameters)
	{
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try
		{
			return sqlSession.selectOne(mapperItemName, parameters);
		}
		finally
		{
			sqlSession.close();
		}
	}
	
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	private synchronized static SqlSessionFactory getSqlSessionFactory()
	{		
		if (sqlSessionFactory == null)
		{
		    InputStream inputStream = SqlMapWrapper.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		    		    
		    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, AppConfiguration.getProperties());
		}
		
		return sqlSessionFactory;
	}

}



