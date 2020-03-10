package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.PassegenerBO;
import com.nt.dao.ReservationDAO;
import com.nt.dto.PassegenerDTO;

@Service("reservationService")
public class ReservationMgmtServiceImpl implements ReservationMgmtService {
	@Autowired
	private  ReservationDAO dao;

	@Override
	public String performGroupReservation(List<PassegenerDTO> listDTO) {
		List<PassegenerBO> listBO=new ArrayList();
		int result[]=null;
		//convert listDTO to listBO
		listDTO.forEach(dto->{
			PassegenerBO bo=new PassegenerBO();
			BeanUtils.copyProperties(dto, bo);
			listBO.add(bo);
		});
		//use dAO
		result=dao.insertGroup(listBO);
		if(result!=null)
			return "Group Ticket Reservation succeded";
		else
			return "Group Ticket Reservation failed";
		
	}//method
}//class
