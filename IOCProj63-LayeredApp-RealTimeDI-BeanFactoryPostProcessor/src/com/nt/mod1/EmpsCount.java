package com.nt.mod1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class EmpsCount {

	public static void main(String[] args) {
		InputStream is=null;
		Properties props=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			//locate properties file
			is=new FileInputStream("src/com/nt/commons/jdbc.properties");
			// store Properties file content to  java.util.Properties collection
			props=new Properties();
			props.load(is);
			//write jdbc code
			Class.forName(props.getProperty("jdbc.driver"));
			//establish the connection
			con=DriverManager.getConnection(props.getProperty("jdbc.url"),
					                                                            props.getProperty("jdbc.username"),
					                                                            props.getProperty("jdbc.pwd"));
			//create PreparedStatement object
			ps=con.prepareStatement("SELECT COUNT(*) FROM EMP");
			//execute the query
			rs=ps.executeQuery();
			//process the ResultSet
			if(rs.next()) {
				System.out.println("Emps count::"+rs.getInt(1));
			}
	}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(is!=null)
					is.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
	}//main
}//class
