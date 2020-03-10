package com.nt.dao;


import java.util.List;
import java.util.Map;

public interface RestaurantDAO {
	public  List<Map<String,Object>>  getRestaurantsByLocation(String location);
}
