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
		//SQL Server 2005（及以上）JDBC驱动
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//数据库SQL Server 2005（及以上）URL
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=pay";
		String useName ="sa";  //默认用户名
		String userPwd ="042599";  //密码
		try{
			Class.forName(driverName);
			dbConn=DriverManager.getConnection(dbURL,useName,userPwd);
			//如果连接成功　控制台输出Connnection Successful!
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
	
	//添加预处理对象的方法
	public PreparedStatement PreparedStatement(String sql) throws SQLException{
		return dbConn.prepareStatement(sql);
	}

}

