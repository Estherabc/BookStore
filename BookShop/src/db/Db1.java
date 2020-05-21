package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db1 {
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=bookstore";
	private static String userName = "sa";
	private static String userPwd = "042599";
	private static Connection conn = null;

	private Db1() {
		this.getConnection();
	}
	public static Connection getConnection() {
		if (null == conn) {
			try {
				Class.forName(driverName);
				conn = DriverManager.getConnection(dbURL, userName, userPwd);
				System.out.println("connection successful");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void main(String[] args) { // 测试数据库是否连通
		System.err.println(getConnection());

	}

}
