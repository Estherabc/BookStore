package db;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class db {
	public Connection dbConn;
	public Statement statement;
	public PreparedStatement pStatement;
	public ResultSet rs;

	 String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=bookstore";
	 String userName = "sa";
	 String userPwd = "042599";
	 public db(){
		 this.getConnection();
	 }

	public  Connection getConnection() {
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dbConn;
	}
	
	public int executeUpdate(String sql) throws SQLException {
		statement = dbConn.createStatement();
		return statement.executeUpdate(sql);
	}

	public  ResultSet executeQuery(String sql) throws SQLException {
		statement = dbConn.createStatement();
		return statement.executeQuery(sql);
	}

	public void closeConn() throws SQLException {
		statement.close();
		dbConn.close();
	}

	public PreparedStatement PreparedStatement(String sql) throws SQLException {
		return dbConn.prepareStatement(sql);
	}


}



