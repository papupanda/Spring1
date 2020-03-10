package com.nt.mod1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class EmpsCount1 {

	public static void main(String[] args) {
		Properties props=null;
			//locate properties file
			try(InputStream is=new FileInputStream("src/com/nt/commons/jdbc.properties")){
			// store Properties file content to  java.util.Properties collection
			props=new Properties();
			props.load(is);
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}

			//establish the connection
			try(Connection con=DriverManager.getConnection(props.getProperty("jdbc.url"),
					                                                            props.getProperty("jdbc.username"),
					                                                            props.getProperty("jdbc.pwd"))){
		    	//create PreparedStatement object
         			try(PreparedStatement ps=con.prepareStatement("SELECT COUNT(*) FROM EMP")){
         				//execute the query
         				try(ResultSet rs=ps.executeQuery()){
         					//process the ResultSet
         					if(rs.next()) {
         						System.out.println("Emps count::"+rs.getInt(1));
         					}
         				}//try
         			}//try
	}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
