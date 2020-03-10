package com.nt.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.nt.bo.PatientDetailsInputBO;
import com.nt.bo.PatientDetailsResultBO;

public class PatientInfoDAOImpl implements PatientInfoDAO {
	private static final String SEARCH_PATIENTS_QUERY="SELECT PID,PNAME,PADDRS,AGE,CONTACTNO,PROBLEM,DOCTOR,WARDNO FROM PATIENT_INFO WHERE (PNAME IS NOT NULL AND PNAME like ?) OR( PADDRS IS NOT NULL AND PADDRS LIKE ?) OR (PROBLEM IS NOT NULL AND PROBLEM LIKE ?) OR( DOCTOR IS NOT NULL AND DOCTOR  like ?)";
	private JdbcTemplate jt;
	

	public PatientInfoDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public List<PatientDetailsResultBO> find(PatientDetailsInputBO ibo) {
		List<PatientDetailsResultBO> listRBO=null;
		
		
		listRBO=(List<PatientDetailsResultBO>) jt.query(SEARCH_PATIENTS_QUERY,
				         new RowMapperResultSetExtractor(new BeanPropertyRowMapper(PatientDetailsResultBO.class)),
				         ibo.getPname(),
				         ibo.getPaddrs(),
				         ibo.getProblem(),
				         ibo.getDoctor()
				         );
	
		return listRBO;
	}

}
