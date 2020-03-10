package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.ProductBO;
import com.nt.dao.ProductDAO;
import com.nt.dto.ProductDTO;

@Service("prodService")
public class ProductMgmtServiceImpl implements ProductMgmtService {
	@Autowired
	private ProductDAO dao;

	@Override
	public String registerProduct(ProductDTO dto) {
		int count=0;
		ProductBO bo=null;
		//convert dto to bo
		bo=new ProductBO();
		BeanUtils.copyProperties(dto, bo);
		//use DAO
		count=dao.insert(bo);
		//process the result
		if(count==0)
			return "Product registation failed";
		else
			return "Product registation succeded";
	}//main
}//class
