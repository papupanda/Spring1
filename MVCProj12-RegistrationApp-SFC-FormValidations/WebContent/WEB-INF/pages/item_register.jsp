<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:red;text-align:center">Item RegistrationProcess </h1>

<form:form  commandName="idCmd"  onsubmit="return validate(this)">
  <%--   <p style="color:red">
<%--        <form:errors path="*"/>
    </p> <br> --%>
 <%--  <b> Item name ::</b> <form:input path="itemName"/><form:errors path="itemName" cssStyle="color:red"/>  <br>
  <b> Item category ::</b> <form:input path="category"/><form:errors path="category" cssStyle="color:red"/> <br>
  <b> Item price ::</b> <form:input path="price"/><form:errors path="price" cssStyle="color:red"/> <br>
  <b> Item Status ::</b> <form:input path="status"/><form:errors path="status" cssStyle="color:red"/> <br>
  <b> Restaurant name ::</b> <form:input path="restaurant"/><form:errors path="restaurant" cssStyle="color:red"/> <br>
 --%> 
   
   <b> Item name ::</b> <form:input path="itemName"/><form:errors path="itemName"/><span id="itemNameError"> </span> <br>
  <b> Item category ::</b> <form:input path="category"/><form:errors path="category" /><span id="categoryError"> </span> <br>
  <b> Item price ::</b> <form:input path="price"/><form:errors path="price" /><span id="priceError"> </span> <br>
  <b> Item Status ::</b> <form:input path="status"/><form:errors path="status" /><span id="statusError"> </span> <br>
  <b> Restaurant name ::</b> <form:input path="restaurant"/><form:errors path="restaurant"/><span id="restaurantError"> </span> <br>
    <form:hidden path="vflag" />
 
  <input type="submit"  value="register">
</form:form>
  <style type="text/css">
   span{color:red;font-size: 10px;   }
</style>
 <script language="JavaScript">
   function validate(frm){
	   
	   //read formd data
	  var name=frm.itemName.value;
	  var category=frm.category.value;
	  var price=frm.price.value;
	  var status=frm.status.value;
	  var restaurant=frm.restaurant.value;
	  //empty form validation error pages
	     document.getElementById("itemNameError").innerHTML="";
	     document.getElementById("categoryError").innerHTML="";
	     document.getElementById("priceError").innerHTML="";
	     document.getElementById("statusError").innerHTML="";
	     document.getElementById("restaurantError").innerHTML="";
	  //set vflag value to true indicating client side form validation logics
	  //are executing
	    frm.vflag.value=true;
	  
	  //write server client form validation logic
	  if(name==""){
		  document.getElementById("itemNameError").innerHTML="Item name is mandatory";
		  frm.itemName.focus();
		  return false;
	  }
	  if(category==""){
		  document.getElementById("categoryError").innerHTML="Item category is mandatory";
		  frm.category.focus();
		  return false;
	  }
	  if(price==""){
		  document.getElementById("priceError").innerHTML="Item price is mandatory";
		  frm.price.focus();
		  return false;
	  }
	  else if(isNaN(price)){
		  document.getElementById("priceError").innerHTML="Item price must be numerice value";
		  frm.price.focus();
		  return false;
	  }
	  else if(price<=0){
		  document.getElementById("priceError").innerHTML="Item price must be positive number";
		  frm.price.focus();
		  return false;
	  }
	  
	  if(status==""){
		  document.getElementById("statusError").innerHTML="Item Status is mandatory";
		  frm.status.focus();
		  return false;
	  }
	  
	  if(restaurant==""){
		  document.getElementById("restaurantError").innerHTML="Restaurant name is mandatory";
		  frm.restaurant.focus();
		  return false;
	  }
	  else if(restaurant.length<5){
		  document.getElementById("restaurantError").innerHTML="Restaurant name must have minimum of 5 chars";
		  frm.restaurant.focus();
		  return false;
	  }
	  return true;
   }//function
 </script>
 
