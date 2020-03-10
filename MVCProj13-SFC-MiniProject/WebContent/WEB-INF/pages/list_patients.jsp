<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body style="background-image:url(images/hospital.jpg)" onkeydown="disableF5(event)" onclick="disableF5(event)" >
<c:choose>
  <c:when test="${!empty listDTO }">
  
    <table border="1">
      <caption>All Patients details</caption>
      <tr style="border-color:red;background-color: cyan" >
        <th>srNo</th> <th>pid</th> <th>pname</th><th>paddrs</th><th>age</th><th>contactNo</th><th>problem</th><th>doctor</th><th>wardno</th><th>Operations</th>
      </tr>
      <c:forEach var="dto" items="${listDTO}">
        <tr style="border-color:green;background-color: yellow ">
          <td>${dto.srNo} </td>
          <td>${dto.pid} </td>
          <td>${dto.pname} </td>
          <td>${dto.paddrs} </td>
          <td>${dto.age} </td>
          <td>${dto.contactNo} </td>
          <td>${dto.problem} </td>
          <td>${dto.doctor} </td>
          <td>${dto.wardNo} </td>
          <td> <a href="patient_edit.htm?id=${dto.pid}"><img src="images/edit.jpg" width="20" height="30" title="edit patient"/></a>
                &nbsp;&nbsp;&nbsp;
               <a href="patient_delete.htm?id=${dto.pid}"  onclick="return confirm('are u sure to delete???')"><img src="images/delete.jpg" width="20" height="30" title="delete patient"/></a>
           </td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
     <h1 style="color:red"> Records not found </h1>
  </c:otherwise>

</c:choose>
 <br>
    <h2 style="color:green;text-align:center">${resultMsg}</h2>
    <br>
     <a href="home.htm"><img src="images/home.png" width="100" height="100"/></a>
     
 <script type = "text/javascript">
 function disableF5(e)
 {
	 alert(e.keyCode)
	  if ((e.which || e.keyCode) == 116 || (e.which || e.keyCode) == 82 || (e.which || e.keyCode) == 10227){
		   
		      e.preventDefault();
	  }
  };
</script>  
     
</body>