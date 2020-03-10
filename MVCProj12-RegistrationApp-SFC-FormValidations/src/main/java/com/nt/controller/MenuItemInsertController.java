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
	public Object formBackingObject(HttpServletRequest request) throws Exception {
		System.out.println("MenuItemInsertController.formBackingObject()");
		ItemDetailsCommand cmd=null;
		cmd=new ItemDetailsCommand();
		cmd.setItemName("rajma chawal");
		cmd.setCategory("indian");
		cmd.setPrice(60.0f);
		cmd.setRestaurant("street");
		return cmd;
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		String rMsg=null;
		ItemDetailsCommand cmd=null;
		ItemDetailsDTO dto=null;
		//type casting
		cmd=(ItemDetailsCommand) command;
		//application logioc errors
		if(cmd.getPrice()<50) {
			errors.rejectValue("price","idCmd.price.smallPrice");
			return showForm(req,res,errors);
		}
			
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
