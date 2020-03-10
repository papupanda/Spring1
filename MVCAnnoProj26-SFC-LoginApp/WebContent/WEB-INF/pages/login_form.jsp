<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<h1 style="color:red;text-align:center"> Login Page </h1>

<form:form modelAttribute="userCmd">
    Login username :: <form:input path="user"/> <br>
    Login Password :: <form:input path="pwd"/> <br>
    Email domains ::  <form:radiobuttons path="domains" items="${emailDomainsList}"/> <br>
    Hobies :: <form:checkboxes items="${hobiesList}" path="hobies"/> <br>
    Countries :: <form:select path="country">
                                 <form:options items="${countriesList}"/>
                        </form:select> <br>
    <input type="submit"  value="Login"/>
    
</form:form>    
