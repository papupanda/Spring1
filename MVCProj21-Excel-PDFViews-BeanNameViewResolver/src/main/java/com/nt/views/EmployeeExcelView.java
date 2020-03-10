package com.nt.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.dto.EmployeeDTO;

public class EmployeeExcelView extends AbstractXlsView {

	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<EmployeeDTO> listDTO=null;
		Sheet sheet=null;
		Row row=null;
		int i=0,j=0;
		//get Model Attribute
		listDTO=(List<EmployeeDTO>) map.get("listDTO");
		//create Sheet in workbook and add rows to the sheet
		sheet=workbook.createSheet("Employee Report");
		for(EmployeeDTO dto:listDTO){
			j=0;
			row=sheet.createRow(i);
			row.createCell(j).setCellValue(String.valueOf(dto.getEid()));
			row.createCell(j+1).setCellValue(dto.getEname());
			row.createCell(j+2).setCellValue(dto.getDesg());
			row.createCell(j+3).setCellValue(String.valueOf(dto.getSalary()));
			row.createCell(j+4).setCellValue(dto.getEaddrs());
			i++;
		}//for
		
	}

}
