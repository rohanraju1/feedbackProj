<%@page import="java.util.Iterator"%>
<%@page import="org.cap.feedbackproj.dto.EmployeeDTO"%>
<%@page import="org.cap.feedbackproj.dto.CourseDTO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add FeedBack</title>
  <link rel="stylesheet" href="fb.css">
</head>
<body bgcolor="#3498DB">
    <div id="fbform">
    <form action="addFb">
    <br><br>
             <table align="center" cellspacing="15" cellpadding="10">
                  <th>Add FeedBack</th>
                <tr>
                    <td>
                        <Label>Trainer:</Label>
                    </td>
                    <td>
                    <%
                    @SuppressWarnings("unchecked")                    
                    Map<CourseDTO,EmployeeDTO> map=(Map<CourseDTO,EmployeeDTO>)request.getAttribute("mapData");
                    %>
                        <select name="Trainer-Name">
					<%
					    for(Object ob1:map.keySet() )
					    {
					    	CourseDTO cDto=(CourseDTO)ob1;
					%>               
                
                <option>
                <%=cDto.getCourseName() %>
                </option>
                 <%} %>
                 </select>
                    </td>
                </tr>
                <tr>
                <%
                for(Object ob2:map.values() )
			    {
                     EmployeeDTO eDto=(EmployeeDTO)ob2;			
                %>
                 <td><Label>Training Code:</Label></td>
                 <td><select name="tcode" >
                     <option>
                     <%=eDto.getEmployeeName()%>
                     </option>
                   <%} %>
                 </select></td>
                </tr>
              <tr>
                  <td>Pr Comm:</td>
                  <td><input type="radio" name="pr1"value="5">5<input type="radio" name="pr1"value="4">4
                  <input type="radio" name="pr1" value="3">3<input type="radio" name="pr1" value="2">2
                  <input type="radio" name="pr1" value="1">1</td>
              </tr>
              <tr>
                    <td>Clrfy Dbts:</td>
                    <td><input type="radio" name="clr1"value="5">5<input type="radio" name="clr1"value="4">4
                    <input type="radio" name="clr1" value="3">3<input type="radio" name="clr1" value="2">2
                    <input type="radio" name="clr1" value="1">1</td>
                </tr>
                <tr>
                        <td>TM</td>
                        <td><input type="radio" name="tm1"value="5">5<input type="radio" name="tm1"value="4">4
                        <input type="radio" name="tm1" value="3">3<input type="radio" name="tm1" value="2">2
                        <input type="radio" name="tm1" value="1">1</td>
                    </tr>
                    <tr>
                            <td>Handouts:</td>
                            <td><input type="radio" name="hnd1" value="5">5<input type="radio" name="hnd1" value="4">4
                            <input type="radio" name="hnd1" value="3">3<input type="radio" name="hnd1" value="2">2
                            <input type="radio" name="hnd1" value="1">1</td>
                        </tr>
                        <tr>
                                <td>Hw_sW_Ntwrk:</td>
                                <td><input type="radio" name="hwsw" value="5">5<input type="radio" name="hwsw" value="4">4
                                <input type="radio" name="hwsw" value="3">3<input type="radio" name="hwsw" value="2">2
                                <input type="radio" name="hwsw" value="1">1</td>
                            </tr>
                            <tr>
                            <td>Comments:</td>
                            <td><textarea name="txtcommts" cols="50" rows="5" maxlength="200"></textarea></td>       
                            </tr>
                            <tr>
                                <td>
                                    Suggestions:
                                </td>
                                <td>
                                    <textarea name="txtsuggstn"  cols="50" rows="5" maxlength="200"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                </td>
                        
                                <td align="center">
                                          <input type="submit" value="Submit">
                                    </td>
                                    
                            </tr>
             </table>

    </form>
</div>
</body>





</html>