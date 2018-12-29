package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {
    private Connection dbConn;
    private Statement stateMent;
	public db(){
		//SQL Server 2005�������ϣ�JDBC����
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//���ݿ�SQL Server 2005�������ϣ�URL
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=pay";
		String useName ="sa";  //Ĭ���û���
		String userPwd ="042599";  //����
		try{
			Class.forName(driverName);
			dbConn=DriverManager.getConnection(dbURL,useName,userPwd);
			//������ӳɹ�������̨���Connnection Successful!
			System.out.println("Connnection Successful!");
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	public int executeUpdate(String sql) throws SQLException{
		stateMent =dbConn.createStatement();
		return stateMent.executeUpdate(sql);
	}
	public ResultSet executeQuery(String sql)  throws SQLException{
		stateMent =dbConn.createStatement();
		return stateMent.executeQuery(sql);
	}
	public void closeConn() throws SQLException{
		stateMent.close();
		dbConn.close();
	}
	
	//���Ԥ�������ķ���
	public PreparedStatement PreparedStatement(String sql) throws SQLException{
		return dbConn.prepareStatement(sql);
	}

}

