package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO1")
//@Primary
public class EmployeeDAOImpl1 implements EmployeeDAO {
	private static final String GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	public EmployeeBO getEmployeeByNo(int no) {
		EmployeeBO bo=null;
	   bo=jt.queryForObject(GET_EMP_BY_NO,
			                           new RowMapper<EmployeeBO>() {
		                                    public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
		                                    	System.out.println(
														"EmployeeDAOImpl1.getEmployeeByNo(...).new RowMapper() {...}.mapRow(..)");
		                                        EmployeeBO bo=null;
		                                    	//copy ResultSet obj record to BO class object
		                                        bo=new  EmployeeBO();
		                                        bo.setEmpno(rs.getInt(1));
		                                        bo.setEname(rs.getString(2));
		                                        bo.setJob(rs.getString(3));
		                                        bo.setSal(rs.getInt(4));
		                                        return bo;
	                                       }},
			                           no);
		return bo;
	}

	@Override
	public List<EmployeeBO> getEmployessByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO=null;
		listBO=jt.query(GET_EMPS_BY_DESGS,
				                   new ResultSetExtractor<List<EmployeeBO>>() {

									@Override
									public List<EmployeeBO> extractData(ResultSet rs)
											throws SQLException, DataAccessException {
										System.out.println(
												"EmployeeDAOImpl1.getEmployessByDesgs::extractData(-)");
										List<EmployeeBO> listBO=null;
										EmployeeBO bo=null;
										listBO=new ArrayList();
										while(rs.next()) {
											bo=new EmployeeBO();
											bo.setEmpno(rs.getInt(1));
											bo.setEname(rs.getString(2));
											bo.setJob(rs.getString(3));
											bo.setSal(rs.getInt(4));
											listBO.add(bo);
										}
									
										return listBO;
									}
			                            
		                             },
				                   desg1,desg2,desg3);
		return listBO;
	}

	@Override
	public List<EmployeeBO> getEmpsByJobs(String desg1, String desg2, String desg3) {
		final List<EmployeeBO> listBO=new ArrayList();
		
		jt.query(GET_EMPS_BY_DESGS,
				                   new RowCallbackHandler() {
									
									@Override
									public void processRow(ResultSet rs) throws SQLException {
									     System.out.println("EmployeeDAOImpl1::getEmpsByJobs()::processRow(-)");
									     EmployeeBO bo=null;
										 //copy each Record to BO class object
									     bo=new EmployeeBO();
									     bo.setEmpno(rs.getInt(1));
									     bo.setEname(rs.getString(2));
									     bo.setJob(rs.getString(3));
									     bo.setSal(rs.getInt(4));
									     listBO.add(bo);
									}//procesRow(-)
								}// anonymous inner class
			                    ,
				                    desg1,desg2,desg3);
		return listBO;
	}
	

}//outer class
