<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

 <form action="operations.htm" method="POST">
   username ::  <input type="text" name="name"> <br>
   Address :: <input type="text" name="addrs"> <br>
   Email :: <input type="text" name="email"> <br>
   PhoneNumber :: <input type="text" name="phone"> <br>
   
   <input type="submit" name="s1" value="insert">
   <input type="submit" name="s1" value="update">
   <input type="submit" name="s1" value="delete">
   <input type="submit" name="s1" value="view">
 </form>    

  <c:if test="${!empty result }">
    ${result} is performed
    </c:if>
    