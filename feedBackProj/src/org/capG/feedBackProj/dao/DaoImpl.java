package org.capG.feedBackProj.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.capG.feedBackProj.dto.CourseDTO;
import org.capG.feedBackProj.dto.EmployeeDTO;
import org.capG.feedBackProj.dto.FacultyDTO;
import org.capG.feedBackProj.util.DBUtils;

public  class DaoImpl implements DaoInf {

	
	
		
	@Override
	public boolean saveFacultyDetails(FacultyDTO facultyDTO) {
	           
		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		String query="insert into faculty_skill values(?,?)";
		boolean status=false;
	         try {
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

	@Override
	public EmployeeDTO getEmployeeDetails(int FacultyId, String Ename) {
		 System.out.println("check a");
		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		EmployeeDTO edto=new EmployeeDTO();
		 System.out.println("check b");
		String query="select * from employee_master where Employee_ID=?";
		 System.out.println("check c");
		try {
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

	
	                 //gets employee object with login data
	@Override
	public EmployeeDTO getLoginData(int user_name,String pass_word) {
		
		Connection con=DBUtils.connect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="select EmployeeName,Role from employee_master where Employee_ID=? and Password=?";
		EmployeeDTO edto=new EmployeeDTO();
	try {
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
               // Method Not used for now
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

	
	@Override
	public boolean updateFacultyDetails(FacultyDTO facultyDTO) {
		Connection con=DBUtils.connect();
		PreparedStatement pstmt=null;
		String query="update faculty_skill set Skill_Set=? where Faculty_Id=?";
		boolean status=false;
	         try {
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

	@Override
	public boolean addCourse(CourseDTO addCourseDTO) {

		boolean addstatus=false;
		
	Connection con=DBUtils.connect();
	String sql="Insert into course_master values(?,?,?)";
	PreparedStatement preparedStatement=null;
	try {
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

	@Override
	public List<CourseDTO> viewCourses() {

		 Connection con=DBUtils.connect();
		 Statement stmt=null;
		   ResultSet rs=null;
		   List<CourseDTO> lst=new ArrayList<CourseDTO>();
		   try {
			
			   String qry="Select * from course_master";
			  rs=stmt.executeQuery(qry);
			   
			  while (rs.next()) {
				CourseDTO cDto=new CourseDTO();
			     cDto.setCourseId(rs.getInt("Course_ID"));
			     cDto.setCourseName(rs.getString("CourseName"));
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

	@Override
	public boolean updateCourse(CourseDTO updateCourseDTO) {

		Connection con=DBUtils.connect();
		
		
		return false;
	}


}