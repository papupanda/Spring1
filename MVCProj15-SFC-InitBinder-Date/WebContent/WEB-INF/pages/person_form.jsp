<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>    

    
    <h1 style="color:red;text-aling:center">Person Registration Form</h1>
    
 <form:form commandName="perCmd">
    <p style="color:red">
      <form:errors path="*"/>
    </p>
    Person  name:: <form:input path="pname"/> <br>
    Person  address :: <form:input path="paddrs"/> <br>
    DOB ::  <form:input path="dob"/>(dd-MM-yyyy) <br>
    DOJ ::  <form:input path="doj"/>(dd-MM-yyyy) <br>
    DOM ::  <form:input path="dom"/>(dd-MM-yyyy) <br>
    <input type="submit"  value="register">
 </form:form>     