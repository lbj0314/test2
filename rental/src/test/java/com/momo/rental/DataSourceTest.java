package com.momo.rental;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DataSourceTest extends TestAbstractCase{

	@Inject
	private DataSource dataSource;
	
	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void sqlSessionTest() throws Exception{
		assertNotNull(sqlSession);
	}
	
	@Test
	public void dataSourceTest() throws Exception {
		assertNotNull(dataSource.getConnection());
	}
	
	
}
