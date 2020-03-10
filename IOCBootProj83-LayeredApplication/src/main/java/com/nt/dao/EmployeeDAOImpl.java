package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public  class EmployeeDAOImpl implements EmployeeDAO {
	private static final String INSERT_EMP_QUERY="INSERT INTO SPRING_LAYERED_EMPLOYEE VALUES(EMPNO_SEQ.NEXTVAL,?,?,?,?,?)";
	@Autowired
	private DataSource ds;

	

	@Override
	public int insert(EmployeeBO bo) throws Exception {
		System.out.println("EmployeeDAOImpl.insert() ::: ds-->"+ds.getClass());
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//write jdbc code
		//get pooled jdbc con object
		con=ds.getConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(INSERT_EMP_QUERY);
		//set query param values
		ps.setString(1, bo.getEmpName());
		ps.setString(2, bo.getEmpAddress());
		ps.setFloat(3, bo.getBasicSalary());
		ps.setFloat(4, bo.getGrossSalary());
		ps.setFloat(5, bo.getNetSalary());
		//execute the query
		count=ps.executeUpdate();
		
		//close jdbc objs
		ps.close();
		con.close();
	
		return count;
	}//insert(-)

}//class
