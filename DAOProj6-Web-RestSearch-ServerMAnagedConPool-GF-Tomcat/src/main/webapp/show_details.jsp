<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:choose>
    <c:when test="${!empty restList}">
           <h1 style="color:green;text-align:center">The following Restaurants are found</h1>
         <table border="1" style="color:red">
            <tr> <th>Id</th><th>name</th><th>Type </th><th>cusine</th><th>Ratings</th><th>location</th><th>priceFor2</th> </tr>
              <c:forEach var="map"  items="${restList}">
                   <tr>
                     <td>${map.RESTID}</td>
                     <td>${map.RESTNAME}</td>
                     <td>${map.RESTTYPE}</td>
                     <td>${map.CUSINE}</td>
                     <td>${map.RATINGS}</td>
                     <td>${map.LOCATION}</td>
                     <td>${map.PRICEFOR2}</td>
                   </tr>
              </c:forEach>            
         </table>
    </c:when>
    <c:otherwise>
            <h1 style="color:red;text-align:center">No Restaurants are found</h1>
    </c:otherwise>
</c:choose>
 <br><br>
 <a href="JavaScript:showprint()"><img src="print1.jpg"  width="50" height="40"></a>
 
 <script language="JavaScript">
    function showprint(){
            frames.focus();
            frames.print();
    }
</script>

 <br><br>
 <a href="search.html"><img src="home1.png" width="50" height="70"></a>

