package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO3")
//@Primary
public class EmployeeDAOImpl3 implements EmployeeDAO {
	private static final String GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	public EmployeeBO getEmployeeByNo(int no) {
		EmployeeBO bo=null;
	   bo=jt.queryForObject(GET_EMP_BY_NO,
			                                new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class),
			                           no);
		return bo;
	}

	@Override
	public List<EmployeeBO> getEmployessByDesgs(String desg1, String desg2, String desg3) {
		BeanPropertyRowMapper<EmployeeBO> bprm=null;
		RowMapperResultSetExtractor rmre=null;
		List<EmployeeBO> listBO=null;
		
		bprm=new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class);
		rmre=new RowMapperResultSetExtractor(bprm);
		listBO=(List<EmployeeBO>) jt.query(GET_EMPS_BY_DESGS, rmre,desg1,desg2,desg3);
		return listBO;
	}

	@Override
	public List<EmployeeBO> getEmpsByJobs(String desg1, String desg2, String desg3) {
		// TODO Auto-generated method stub
		return null;
	}
	

}//outer class
