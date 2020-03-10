package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.entity.EmployeeHLO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String HQL_GET_EMPS_BY_ADDRS="FROM EmployeeHLO WHERE eadd IN(?,?)";
	private static final String HQL_GET_EMPS_BY_ADDRS1="FROM EmployeeHLO WHERE eadd IN(:ad1,:ad2)";
	private static final String HQL_DELETE_EMPS_BY_SAL="DELETE FROM EmployeeHLO WHERE salary>? ";
	private static final String HQL_UPDATE_EMPS_BY_ADDRS="UPDATE  EmployeeHLO SET salary=salary+ (salary*:per/100) WHERE eadd=:addrs";
	
	
	@Autowired
	private HibernateTemplate ht;
	
	

	@Override
	public int insert(EmployeeHLO hlo) {
		int idVal=0;
		//disable readOnly mode
		ht.setCheckWriteOperations(false);
		idVal=(int) ht.save(hlo);
		return idVal;
	}



	@Override
	public EmployeeHLO getEmpById(int id) {
		EmployeeHLO hlo=null;
		//use DAO
		hlo=ht.get(EmployeeHLO.class, id);
		return hlo;
	}



	@Override
	public List<?> getEmpsByAddresses(String adrrs1, String addrs2) {
		List<?> listHLO=null;
		listHLO= ht.find(HQL_GET_EMPS_BY_ADDRS, adrrs1,addrs2);
		return listHLO;
	}



	@Override
	public List<?> getEmpsByAddresses1(String adrrs1, String addrs2) {
		List<?> listHLO=null;
		listHLO= ht.findByNamedParam(HQL_GET_EMPS_BY_ADDRS1,
				                      new String[] {"ad1","ad2"},
				                      new Object[] {adrrs1,addrs2});
		return listHLO;
	}
	
	
	@Override
	public List<?> getEmpsBySalaryRange(float start, float end) {
	    List<?> listHLO=null;
	    listHLO=ht.findByNamedQueryAndNamedParam("query1",
	    		                               new String[]{"min","max"},
	    		                               new Object[] {start,end});
		
    	return listHLO;
	}
	
	@Override
	public int fireEmpsBySalaryMark(float maxSalary) {
		int count=0;
		ht.setCheckWriteOperations(false);
		count=ht.bulkUpdate(HQL_DELETE_EMPS_BY_SAL, maxSalary);
		return count;
	}



	@Override
	public int updateEmpsSalaryByAddrs(String addrs, float percentage) {
		int count=0;
		ht.setCheckWriteOperations(false);
		count=ht.execute(new HBCallback(addrs,percentage));
		
		return count;
	}
	
	private class HBCallback implements HibernateCallback<Integer>{
		  private String addrs;
		  private float percentage;
		public HBCallback(String addrs,float percentage) {
		   this.addrs=addrs;
		   this.percentage=percentage;
		}

		@Override
		public Integer doInHibernate(Session ses) throws HibernateException {
			 Query query=null;
			 int count=0;
			//prepare Query
			 query=ses.createQuery(HQL_UPDATE_EMPS_BY_ADDRS);
			 //set named param values
			 query.setParameter("per",percentage);
			 query.setParameter("addrs",addrs);
			 //execute the query
			 count=query.executeUpdate();
			return count;
		}
		
	}

}
