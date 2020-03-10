package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.RestaurantDAO;
import com.nt.dao.RestaurantDAOImpl;

@Service("restService")
public class RestaurantMgmtServiceImpl implements RestaurantMgmtService {
	@Autowired
	private  RestaurantDAO dao;

	@Override
	public List<Map<String, Object>> searchRestaurantsByLocation(String location) {
		List<Map<String,Object>> list=null;
		//use DAO
		list=dao.getRestaurantsByLocation(location);
		System.out.println(list.size());
		return list;
	}

}
