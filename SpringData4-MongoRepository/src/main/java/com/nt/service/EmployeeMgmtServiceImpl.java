package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.model.Employee;
import com.nt.repository.EmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
   private  EmployeeRepository empRepo;
	
	@Override
	public String registerEmployee(EmployeeDTO dto) {
		Employee doc=null,doc1=null;
		//convert DTO to model
		doc=new  Employee();
		BeanUtils.copyProperties(dto, doc);
		//save Deocument
		doc1=empRepo.save(doc);
		if(doc1!=null)
			 return "Emp Document is saved";
		else
			 return "Emp Document is not saved";
	}
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> listDoc=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		//use repo
		listDoc=empRepo.findAll();
		//convert listDoc to listDTO
		 listDoc.forEach(doc->{
			 EmployeeDTO dto=new EmployeeDTO();
			 BeanUtils.copyProperties(doc, dto);
			 listDTO.add(dto);
		 });
		return listDTO;
	}
	
	@Override
	public String updateEmployeeById(int id,String[] newAddrs) {
		Optional<Employee> doc=null;
		Employee emp=null,emp1=null;
		//get the Document
		doc=empRepo.findById(id);
		emp=doc.get();
		//modify the object
		emp.setAddrs(newAddrs);
		//save obj for updation
		emp1=empRepo.save(emp);
		if(emp1!=null)
 		     return "Object is updated";
		else
			 return "Object is not updated";
	}

}
