package com.nt.service;

import java.util.List;

import com.nt.dto.PassegenerDTO;

public interface ReservationMgmtService {
	
	public  String   performGroupReservation(List<PassegenerDTO> listDTO);

}
