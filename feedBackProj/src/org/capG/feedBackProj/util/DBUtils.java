package org.capG.feedBackProj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils 
{
	public static Connection connect() 
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
}
