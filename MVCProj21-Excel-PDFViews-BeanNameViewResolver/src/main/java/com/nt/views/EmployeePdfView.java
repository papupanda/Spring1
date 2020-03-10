package com.nt.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.EmployeeDTO;

public class EmployeePdfView extends AbstractPdfView {

	@Override
	public  void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<EmployeeDTO> listDTO=null;
		Paragraph para=null;
		Table table=null;
		//get Model attribute
		listDTO=(List<EmployeeDTO>)map.get("listDTO");
		//create Paragraph and add to Document object
	  para=new Paragraph(Font.BOLDITALIC,"EmployeeReport");
	  doc.add(para);
	  //create table having Employee details and added to Document
	  table=new Table(5,listDTO.size());
	 for(EmployeeDTO dto:listDTO) {
		  table.addCell(String.valueOf(dto.getEid()));
		  table.addCell(dto.getEname());
		  table.addCell(dto.getEaddrs());
		  table.addCell(dto.getDesg());
		  table.addCell(String.valueOf(dto.getSalary()));
	  }
	 doc.add(table);	
	}

}
