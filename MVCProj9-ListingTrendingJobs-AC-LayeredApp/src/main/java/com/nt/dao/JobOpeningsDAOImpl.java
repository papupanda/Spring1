package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nt.bo.JobDetailsBO;

public final class JobOpeningsDAOImpl implements JobOpeningsDAO {
	private static final String GET_ALL_JOB_OPENINGS="SELECT JOBID,COMPANY,DOMAIN,POSITION,SALARYRANGE,NOP,EXPRANGE,LOCATION FROM JOBOPENINGS_INFO";
	private JdbcTemplate jt;

	public JobOpeningsDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List<JobDetailsBO> getAllJobOpenings() {
		List<JobDetailsBO> listBO=null;
		//execute the Query
		listBO=jt.query(GET_ALL_JOB_OPENINGS,new JobDetailsExtractor());
		return listBO;
	}
	
	private class JobDetailsExtractor implements ResultSetExtractor<List<JobDetailsBO>>{

		@Override
		public List<JobDetailsBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			  List<JobDetailsBO> listBO=null;
			  JobDetailsBO bo=null;
			//process the ResultSEt
			  listBO=new ArrayList();
			  while(rs.next()) {
				  bo=new JobDetailsBO();
				  bo.setJobId(rs.getInt(1));
				  bo.setCompany(rs.getString(2));
				  bo.setDomain(rs.getString(3));
				  bo.setPosition(rs.getString(4));
				  bo.setSalaryRange(rs.getString(5));
				  bo.setNop(rs.getInt(6));
				  bo.setExpRange(rs.getString(7));
				  bo.setLocation(rs.getString(8));
				  listBO.add(bo);
			  }//while
			return listBO;
		}//extractData
		
	}//inner class

}//dao 
