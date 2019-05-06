<%@page import="org.cap.feedbackproj.dto.ParticipantDTO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Participant</title>
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

<h1 align="center">View Participant Details</h1>
  <div id="viewForm">
         <br><br>
      <table align="center" border="4" width="400">
        <tr>
         <td>Participant Id</td>
         <td>Participant Name</td>
          <td>Course Name</td> 
          <td>Training Code</td>
        </tr>                       <!-- Iterate the List Object  data here  -->
        <%Iterator<ParticipantDTO> itr;%>
       <%
     List data=(List)request.getAttribute("partcipList");
      for(itr=data.iterator();itr.hasNext();)
      {
    	 ParticipantDTO participantDTO=(ParticipantDTO)itr.next();
            int pCode=participantDTO.getParticipantCode();
            String pName=participantDTO.getParticipantName();
            String cName=participantDTO.getCourseName();
            int tCode=participantDTO.getTrainingCode();
    %>
   <tr>
     <td width="500"><%=pCode%></td>
     <td width="500"><%=pName%></td>
     <td width="500"><%=cName%></td>
     <td width="500"><%=tCode%></td>
     <%}%>
   </tr>      
    </table>
     </div>
      


</body>
</html>