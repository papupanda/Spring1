package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  GET_EMPS_COUNT_QUERY="SELECT COUNT(*) FROM EMP";
	private  static final String  GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private  static final String  GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=?";
	private  static final String  GET_EMP_NAME_BY_NO="SELECT ENAME  FROM EMP WHERE EMPNO=?";
	private static final String  INSERT_EMP_DETAILS="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(EID_SEQ.NEXTVAL,?,?,?)";
    private static final String   GET_EMP_SALARY_BY_NO="SELECT SAL FROM EMP WHERE EMPNO=?";
    private static final String   UPDATE_EMP_BY_SALARY="UPDATE EMP SET SAL=? WHERE  EMPNO=?";
	private JdbcTemplate jt;
	

	public EmployeeDAOImpl(JdbcTemplate jt) {
		System.out.println("EmployeeDAOImpl:: 1-param constructor");
		this.jt = jt;
	}


	public int getEmpsCount() {
		int count=0;
		//count=jt.queryForObject(GET_EMPS_COUNT_QUERY, Integer.class);  //uses Simple Statement obj as static  query
		count=jt.queryForObject(GET_EMPS_COUNT_QUERY,null, Integer.class); //uses PreparedStatement obj as dynamic query
		
		return count;
	}


	public Map<String, Object> getEmployeeByNo(int no) {
		Map<String,Object> map=null;
		//send and execute the SQL Query
		map=jt.queryForMap(GET_EMP_BY_NO, no);
		return map;
	}
	
	public List<Map<String, Object>> getEmployeesByDesg(String desg) {
	    List<Map<String,Object>> list=null;
		//send and execute  SQL query
	    list=jt.queryForList(GET_EMPS_BY_DESG,desg);
		return list;
	}


	public String getEmpNameByNo(int no) {
	    String  name=null;
		//send and execute SQL Query in DB s/w
	    name=jt.queryForObject(GET_EMP_NAME_BY_NO,String.class,no);
		return name;
	}


	public int insert(String ename, String desg, float salary) {
		int count=0;
        count=jt.update(INSERT_EMP_DETAILS, ename,desg,salary);
		return count;
	}


	public int getSalary(int empNo) {
	   int salary=0;
	   salary=jt.queryForObject(GET_EMP_SALARY_BY_NO,Integer.class,empNo);
		return salary;
	}
	
	public int updateSalary(int empNo, int newSalary) {
		int count=0;
		//send execute the Query
		count=jt.update(UPDATE_EMP_BY_SALARY, newSalary,empNo);
		return count;
	}

}
