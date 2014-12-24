package com.stefanbanu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnector {

	private Connection conn;
	private Statement st;
	private ResultSet rs;

	public String query = "select * from customers";

	public DataBaseConnector() {
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			try {
				// setup the connection with the DB.
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root","");
				// statements allow to issue SQL queries to the database
				st = conn.createStatement();
				// resultSet gets the result of the SQL query
				rs = st.executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getData() {

		try {
			setRs(st.executeQuery(query));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	// we need to close all three to make sure
	public void close() {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
