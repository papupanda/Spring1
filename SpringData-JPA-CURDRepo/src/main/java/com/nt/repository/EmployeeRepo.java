package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Employee;

//@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	@Query("from Employee where salary>=:min and salary<=:max")
	public List<Employee> findEmpsBySalaryRange(@Param("min")float start,@Param("max")float end);
	
	@Query("select avg(salary)from Employee")
	public float findAvgSalaryOfEmployee();
	
	public List<Employee>  findByEadd(String eadd);
	
	@Query("update Employee set salary=salary+:bns where eadd in(:ad1,:ad2)")
	@Modifying
	public  int updateEmpsSalaryForAddresses(@Param("ad1")String addrs1,@Param("ad2")String addrs2,@Param("bns")float bonus);
	

}
