package org.cap.feedbackproj.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cap.feedbackproj.dto.CourseDTO;
import org.cap.feedbackproj.dto.EmployeeDTO;
import org.cap.feedbackproj.dto.FacultyDTO;
import org.cap.feedbackproj.dto.FeedBackDTO;
import org.cap.feedbackproj.dto.ParticipantDTO;
import org.cap.feedbackproj.dto.TrainingProgramDTO;
import org.cap.feedbackproj.util.DBUtils;

public  class DaoImpl implements DaoInf {

	/*return boolean value based on save faculty data*/
	@Override
	public boolean saveFacultyDetails(FacultyDTO facultyDTO) {

		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		boolean status=false;
		try {
			String query="insert into faculty_skill values(?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,facultyDTO.getFacultyId());
			pstmt.setString(2,facultyDTO.getSkills());

			int count=pstmt.executeUpdate();

			if(count>0)
			{
				status=true;
				System.out.println("Added Faculty successfully");
			}
			else 
			{
				System.out.println("Data present already");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	/*return Employee Object based on Faculty-Id and Name */
	@Override
	public EmployeeDTO getEmployeeDetails(int FacultyId, String Ename) {
		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		EmployeeDTO edto=new EmployeeDTO();
		System.out.println("check b");
		System.out.println("check c");
		try {
			String query="select * from employee_master where Employee_ID=?";
			pstmt=con.prepareStatement(query);
			System.out.println("check d");
			pstmt.setInt(1,FacultyId);
			rs=pstmt.executeQuery();

			if(rs.next())
			{
				System.out.println("check e");
				int eid=rs.getInt("Employee_ID");
				String ename=rs.getString("EmployeeName");
				edto.setEmployeeId(eid);
				edto.setEmployeeName(ename);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return edto;
	}

	/*return employee object with login data*/
	@Override
	public EmployeeDTO getLoginData(int user_name,String pass_word) {

		Connection con=DBUtils.connect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		EmployeeDTO edto=new EmployeeDTO();
		try {
			String query="select EmployeeName,Role from employee_master where Employee_ID=? and Password=?";
			ps=con.prepareStatement(query);
			ps.setInt(1,user_name);
			ps.setString(2,pass_word);
			rs=ps.executeQuery();
			if(rs.next())
			{   	   
				String Ename=rs.getString("EmployeeName");	   
				String role=rs.getString("Role");
				edto.setEmployeeName(Ename);
				edto.setRole(role);
			}	
			else 
			{
				System.out.println("no details present");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}     if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(ps!=null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return edto;
	}
	/* Method Not used for now*/

	/*return Employee Object for checking faculty present in employees or not*/
	@Override
	public EmployeeDTO viewFaculty(int FacultyId) {

		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try 
		{
			String query="SELECT * FROM employee_master  WHERE Employee_ID IN(SELECT Faculty_Id FROM faculty_skill  WHERE Faculty_Id=?)";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,FacultyId);
			rs=pstmt.executeQuery();

			EmployeeDTO employeeDTO=new EmployeeDTO();

			while(rs.next()) 
			{
				employeeDTO.setEmployeeId(rs.getInt("Employee_ID"));
				employeeDTO.setEmployeeName(rs.getString("EmployeeName"));
				employeeDTO.setRole(rs.getString("Role"));
			}

			return employeeDTO;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) 
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) 
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}







		return null;
	}

	/*Get List of Employee Object based on Faculty Table*/	
	public List<EmployeeDTO> viewFacultyAll()
	{
		Connection con=DBUtils.connect();
		Statement stmt=null;
		ResultSet rs=null;
		List<EmployeeDTO> lst=new ArrayList<EmployeeDTO>();
		try 
		{
			String query="SELECT * FROM employee_master WHERE Employee_ID IN (SELECT Faculty_Id FROM faculty_skill)";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);


			while(rs.next()) 
			{    
				EmployeeDTO employeeDTO=new EmployeeDTO();
				employeeDTO.setEmployeeId(rs.getInt("Employee_ID"));
				employeeDTO.setEmployeeName(rs.getString("EmployeeName"));
				employeeDTO.setRole(rs.getString("Role"));
				lst.add(employeeDTO);
			}


		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) 
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) 
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return lst;

	}

	/*return boolean value based on update of faculty skills*/
	@Override
	public boolean updateFacultyDetails(FacultyDTO facultyDTO) {
		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		boolean status=false;
		try {
			String query="update faculty_skill set Skill_Set=? where Faculty_Id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,facultyDTO.getSkills());
			pstmt.setInt(2,facultyDTO.getFacultyId());

			int count=pstmt.executeUpdate();

			if(count>0)
			{
				status=true;
				System.out.println("Updated Faculty successfully");
			}
			else 
			{
				System.out.println("not Updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	/*return boolean value based on add course operation*/
	@Override
	public boolean addCourse(CourseDTO addCourseDTO) {

		boolean addstatus=false;

		Connection con=DBUtils.connect();
		PreparedStatement preparedStatement=null;
		try {
			String sql="Insert into course_master values(?,?,?)";

			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setInt(1,addCourseDTO.getCourseId());
			preparedStatement.setString(2,addCourseDTO.getCourseName());
			preparedStatement.setInt(3,addCourseDTO.getNoOfDays());

			int count=preparedStatement.executeUpdate();

			if(count>0)
			{
				addstatus=true;
				System.out.println("Added Course successfully");
			}
			else 
			{
				System.out.println("Data present already");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {

			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(preparedStatement!=null)
			{
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return addstatus;
	}

	/*return List Object of Courses Present in Course Table*/
	@Override
	public List<CourseDTO> viewCourses() {

		Connection con=DBUtils.connect();
		Statement stmt=null;
		ResultSet rs=null;
		List<CourseDTO> lst=new ArrayList<CourseDTO>();
		try {
			stmt=con.createStatement();
			String qry="Select * from course_master";
			rs=stmt.executeQuery(qry);
			while (rs.next()) {

				CourseDTO cDto=new CourseDTO();
				cDto.setCourseId(rs.getInt("Course_ID"));
				cDto.setCourseName(rs.getString("Course_Name"));
				cDto.setNoOfDays(rs.getInt("No_of_Days"));
				lst.add(cDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) 
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) 
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return lst;
	}

	/*return boolean value based on update operation for Extending Number of Days in a Course*/
	@Override
	public boolean updateCourse(CourseDTO updateCourseDTO) {

		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		boolean upStatus=false;
		try {
			String query="Update course_master set No_of_Days=? where Course_ID=? and Course_Name=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,updateCourseDTO.getNoOfDays());
			pstmt.setInt(2,updateCourseDTO.getCourseId());
			pstmt.setString(3,updateCourseDTO.getCourseName());
			int count=pstmt.executeUpdate();

			if(count>0)
			{
				upStatus=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return upStatus;
	}

	/*return boolean value based on add training program operation*/
	@Override
	public boolean addTrainingPrgm(TrainingProgramDTO trainingProgramDTO) {

		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		boolean addTraining=false;
		try {

			String insertQuery="INSERT INTO training_program VALUES(?,(SELECT c.Course_ID FROM course_master c WHERE c.Course_Name=?),\r\n" + 
					"					(SELECT Faculty_Id FROM faculty_skill  WHERE Faculty_Id IN(SELECT Employee_ID\r\n" + 
					"					FROM employee_master\r\n" + 
					"					WHERE EmployeeName=?)),?,?)";

			pstmt=con.prepareStatement(insertQuery);

			pstmt.setInt(1,trainingProgramDTO.getTrainingCode());
			pstmt.setString(2,trainingProgramDTO.getCourseName());
			pstmt.setString(3,trainingProgramDTO.getFacultyName());
			pstmt.setDate(4,trainingProgramDTO.getsDate());
			pstmt.setDate(5,trainingProgramDTO.geteDate());

			int count=pstmt.executeUpdate();
			if(count>0)
			{
				addTraining=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {

			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return addTraining;
	}

	/*return boolean value based on update operation for Extending Program End-Date*/
	@Override
	public boolean updateTrainingPrgm(TrainingProgramDTO updateProgramDTO) {

		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		boolean status=false;
		try {
			String upQuery="UPDATE training_program SET End_Date=?\r\n" + 
					"WHERE Training_Code=? AND Faculty_Code IN(SELECT Faculty_Id\r\n" + 
					"FROM faculty_skill\r\n" + 
					"WHERE Faculty_Id IN(SELECT Employee_ID\r\n" + 
					"FROM employee_master\r\n" + 
					"WHERE EmployeeName=?)\r\n" + 
					")\r\n" + 
					"";
			pstmt=con.prepareStatement(upQuery);
			pstmt.setDate(1,updateProgramDTO.geteDate());
			pstmt.setInt(2,updateProgramDTO.getTrainingCode());
			pstmt.setString(3,updateProgramDTO.getFacultyName());

			int count=pstmt.executeUpdate();

			if(count>0)
			{
				status=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	/*return boolean value based on delete operation of training program*/
	@Override
	public boolean deleteTrainingPrgm(int trainingCode) {

		boolean delStatus=false;

		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		try {

			String delQuery="DELETE FROM training_program\r\n" + 
					"WHERE Training_Code=?";

			pstmt=con.prepareStatement(delQuery);
			pstmt.setInt(1,trainingCode);
			int count=pstmt.executeUpdate();

			if(count>0)
			{
				delStatus=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return delStatus;
	}
          Map<EmployeeDTO,List<EmployeeDTO>> t;
	/*return List Object of Training Programs present in Training Program Table*/
	@Override
	public List<TrainingProgramDTO> viewPrgms() {

		Connection con=DBUtils.connect();
		Statement pstmt=null;
		ResultSet rs=null;
		List<TrainingProgramDTO> tprgList=new ArrayList<TrainingProgramDTO>();
		try {
			String viewQuery="SELECT tp.Training_Code,c.Course_Name,e.EmployeeName,tp.Start_Date,tp.End_Date\r\n" + 
					"FROM training_program tp,course_master c,employee_master e,faculty_skill f\r\n" + 
					"WHERE tp.Course_Code=c.Course_ID AND e.Employee_ID=f.Faculty_Id AND f.Faculty_Id=tp.Faculty_Code";		
			pstmt=con.createStatement();
			rs=pstmt.executeQuery(viewQuery);

			while (rs.next()) {
				TrainingProgramDTO tProgramDTO=new TrainingProgramDTO();
				tProgramDTO.setTrainingCode(rs.getInt("Training_Code"));
				tProgramDTO.setCourseName(rs.getString("Course_Name"));
				tProgramDTO.setFacultyName(rs.getString("EmployeeName"));
				tProgramDTO.setsDate(rs.getDate("Start_Date"));
				tProgramDTO.seteDate(rs.getDate("End_Date"));
				tprgList.add(tProgramDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) 
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) 
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return tprgList;
	}

	/*return boolean value based on add Participant Operation*/
	@Override
	public boolean addParticipant(ParticipantDTO addPartipantDTO) {

		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		boolean addStatus=false;
		try {
			String addQuery="INSERT INTO `training-participant_enrollment`\r\n" + 
					"VALUES(\r\n" + 
					"(SELECT `Training_Code` FROM `training_program`\r\n" + 
					"WHERE `Training_Code`=? AND `Course_Code` IN(SELECT `Course_ID`\r\n" + 
					"FROM `course_master`\r\n" + 
					"WHERE `Course_Name`=?)\r\n" + 
					"),\r\n" + 
					"(SELECT `Employee_ID` FROM `employee_master`\r\n" + 
					"WHERE `EmployeeName`=? AND `Employee_ID`=?)\r\n" + 
					")";
			pstmt=con.prepareStatement(addQuery);

			pstmt.setInt(1,addPartipantDTO.getTrainingCode());
			pstmt.setString(2,addPartipantDTO.getCourseName());
			pstmt.setString(3,addPartipantDTO.getParticipantName());
			pstmt.setInt(4,addPartipantDTO.getParticipantCode());

			int count=pstmt.executeUpdate();

			if (count>0) {
				addStatus=true;
			}

		} catch (Exception e) {
			e.printStackTrace();            
		}
		return addStatus;
	}


	/*return list Object of Participants*/
	@Override
	public List<ParticipantDTO> getParticipantDetails() {

		Connection con=DBUtils.connect();
		Statement stmt=null;
		ResultSet rs=null;
		List<ParticipantDTO> pList=new ArrayList<ParticipantDTO>();
		try {
			String query="SELECT tpe.`Participant_Id`,e.`EmployeeName`,c.`Course_Name`,tpe.`Training_code`\r\n" + 
					"FROM `training-participant_enrollment` tpe,`employee_master` e,`training_program` tp,`course_master` c\r\n" + 
					"WHERE tpe.`Training_code`=tp.`Training_Code` AND tpe.`Participant_Id`=e.`Employee_ID` AND tp.`Course_Code`=c.`Course_ID`\r\n" + 
					"";

			stmt=con.createStatement();
			rs=stmt.executeQuery(query);

			while(rs.next())
			{
				ParticipantDTO getParticipantDTO=new ParticipantDTO();
				getParticipantDTO.setTrainingCode(rs.getInt("Training_Code"));
				getParticipantDTO.setParticipantName(rs.getString("EmployeeName"));
				getParticipantDTO.setCourseName(rs.getString("Course_Name"));
				getParticipantDTO.setParticipantCode(rs.getInt("Participant_Id"));
				pList.add(getParticipantDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return pList;

	}


	/*return boolean value based on delete participant operation*/
	@Override
	public boolean deleteParticipantDetails(ParticipantDTO participantDTO) {

		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		boolean delStatus=false;
		try {
			String delQuery="DELETE FROM `training-participant_enrollment`\r\n" + 
					"WHERE `Training_Code`=? AND `Participant_Id` IN(SELECT `Employee_ID`\r\n" + 
					"FROM `employee_master` WHERE `Employee_ID`=? AND `EmployeeName`=?)";
			pstmt=con.prepareStatement(delQuery);
			pstmt.setInt(1,participantDTO.getTrainingCode());
			pstmt.setInt(2,participantDTO.getParticipantCode());
			pstmt.setString(3,participantDTO.getParticipantName());
			int count=pstmt.executeUpdate();

			if(count>0)
			{
				delStatus=true;
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();		
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return delStatus;
	}

	/* return key and value pair of courses and employees names for Feedback form dropdown*/
	@Override
	public Map<CourseDTO, EmployeeDTO> getViewAddFeedBack() {

		Connection con=DBUtils.connect();
		Statement stmt=null;
		ResultSet rs=null;
		Map<CourseDTO,EmployeeDTO> map=new HashMap<CourseDTO,EmployeeDTO>();
		try {
			String query="SELECT c.Course_Name,e.EmployeeName\r\n" + 
					"FROM training_program tp,course_master c,employee_master e,faculty_skill f\r\n" + 
					"WHERE tp.Course_Code=c.Course_ID AND tp.Faculty_Code=f.Faculty_Id AND f.Faculty_Id=e.Employee_ID";
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				CourseDTO cDto=new CourseDTO();
			EmployeeDTO eDto=new EmployeeDTO();
				String cname=rs.getString("c.Course_Name");
				cDto.setCourseName(cname);
				String ename=rs.getString("e.EmployeeName");
				eDto.setEmployeeName(ename);
				map.put(cDto, eDto);
			}
			
			
		} catch (Exception e) {

		   e.printStackTrace();
		}
               return map;		
	}

	/*return boolean value based on adding feedback to the table*/
	@Override
	public boolean addFeedBack(FeedBackDTO feedBackDTO) {

		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		boolean statFeed=false;
		
		try {
			String sql="INSERT INTO feedback_master \r\n" + 
					"VALUES(\r\n" + 
					"(SELECT tp.`Training_Code`\r\n" + 
					" FROM `training_program` tp,`faculty_skill` f,`course_master` c,`training-participant_enrollment` tpe\r\n" + 
					"WHERE  tp.`Course_Code`=c.`Course_ID` AND tp.`Faculty_Code`=f.`Faculty_Id` AND \r\n" + 
					"tp.`Training_Code`=tpe.`Training_code` AND tpe.`Participant_Id`=?),\r\n" + 
					"(SELECT tpe.`Participant_Id`\r\n" + 
					" FROM `training_program` tp,`faculty_skill` f,`course_master` c,`training-participant_enrollment` tpe\r\n" + 
					"WHERE  tp.`Course_Code`=c.`Course_ID` AND tp.`Faculty_Code`=f.`Faculty_Id` AND \r\n" + 
					"tp.`Training_Code`=tpe.`Training_code` AND tpe.`Participant_Id`=?),?,?,?,?,?,?,?)\r\n" + 
					"";
	         pstmt=con.prepareStatement(sql);
   		    
	         pstmt.setInt(1,feedBackDTO.getParticipantId());
	         pstmt.setInt(2,feedBackDTO.getParticipantId());
	         pstmt.setInt(3,feedBackDTO.getPresentationCommunication());
	         pstmt.setInt(4,feedBackDTO.getClarifyDoubts());
	         pstmt.setInt(5,feedBackDTO.getTimeManagement());
	         pstmt.setInt(6,feedBackDTO.getHandOuts());
	         pstmt.setInt(7,feedBackDTO.getNwSofthardware());
	         pstmt.setString(8,feedBackDTO.getComments());
	         pstmt.setString(9,feedBackDTO.getSuggestions());
	         
	        int count= pstmt.executeUpdate();
	        
	        if(count>0)
	        {
	        	statFeed=true;
	        }
		} 
		catch (Exception e) 
		{
             e.printStackTrace();
		}
		
		
		return statFeed;
	}

	/*return list of feedback from the db*/
	@Override
	public List<FeedBackDTO> viewFeedBackReport() {
		
		
		
		
		
		
		
		
		
		return null;
		
	}


}