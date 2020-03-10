<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

  <h1 style="color:green;text-align:center">JobSeeker registration page No-3 </h1>

  <form:form  commandName="regCmd">
   PrefferedLocation ::<form:input path="prefferedLocation"/> <br>
   Expected Salary:: <form:input path="expectedSalary"/> <br>
   Notice Period:: <form:input path="noticePeriod"/> <br>
   <input type="submit" name="_target1"  value="previous"> 
   <input type="submit" name="_finish"  value="finish"> 
   <input type="submit" name="_cancel"  value="cancel"> 
  </form:form>    
