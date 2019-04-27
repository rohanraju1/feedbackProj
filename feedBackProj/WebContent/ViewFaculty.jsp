<%@page import="org.capG.feedBackProj.dto.EmployeeDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Faculty</title>
<link rel="stylesheet" href="./fb.css">
 <style>
       td
       {
           height: 100px;
           width:700px;
       }
    </style>

</head>
<body>
<h1 align="center">View Details</h1>
  <div id="viewForm">
         <br><br>
      <table align="center" border="4" width="400">
        <tr>
         <td>Faculty_Id</td>
         <td>Faculty_Name</td>
          <td>Role</td>         
        </tr>                       <!-- Iterate the List Object  data here  -->
        <%Iterator itr;%>
       <%
     List data=(List)request.getAttribute("datalist");
      for(itr=data.iterator();itr.hasNext();)
      {
    	  EmployeeDTO edto=(EmployeeDTO)itr.next();
    	  Integer id=edto.getEmployeeId();
    	  String name=edto.getEmployeeName();
    	  String role=edto.getRole();
    %>
   <tr>
     <td width="500"><%=id%></td>
     <td width="500"><%=name%></td>
     <td width="500"><%=role%></td>
     <%}%>
   </tr>      
    </table>
     </div>
      



</body>
</html>