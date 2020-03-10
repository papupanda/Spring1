package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.entity.EmployeeHLO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private EmployeeDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int registerEmployee(EmployeeDTO dto) {
		EmployeeHLO hlo=null;
		int idVal=0;
		// convert DTO to HLO
		hlo=new EmployeeHLO();
		BeanUtils.copyProperties(dto, hlo);
		//use dao
		idVal=dao.insert(hlo);
		return idVal;
	}

	@Override
	public EmployeeDTO fetchEmpById(int id) {
		EmployeeHLO hlo=null;
		EmployeeDTO dto=null;
		//use DAO
		hlo=dao.getEmpById(id);
		//convert hlo to DTO
	    dto=new EmployeeDTO();
	    BeanUtils.copyProperties(hlo,dto);
		return dto;
	}
	
	@Override
	public List<EmployeeDTO> fetchEmpsByAddresses(String addrs1, String addrs2) {
		List<EmployeeHLO> listHLO=null;
		List<EmployeeDTO> listDTO=null;
		//use DAO
		listHLO=(List<EmployeeHLO>) dao.getEmpsByAddresses(addrs1, addrs2);
		//convert listHLO to listDTO
		listDTO=new ArrayList();
		for(EmployeeHLO hlo:listHLO) {
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(hlo,dto);
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public List<EmployeeDTO> fetchEmpsByAddresses1(String addrs1, String addrs2) {
		List<EmployeeHLO> listHLO=null;
		List<EmployeeDTO> listDTO=null;
		//use DAO
		listHLO=(List<EmployeeHLO>) dao.getEmpsByAddresses1(addrs1, addrs2);
		//convert listHLO to listDTO
		listDTO=new ArrayList();
		for(EmployeeHLO hlo:listHLO) {
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(hlo,dto);
			listDTO.add(dto);
		}
		return listDTO;
	}
	
	@Override
	public List<EmployeeDTO> fetchEmpsBySalaryRange(float start, float end) {
		
		List<EmployeeHLO> listHLO=null;
		List<EmployeeDTO> listDTO=null;
		//use DAO
		listHLO=(List<EmployeeHLO>) dao.getEmpsBySalaryRange(start, end);
		//convert listHLO to listDTO
		listDTO=new ArrayList();
		for(EmployeeHLO hlo:listHLO) {
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(hlo,dto);
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int removeEmpsBySalaryMark(float maxSalary) {
		int count=0;
		count=dao.fireEmpsBySalaryMark(maxSalary);
		return count;
	}

	@Override
	public int hikeEmpsSalaryByAddrs(String addrs, float percentage) {
		int count=0;
		//use DAO
		count=dao.updateEmpsSalaryByAddrs(addrs,percentage);
		return count;
	}

}
