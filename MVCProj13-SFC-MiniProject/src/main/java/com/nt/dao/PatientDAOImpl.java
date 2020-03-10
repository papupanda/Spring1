package com.nt.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.nt.bo.PatientDetailsBO;

public class PatientDAOImpl implements PatientDAO {
	private static final String GET_ALL_PATIENTS_QUERY="SELECT PID,PNAME,PADDRS,AGE,CONTACTNO,PROBLEM,WARDNO,DOCTOR FROM PATIENT_INFO ";
	private static final String GET_PATIENT_BY_ID="SELECT PID,PNAME,PADDRS,AGE,CONTACTNO,PROBLEM,WARDNO,DOCTOR FROM PATIENT_INFO WHERE PID=? ";
	private static final String UPDATE_PATIENT_BY_ID="UPDATE PATIENT_INFO SET PNAME=?,PADDRS=?,AGE=?,CONTACTNO=?,PROBLEM=?,WARDNO=?,DOCTOR=? WHERE PID=?";
	private static final String DELETE_PATIENT_BY_ID="DELETE FROM PATIENT_INFO WHERE PID=?";
	private  JdbcTemplate jt;
	
	public PatientDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public List<PatientDetailsBO> getAllPatients() {
		List<PatientDetailsBO> listBO=null;
		listBO=(List<PatientDetailsBO>) jt.query(GET_ALL_PATIENTS_QUERY,
				        new RowMapperResultSetExtractor(new BeanPropertyRowMapper(PatientDetailsBO.class)));
        return listBO;		
				        
	}
	
	@Override
	public PatientDetailsBO getPatientById(int id) {
		PatientDetailsBO bo=null;
		bo=jt.queryForObject(GET_PATIENT_BY_ID,new BeanPropertyRowMapper<>(PatientDetailsBO.class),id);
		return bo;
	}


	@Override
	public int updatePatientById(PatientDetailsBO bo) {
		int count=0;
		count=jt.update(UPDATE_PATIENT_BY_ID, bo.getPname(),bo.getPaddrs(),bo.getAge(),bo.getContactNo(),bo.getProblem(),bo.getWardNo(),bo.getDoctor(),bo.getPid());
		return count;
	}


	@Override
	public int deletePatientById(int pid) {
		int count=0;
		count=jt.update(DELETE_PATIENT_BY_ID,pid);
		return count;
	}

}
