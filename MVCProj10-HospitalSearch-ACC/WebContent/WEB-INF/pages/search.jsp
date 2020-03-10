<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<h1 style="color:red;text-align:center">Search Patients in Hospital </h1>

 <form action="search.htm" method="POST">
   Patient name:: <input type="text" name="pname"> <br>
   Patient addrs:: <input type="text" name="paddrs"> <br>
   Patient problem:: <input type="text" name="problem"> <br>
   Doctor name:: <input type="text" name="doctor"> <br> 
   <input type="submit" value="search">
 </form>
    