<%@page import="java.sql.Date"%>
<%@page import="org.cap.feedbackproj.dto.TrainingProgramDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Program</title>
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
         <td>Training Code</td>
         <td>Course Name</td>
          <td>Faculty Name</td> 
          <td>Start Date</td>
          <td>End Date</td>        
        </tr>                       <!-- Iterate the List Object  data here  -->
        <%Iterator itr;%>
       <%
     List data=(List)request.getAttribute("prgmList");
      for(itr=data.iterator();itr.hasNext();)
      {
    	  TrainingProgramDTO tpDto=(TrainingProgramDTO)itr.next();
    	int tCode=tpDto.getTrainingCode();
    	String cName=tpDto.getCourseName();
    	String fName=tpDto.getFacultyName();
         Date sDate=tpDto.getsDate();
         Date eDate=tpDto.geteDate();
    %>
   <tr>
     <td width="500"><%=tCode%></td>
     <td width="500"><%=cName%></td>
     <td width="500"><%=fName%></td>
     <td width="500"><%=sDate%></td>
     <td width="500"><%=eDate%></td>
     <%}%>
   </tr>      
    </table>
     </div>
      


</body>
</html>