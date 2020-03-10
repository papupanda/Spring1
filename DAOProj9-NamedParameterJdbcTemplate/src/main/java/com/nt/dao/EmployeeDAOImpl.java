package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=:id";
	private static final String  GET_EMP_NAME_BY_NO="SELECT ENAME FROM EMP WHERE EMPNO=:id";
	private static final String  GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(:desg1,:desg2,:desg3) ORDER BY JOB";
	private static final String  INSERT_EMP="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(:empNo,:ename,:job,:sal)";
	@Autowired
	private NamedParameterJdbcTemplate npjt;

	@Override
	public Map<String, Object> getEmpById(int no) {
		Map<String,Object> empMap=null;
		Map<String,Object> paramMap=null;
		//param values as Map object
		paramMap=new HashMap();
		paramMap.put("id",no);
		
		empMap=npjt.queryForMap(GET_EMP_DETAILS_BY_NO, paramMap);
		return empMap;
	}

	@Override
	public String getEmpNameById(int no) {
		String name=null;
		MapSqlParameterSource sps=null;
		//set param values
		sps=new MapSqlParameterSource();
		sps.addValue("id",no);
		//execute query
		name=npjt.queryForObject(GET_EMP_NAME_BY_NO, sps,String.class);
		
		return name;
	}

	@Override
	public List<EmployeeBO> getEmpsByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO=null;
		MapSqlParameterSource msps=null;
		//set named param  values
		msps=new MapSqlParameterSource();
		msps.addValue("desg1",desg1);
		msps.addValue("desg2",desg2);
		msps.addValue("desg3",desg3);
		
		listBO=npjt.query(GET_EMPS_BY_DESGS,
				                         msps,
				                         new ResultSetExtractor<List<EmployeeBO>>() {

											@Override
											public List<EmployeeBO> extractData(ResultSet rs)
													throws SQLException, DataAccessException {
												List<EmployeeBO> listBO=null;
												EmployeeBO bo=null;
												listBO=new ArrayList();
												while(rs.next()) {
													bo=new EmployeeBO();
													bo.setEmpNo(rs.getInt(1));
													bo.setEname(rs.getString(2));
													bo.setJob(rs.getString(3));
													bo.setSal(rs.getInt(4));
													listBO.add(bo);
												}//while
												return listBO;
											}//extractData(-)
										}//anonymous inner class
				                        );
		return listBO;
	}//method

	@Override
	public int insert(EmployeeBO bo) {
		BeanPropertySqlParameterSource bpsps=null;
		int count=0;
		//set values to named params
		bpsps=new BeanPropertySqlParameterSource(bo);
		//execute the query
		count=npjt.update(INSERT_EMP, bpsps);
		return count;
	}

}//class
