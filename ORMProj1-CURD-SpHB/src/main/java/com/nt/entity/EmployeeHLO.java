package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name="Employee")
@Data
@NamedQuery(name = "query1",query = "FROM EmployeeHLO WHERE salary>=:min AND salary<=:max")
public class EmployeeHLO implements Serializable {
	@Id
	@Column(name="EID",length = 10)
	@Type(type="int")
	@GenericGenerator(name = "gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private int eid;
	
	@Column(name="ENAME",length = 20)
	@Type(type="string")
	private String ename;
	
	@Column(name="EADD",length = 20)
	@Type(type="string")
	private String eadd;
	
	@Type(type="float")
	@Column(name="SALARY",length = 20)
	private float salary;
	
	

}
