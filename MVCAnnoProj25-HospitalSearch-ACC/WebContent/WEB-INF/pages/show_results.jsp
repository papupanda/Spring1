<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <c:choose>
   <c:when test="${!empty listRDTO}">
     <table border="1">
       <tr>
          <th>srNo</th><th>patientId</th><th>patientName</th><th>patientAddrs</th><th>problem</th><th>doctor</th><th>wardno</th><th>contactNo</th><th>age</th> 
       </tr>
       <c:forEach var="dto" items="${listRDTO}">
         <tr>
          <td>${dto.srNo}</td>
          <td>${dto.pid}</td>
          <td>${dto.pname}</td>
          <td>${dto.paddrs}</td>
          <td>${dto.problem}</td>
          <td>${dto.doctor}</td>
          <td>${dto.wardNo}</td>
          <td>${dto.contactNo}</td>
          <td>${dto.age}</td>
         </tr>
       </c:forEach>
     </table>
   </c:when>
   <c:otherwise>
      <h1 style="color:red;text-align:center">Records not found </h1>
   </c:otherwise>
 </c:choose>    
 <br><bR>
  <b><a href="home.htm">Search again</a> </b>

    