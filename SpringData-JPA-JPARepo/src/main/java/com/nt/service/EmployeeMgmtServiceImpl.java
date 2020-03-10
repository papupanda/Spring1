package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
import com.nt.repo.EmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public void showAllEmployeesPageWise(int pageSize) {
		int recordsCount=0;
		int pagesCount=0;
		Pageable pageable=null;
		Page<Employee> page=null;
		//use repo
		  //get records count
		recordsCount=(int) empRepo.count();
		 //get pagesCount
		pagesCount=recordsCount/pageSize;
		if(recordsCount%pageSize!=0)
			pagesCount++;
		 //display records page by page
		for(int pageNo=0;pageNo<pagesCount;++pageNo) {
			//get Pagable Object
			pageable=PageRequest.of(pageNo, pageSize, Sort.by("ename").descending());
			//display each page records
			page=empRepo.findAll(pageable);
			page.forEach(emp->{
				System.out.println(emp);
			});
			System.out.println("-------"+(pageNo+1)+" of"+pagesCount);
			
		}
	}//method
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String removeEmployeeInBatch(List<EmployeeDTO> batchDTO) {
	     List<Employee> batchEntites=new ArrayList();
		//convert batchDTO to BaatchEntities
		batchDTO.forEach(dto->{
			Employee emp=new Employee();
			BeanUtils.copyProperties(dto,emp);
			batchEntites.add(emp);
		});
		
		try {
		//use repo
		  empRepo.deleteInBatch(batchEntites);
		  empRepo.flush();
		  return "Batch of Employees are deleted";
		}
		catch(Exception e) {
			return "Batch of Employees are not deleted";
		}
		
		
		
		
		
	}
	
	
	
	
	



}
