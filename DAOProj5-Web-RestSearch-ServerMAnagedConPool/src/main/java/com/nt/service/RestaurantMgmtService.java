package com.nt.service;

import java.util.List;
import java.util.Map;

public interface RestaurantMgmtService {
	public  List<Map<String,Object>>  searchRestaurantsByLocation(String location);

}
