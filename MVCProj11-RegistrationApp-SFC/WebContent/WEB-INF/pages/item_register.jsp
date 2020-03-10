<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:red;text-align:center">Item RegistrationProcess </h1>

<form:form  commandName="idCmd">
  <b> Item name ::</b> <form:input path="itemName"/> <br>
  <b> Item category ::</b> <form:input path="category"/> <br>
  <b> Item price ::</b> <form:input path="price"/> <br>
  <b> Item Status ::</b> <form:input path="status"/> <br>
  <b> Restaurant name ::</b> <form:input path="restaurant"/> <br>
  <input type="submit"  value="register">
</form:form>
