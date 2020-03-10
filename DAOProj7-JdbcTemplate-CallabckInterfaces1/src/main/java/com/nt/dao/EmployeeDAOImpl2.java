package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO2")
@Primary
public class EmployeeDAOImpl2 implements EmployeeDAO {
	private static final String GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	public EmployeeBO getEmployeeByNo(int no) {
		EmployeeBO bo=null;
	   bo=jt.queryForObject(GET_EMP_BY_NO,
			                                    (rs,index)->{
			                                    	EmployeeBO bo1=null;
			                                    	bo1=new EmployeeBO();
			                                    	bo1.setEmpno(rs.getInt(1));
			                                    	bo1.setEname(rs.getString(2));
			                                    	bo1.setJob(rs.getString(3));
			                                    	bo1.setSal(rs.getInt(4));
			                                    	return bo1;
			                                    },
			                           no);
		return bo;
	}

	@Override
	public List<EmployeeBO> getEmployessByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO=null;
		listBO=jt.query(GET_EMPS_BY_DESGS, rs->{
			List<EmployeeBO> listBO1=null;
			listBO1=new ArrayList();
			while(rs.next()) {
				EmployeeBO bo1=new EmployeeBO();
				bo1.setEmpno(rs.getInt(1));
				bo1.setEname(rs.getString(2));
				bo1.setJob(rs.getString(3));
				bo1.setSal(rs.getInt(4));
				listBO1.add(bo1);
			}//while
			return listBO1;
		},
		desg1,desg2,desg3);
		return listBO;
	}//method

	@Override
	public List<EmployeeBO> getEmpsByJobs(String desg1, String desg2, String desg3) {
		final List<EmployeeBO> listBO=new ArrayList();
		jt.query(GET_EMPS_BY_DESGS,
				        rs->{
				        	System.out.println("EmployeeDAOImpl2.getEmpsByJobs()::LDMA");
				        	EmployeeBO bo=new EmployeeBO();
							bo.setEmpno(rs.getInt(1));
							bo.setEname(rs.getString(2));
							bo.setJob(rs.getString(3));
							bo.setSal(rs.getInt(4));
							listBO.add(bo);
				        },
				        desg1,desg2,desg3);
		
		return listBO;
	}
	

}//outer class
