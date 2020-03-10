<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

 <form name="frm" method="POST">
   username ::  <input type="text" name="name"> <br>
   Address :: <input type="text" name="addrs"> <br>
   Email :: <input type="text" name="email"> <br>
   PhoneNumber :: <input type="text" name="phone"> <br>
   
   <input type="button" name="s1" value="add" onclick="send1()">
   <input type="button" name="s1" value="modify" onclick="send2()">
   <input type="button" name="s1" value="remove" onclick="send3()">
   <input type="button" name="s1" value="show" onclick="send4()">
 </form>    

  <c:if test="${!empty result }">
    ${result} is performed
    </c:if>
   <script language="javaScript">
    function send1(){
    	frm.action="insert.htm";
    	frm.submit();
    }
    function send2(){
    	frm.action="update.htm";
    	frm.submit();
    }
    function send3(){
    	frm.action="delete.htm";
    	frm.submit();
    }
    function send4(){
    	frm.action="view.htm";
    	frm.submit();
    }
   
    
   
   </script> 
    
    