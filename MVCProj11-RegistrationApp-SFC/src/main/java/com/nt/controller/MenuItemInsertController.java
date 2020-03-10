package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.ItemDetailsCommand;
import com.nt.dto.ItemDetailsDTO;
import com.nt.service.MenuItemMgmtService;

public class MenuItemInsertController extends SimpleFormController {
	private MenuItemMgmtService service;

	public MenuItemInsertController(MenuItemMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		String rMsg=null;
		ItemDetailsCommand cmd=null;
		ItemDetailsDTO dto=null;
		//type casting
		cmd=(ItemDetailsCommand) command;
		//convert cmd to dto
		dto=new ItemDetailsDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use service
		rMsg=service.registerMenuItem(dto);
		//return MAV object
		return  new ModelAndView(getSuccessView(),"rMsg", rMsg);

	}
	
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("MenuItemInsertController.handleInvalidSubmit(-,-)");
		return new ModelAndView("dbl_post"); 
		
	}

}
