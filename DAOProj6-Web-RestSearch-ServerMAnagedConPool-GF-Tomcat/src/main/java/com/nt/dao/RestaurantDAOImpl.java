package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository("restDAO")
public class RestaurantDAOImpl implements RestaurantDAO {
	private static final String GET_RESTS_BY_LOCATION="SELECT RESTID,RESTNAME,RESTTYPE,CUSINE,RATINGS,PRICEFOR2,LOCATION FROM RESTUARANTS_INFO WHERE LOCATION=?";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<Map<String, Object>> getRestaurantsByLocation(String location) {
		List<Map<String,Object>> list=null;
		list=jt.queryForList(GET_RESTS_BY_LOCATION,location);
		System.out.println(list.size());
		return list;
	}

}
