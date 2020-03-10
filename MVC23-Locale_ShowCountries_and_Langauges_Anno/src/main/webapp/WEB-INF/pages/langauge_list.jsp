<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>



<body style="background-color:pink;
							  background-repeat: no-repeat;
							  background-attachment: fixed;
							  background-size: 100% 100% 
							  ">
 <h1 style="color:red;text-align:center;border=1;border-color: purple;background-color: yellow">ALL  LANGAUGE LIST</h1>
 

  <%
    String langauges[]=(String[])request.getAttribute("langaugesList");
    for(String c:langauges){
    	if(c!=null&& c.length()>0)
    	   out.println("<h3 style='color:blue'>"+c+"</h3>");
    }
 %>  
 <b></b> <br>
<br><br>
 <h3 style="color:lime;text-align:center;border=1;border-color: purple;background-color: lime"><a href="welcome.htm">home</a> </h3>    
 </body>
    
     