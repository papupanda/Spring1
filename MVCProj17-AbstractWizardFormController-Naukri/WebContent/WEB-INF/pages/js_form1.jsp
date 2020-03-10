<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

  <h1 style="color:green;text-align:center">JobSeeker registration page No-1 </h1>

  <form:form  commandName="regCmd">
   name ::<form:input path="name"/> <br>
   address:: <form:input path="addrs"/> <br>
   age:: <form:input path="age"/> <br>
   <input type="submit" name="_target1"  value="next"> 
   <input type="submit" name="_cancel"  value="cancel"> <br>
  </form:form>    
