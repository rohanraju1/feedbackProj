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

import org.capG.feedBackProj.dto.EmployeeDTO;
import org.capG.feedBackProj.dto.FacultyDTO;

public  class DaoImpl implements DaoInf {

	
	public Connection connect() 
	{
		Connection con=null;
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl="jdbc:mysql://localhost:3306/capgemini?user=root&password=root";
			 con=DriverManager.getConnection(dburl);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
				}
		
	@Override
	public boolean saveFacultyDetails(FacultyDTO facultyDTO) {
	           
		Connection con=connect();
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
	         return false;
	}

	@Override
	public EmployeeDTO getEmployeeDetails(int FacultyId, String Ename) {
		 System.out.println("check a");
		Connection con=connect();
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

	@Override
	public EmployeeDTO getLoginData(int user_name,String pass_word) {
		
		Connection con=connect();
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

	@Override
	public EmployeeDTO viewFaculty(int FacultyId) {
		
	   Connection con=connect();
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

	public List<EmployeeDTO> viewFacultyAll()
	{
		 Connection con=connect();
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
}