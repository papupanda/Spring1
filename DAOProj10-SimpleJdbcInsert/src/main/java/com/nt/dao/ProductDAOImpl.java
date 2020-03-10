package com.nt.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.ProductBO;

@Repository("prodDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SimpleJdbcInsert sji;

	/*@Override
	public int insert(ProductBO bo) {
		Map<String,Object> paramsMap;
		int count=0;
		//set table name
		sji.setTableName("PRODUCT");
		//execute the query by giving col names and values
		paramsMap=new HashMap();
		paramsMap.put("PID",new Random().nextInt(10000));
		paramsMap.put("PNAME",bo.getPname());
		paramsMap.put("PRICE",bo.getPrice());
		paramsMap.put("QTY",bo.getQty());
		paramsMap.put("STATUS",bo.isStatus());
		count=sji.execute(paramsMap);
		return count;
	}*/
	
	/*@Override
	public int insert(ProductBO bo) {
		MapSqlParameterSource msps=null;
		int count=0;
		//set table name
		sji.setTableName("PRODUCT");
		//execute the query by giving col names and values
		msps=new MapSqlParameterSource();
		msps.addValue("PID",new Random().nextInt(1000));
		msps.addValue("PNAME",bo.getPname());
		msps.addValue("QTY",bo.getQty());
		msps.addValue("PRICE",bo.getPrice());
		msps.addValue("STATUS",bo.isStatus());
		count=sji.execute(msps);
		return count;
	}*/
	
	@Override
	public int insert(ProductBO bo) {
		BeanPropertySqlParameterSource bpsps=null;
		int count=0;
		//set table name
		sji.setTableName("PRODUCT");
		//execute the query by giving col names and values
		bo.setPid(new Random().nextInt(1000));
		bpsps=new BeanPropertySqlParameterSource(bo);
		count=sji.execute(bpsps);
		return count;
	}

}
