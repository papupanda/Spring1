<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<body background="images/hospital.jpg" >
 <h1 style="color:red;text-align:center">Edit PAtient Details </h1>
 
 <form:form  method="POST" commandName="patientCmd">
  <table border="1" style="border-color:red;" align="center">
    
    <tr> <td>Patient Id :: </td> <td><form:input path="pid" disabled="true"/></td> </tr>  
    <tr><td>Patient Name ::</td> <td><form:input path="pname"/> </td> </tr>
    <tr><td>Patient Addrs ::</td><td> <form:input path="paddrs"/> </td>  </tr>
    <tr><td>Patient Age ::</td> <td> <form:input path="age"/> </td>  </tr>
    <tr><td> Patient Problem :: </td><td> <form:input path="problem"/></td>  </tr>
     <tr> <td>Contact Number ::</td> <td> <form:input path="contactNo"/> </td></tr>
   <tr><td> WardNo ::</td> <td> <form:input path="wardNo"/> </td></tr> 
   <tr><td> Doctor :: </td> <td> <form:input path="doctor"/> </td></tr>
    
    <tr> <td><input type="submit" value="update Patient"/> </td> 
          <td><input type="reset" value="cancel"/> </td>
    </tr>          
    </table>
 </form:form>
 
 </body>
 
 
 
  
    
    
