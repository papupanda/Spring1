package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

@Controller
@SessionAttributes(value = "userCmd",types = UserCommand.class)
public class LoginController {
	@Autowired
	private  LoginService service;
	
	/*@GetMapping("/login.htm")  // for Initial Phase request
	public  String  showForm(@ModelAttribute("userCmd")UserCommand cmd) {
		//dynamic initial values to Command object 
		cmd.setUser("raja");
		return "login_form";
	}*/
	
	
		@GetMapping("/login.htm")  // for Initial Phase request
		public  String  showForm(Map<String,Object> map) {
			UserCommand cmd=null;
			//create Command object
			cmd=new UserCommand();
			cmd.setUser("raja");
			map.put("userCmd",cmd);
			return "login_form";
		}
	
	@PostMapping("/login.htm")   //for post back request
	public String  processForm(Map<String,Object> map,
			                                          @ModelAttribute("userCmd")UserCommand cmd) {
		UserDTO dto=null;
		String result=null;
		//convert cmd  to DTO
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use service
		result=service.validate(dto);
		//keep result as model attribute
		map.put("resultMsg",result);
		map.put("cmdData", cmd);
		return "login_result";
	}
	
	@ModelAttribute("emailDomainsList")
	public   List<String> populateEmailDomain(){
		List<String> list=null;
		list=new ArrayList();
		list.add("gmail"); list.add("yahoo"); list.add(".net");
		return list;
		
	}
	
	@ModelAttribute("hobiesList")
	public   List<String> populateHobies(){
		List<String> list=null;
		list=new ArrayList();
		list.add("travelling"); list.add("sleeping"); list.add("gossiping");
		list.add("eating"); list.add("drinking"); list.add("singing");
		return list;
		
	}
	
	@ModelAttribute("countriesList")
	public   List<String> populateCountries(){
		List<String> list=null;
		list=new ArrayList();
		list.add("india"); list.add("pakistan"); list.add("Afganistan");
		list.add("china"); list.add("singapore"); list.add("malasiya");
		return list;
		
	}
	
	

}
