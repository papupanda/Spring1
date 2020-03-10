package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private  EmployeeRepo empRepo;

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		Employee empEntity=null,empEntity1=null;
		System.out.println(empRepo.getClass());
		//convert  DTO to BO/Entity
		empEntity=new Employee();
		BeanUtils.copyProperties(dto, empEntity);
		//use Repository
		empEntity1=empRepo.save(empEntity);
		if(empEntity1==null)
			return "Employee not registred";
		else
			return "Employee is registered with id value::"+empEntity1.getEid();
	}
	
	public  EmployeeDTO  fetchEmployeeById(int id) {
		Optional<Employee> opt=null;
		Employee entityEmp=null;
		EmployeeDTO   dto=null;
             //use repo
		   opt=empRepo.findById(id);
		   entityEmp=opt.get();
		   //convert Entity to DTO
		   dto=new EmployeeDTO();
		   BeanUtils.copyProperties(entityEmp, dto);
		   return dto;
	}
	
	@Override
	public List<EmployeeDTO> fetchAllEmployees() {
		Iterable<Employee> it;
		List<EmployeeDTO> listDTO=new ArrayList();
		//use repo
		  it=empRepo.findAll();
		  it.forEach(entity->{
			  EmployeeDTO dto=new EmployeeDTO();
			  BeanUtils.copyProperties(entity, dto);
			  listDTO.add(dto);
		  });
		  return listDTO;
	}
	
	@Override
	public List<EmployeeDTO> fetchEmpsByIds(int id1, int id2) {
		List<Integer> ids=new ArrayList();
		Iterable<Employee> it;
		List<EmployeeDTO> listDTO=new ArrayList();
		//prepare ids
		ids=new ArrayList();
		ids.add(id1);
		ids.add(id2);
		//use repo
		it=empRepo.findAllById(ids);
		//convert listEntities to listDTO
		it.forEach(entity->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTO.add(dto);
		});
		
		
		return listDTO;
	}
	
	@Override
	public List<EmployeeDTO> fetchEmpsBySalaryRange(float start, float end) {
         List<Employee> listEntities=null;
         List<EmployeeDTO> listDTO=new ArrayList();
         //use repo
         listEntities=empRepo.findEmpsBySalaryRange(start, end);
         listEntities.forEach(entity->{
 			EmployeeDTO dto=new EmployeeDTO();
 			BeanUtils.copyProperties(entity, dto);
 			listDTO.add(dto);
 		});
 		
 		
 		return listDTO;
		
	}
	
	@Override
	public float getEmpAvgSalary() {
		
		//use repo
		return empRepo.findAvgSalaryOfEmployee();
	}
	
	@Override
	public List<EmployeeDTO> fetchEmpsByAddrs(String addrs) {
	     List<Employee> listEntities=null;
	     List<EmployeeDTO> listDTO=new ArrayList();
	     //use reop
	     listEntities=empRepo.findByEadd(addrs);
	     //convert listEntities to listDTO
	     
	     listEntities.forEach(entity->{
	 			EmployeeDTO dto=new EmployeeDTO();
	 			BeanUtils.copyProperties(entity, dto);
	 			listDTO.add(dto);
	 		});
		return listDTO;
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int addBonusToEmployeesByAddresses(String addrs1, String addrs2, float bonus) {
		int  count=0;
		//use repo
		count=empRepo.updateEmpsSalaryForAddresses(addrs1,addrs2,bonus);
		return count;
	}

}
