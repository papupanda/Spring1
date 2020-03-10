package com.nt.beans;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class PersonAadharDetails {
	private long ano;
	private  String  name;
	private  Date dob;
	private  String verifies[];
	private  byte age;
	private  File  photoPath;
	private   URL  linkedInUrl;
	private   boolean  isSingle;
	private   char gender;
	private    Class   favoriteJavaClass;
	private double income;
	private  Locale  currentLocale;
	private  Currency  currency;
	private  char[]  intials;
	
	
	public void setAno(long ano) {
		this.ano = ano;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setVerifies(String[] verifies) {
		this.verifies = verifies;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public void setPhotoPath(File photoPath) {
		this.photoPath = photoPath;
	}
	public void setLinkedInUrl(URL linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}
	public void setSingle(boolean isSingle) {
		this.isSingle = isSingle;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setFavoriteJavaClass(Class favoriteJavaClass) {
		this.favoriteJavaClass = favoriteJavaClass;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public void setIntials(char[] intials) {
		this.intials = intials;
	}
	
	
	@Override
	public String toString() {
		return "PersonAadharDetails [ano=" + ano + ", name=" + name + ", dob=" + dob + ", verifies="
				+ Arrays.toString(verifies) + ", age=" + age + ", photoPath=" + photoPath + ", linkedInUrl="
				+ linkedInUrl + ", isSingle=" + isSingle + ", gender=" + gender + ", favoriteJavaClass="
				+ favoriteJavaClass + ", income=" + income + ", currentLocale=" + currentLocale + ", currency="
				+ currency + ", intials=" + Arrays.toString(intials) + "]";
	}
	
	
	

}
