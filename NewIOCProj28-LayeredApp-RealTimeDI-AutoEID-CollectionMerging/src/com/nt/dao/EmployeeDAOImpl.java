package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public final class EmployeeDAOImpl implements EmployeeDAO {
	private static final String INSERT_EMP_QUERY="INSERT INTO SPRING_LAYERED_EMPLOYEE VALUES(EID_SEQ.NEXTVAL,?,?,?,?,?)";
	private DataSource ds;

	public EmployeeDAOImpl(DataSource ds) {
		System.out.println("EmployeeDAOImpl.1-param constructor");
		this.ds = ds;
	}//constructor

	@Override
	public int insert(EmployeeBO bo) throws Exception {
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
