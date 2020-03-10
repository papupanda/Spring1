<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

  <h1 style="color:green;text-align:center">JobSeeker registration page No-2 </h1>

  <form:form  commandName="regCmd">
   skill Domain ::<form:input path="skillDomain"/> <br>
   current Company:: <form:input path="currentCompany"/> <br>
   Experience:: <form:input path="experience"/> <br>
   <input type="submit" name="_target0"  value="previous"> 
   <input type="submit" name="_target2"  value="next"> 
   <input type="submit" name="_cancel"  value="cancel"> 
  </form:form>    
