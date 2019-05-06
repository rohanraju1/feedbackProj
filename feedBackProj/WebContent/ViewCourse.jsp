<%@page import="org.cap.feedbackproj.dto.CourseDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>View Course</title>
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
         <td>Course_Id</td>
         <td>Course_Name</td>
          <td>No_of_days</td>         
        </tr>                       <!-- Iterate the List Object  data here  -->
        <%Iterator itr;%>
       <%
     List data=(List)request.getAttribute("courselst");
      for(itr=data.iterator();itr.hasNext();)
      {
    	  CourseDTO cdto=(CourseDTO)itr.next();
    	int courseId=cdto.getCourseId();
    	String courseName=cdto.getCourseName();
    	int courseDays=cdto.getNoOfDays();
    %>
   <tr>
     <td width="500"><%=courseId%></td>
     <td width="500"><%=courseName%></td>
     <td width="500"><%=courseDays%></td>
     <%}%>
   </tr>      
    </table>
     </div>
      


</body>
</html>