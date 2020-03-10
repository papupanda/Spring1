package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Repository("custDAO")
public class CustomerDAOImpl implements CustomerDAO {
	private static final String  GET_CUST_BY_ID="SELECT CUSTNO,CUSTNAME,CUSTADDRS,PAMT,INTRAMT FROM CUSTOMER_DAO WHERE CUSTNO=?";
	private static final String  GET_CUSTS_BY_PAMTS_RANGE="SELECT CUSTNO,CUSTNAME,CUSTADDRS,PAMT,INTRAMT FROM CUSTOMER_DAO WHERE PAMT>=? AND PAMT<=?";
		
    private CustomerSelector custSelector=null;
    private CustomerSelectorList custSelectList=null;
	@Autowired
	public CustomerDAOImpl(DataSource ds) {
	    custSelector=new CustomerSelector(ds, GET_CUST_BY_ID);
	    custSelectList=new CustomerSelectorList(ds,GET_CUSTS_BY_PAMTS_RANGE);
	}
	
	public CustomerBO getCustomerById(int id) {
		CustomerBO bo=null;
		//user  inner calss obj 
		bo=custSelector.findObject(id);
		return bo;
	}
	
	public List<CustomerBO> getCustomersByLoanAmtRange(float start, float end) {
		List<CustomerBO> listBO=null;
		listBO=custSelectList.execute(start,end);
		return listBO;
	}
	
	 //inner class1 for query
	private  class CustomerSelector extends MappingSqlQuery<CustomerBO>{
		
		 public CustomerSelector(DataSource ds, String query) {
			 super(ds,query);
			 super.declareParameter(new SqlParameter(Types.INTEGER));
			 super.compile();
		}

		@Override
		public CustomerBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("CustomerDAOImpl.CustomerSelector.mapRow()");
			CustomerBO bo=null;
			bo=new CustomerBO();
			bo.setCustId(rs.getInt(1));
			bo.setCustName(rs.getString(2));
			bo.setCustAddrs(rs.getString(3));
			bo.setPAmt(rs.getFloat(4));
			bo.setIntrAmt(rs.getFloat(5));
			return bo;
		}//mapRow(-,-)
	}//inner class

	  //inner class2 for query2
	  private class CustomerSelectorList  extends MappingSqlQuery<CustomerBO>{
		  
		  public CustomerSelectorList(DataSource ds,String query) {
			   super(ds,query);
			   super.declareParameter(new SqlParameter(Types.FLOAT));
			   super.declareParameter(new SqlParameter(Types.FLOAT));
			   super.compile();
		}
		  

		@Override
		public CustomerBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("CustomerDAOImpl.CustomerSelectorList.mapRow(-,-)");
			CustomerBO bo=null;
			bo=new CustomerBO();
			bo.setCustId(rs.getInt(1));
			bo.setCustName(rs.getString(2));
			bo.setCustAddrs(rs.getString(3));
			bo.setPAmt(rs.getFloat(4));
			bo.setIntrAmt(rs.getFloat(5));
			return bo;
		}//mapRow(-,-)
	  }//innerclass2

	
}//outer class
