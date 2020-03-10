<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
    
<h1 style="color:red;text-align:center">Registration form </h1>

  <form:form commandName="regCmd">
     <p style="color:red">
       <form:errors path="*"/>
     </p>
     PErson name:: <form:input path="name"/> <br>
     Person age:: <form:input path="age"/> <br>
     Person gender:: <form:radiobuttons path="gender" items="${genderInfo}" /> <br>
     Person hobies ::<form:checkboxes path="hobies" items="${hobiesInfo}" /> <br>
     Country :: <form:select path="country">
                     <form:options items="${countriesInfo}"/>
                  </form:select> <br>
     Favourite Colors :: <form:select path="colors" multiple="multiple">
                            <form:options items="${colorsInfo}"/>
                        </form:select> <br>
       <input  type="submit"  value="register">                                          
  </form:form>    
