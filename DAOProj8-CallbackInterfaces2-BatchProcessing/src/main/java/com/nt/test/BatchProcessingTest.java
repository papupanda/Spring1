package com.nt.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.PassegenerDTO;
import com.nt.service.ReservationMgmtService;

public class BatchProcessingTest {

	public static void main(String[] args) {
		Scanner sc=null;
		int groupSize=0;
		String sourcePlace=null,destPlace=null;
		int fare=0;
		PassegenerDTO  dto=null;
		List<PassegenerDTO> listDTO=null;
		String name=null;
		int age=0;
		ApplicationContext ctx=null;
		ReservationMgmtService service=null;
		//read inputs
		sc=new Scanner(System.in);
		if(sc!=null) {
			System.out.println("enter group size::");
			groupSize=sc.nextInt();
			System.out.println("enter source Place::");
			sourcePlace=sc.next();
			System.out.println("enter dest place::");
			destPlace=sc.next();
			System.out.println("Ticket Price::");
			fare=sc.nextInt();
		}
		//create ListDTO  having passenger's info
		listDTO=new ArrayList();
		for(int i=1;i<=groupSize;++i) {
			System.out.println("enter "+i+" passenger name::");
			name=sc.next();
			System.out.println("enter "+i+" passenger age::");
			age=sc.nextInt();
			//create DTO class obj having each passenger's info
			dto=new PassegenerDTO();
			dto.setPsngrName(name); dto.setAge(age);
			dto.setSource(sourcePlace); dto.setDestination(destPlace);
			dto.setFare(fare);
			//add each dto to listDTO
			listDTO.add(dto);
 		}
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service=ctx.getBean("reservationService",ReservationMgmtService.class);
		//invoke the methods
		try {
			System.out.println(service.performGroupReservation(listDTO));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}

	}//main
}//class
