package com.nit.service;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service("localeService")
public class LocaleServiceImpl implements LocaleService {

	@Override
	public String generateCountry(HttpServletRequest req,HttpServletResponse res) {
		
		Locale locales[]=null;
		 String countries[]=null;
		 int i=0;
		 //get All Locales
		 locales=Locale.getAvailableLocales();
		 countries=new String[locales.length];
		 for(Locale lcl:locales) {
			 countries[i]=lcl.getDisplayCountry();
			 i++;
		 }
		 
		 //keep the result in request scope
		 req.setAttribute("countriesList",countries);
		 //return lvn
		return "countries";
	}

	@Override
	public String generateLangauge(HttpServletRequest req,HttpServletResponse res) {
		
		Locale locales[]=null;
		 String langauges[]=null;
		 int i=0;
		 //get All Locales
		 locales=Locale.getAvailableLocales();
		 langauges=new String[locales.length];
		 for(Locale lcl:locales) {
			 langauges[i]=lcl.getDisplayLanguage();
			 i++;
		 }
		 
		 //keep the result in request scope
		 req.setAttribute("langaugesList",langauges);
		 //return lvn
		return "langauges";
	}

}
