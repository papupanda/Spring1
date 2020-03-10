<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 
 
 <c:choose>
   <c:when test="${!empty listJobs}">
          <h3 style="color:green;text-align:center">Trending Jobs on ${sysDate}</h3>
     <table border="1">
       <tr style="background-color: cyan;color: red"><th>SR.NO</th><th>JOBID</th><th>COMPANY</th><th>DOMAIN</th> <th>POSITION</th> <th>SALARYRANGE</th><th>NOP </th><th>Experience Range</th> <th>LOCATION </th> </tr>
         <c:forEach var="dto" items="${listJobs}">
            <tr style="background-color: pink">
              <td>${dto.srNo} </td>
              <td>${dto.jobId} </td>
              <td>${dto.company} </td>
              <td>${dto.domain} </td>
              <td>${dto.position} </td>
              <td>${dto.salaryRange} </td>
               <td>${dto.nop} </td>
              <td>${dto.expRange} </td>
              <td>${dto.location} </td>
            </tr>
         </c:forEach>
     </table>
   </c:when>
   <c:otherwise>
         <h1 style="color:red;text-align:center">No Records are found</h1>
   </c:otherwise>
 </c:choose>
 <br><br>
   <b><a href="home.htm">home</a></b>
   <br><br>
   <a href="JavaScript:doPrint()">print</a>
   <script language="JavaScript">
      function doPrint(){
         frames.focus();
         frames.print();
          }
   </script>
    
   
    
 
 
     
    
    
