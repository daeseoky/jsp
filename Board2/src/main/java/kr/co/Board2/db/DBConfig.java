package kr.co.Board2.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	
	// 
	private static DBConfig instance = new DBConfig();
	
	public static DBConfig getInstance() {
		return instance;
	}
	
	private DBConfig() {}
	
//	개발용
//	private final String HOST = "jdbc:mysql://54.180.150.241:3306/mydb";
//	private final String USER = "mydb";
//	private final String PASS = "1234";
	
//	배포용
//	private final String HOST = "jdbc:mysql://localhost:3306/mydb";
//	private final String USER = "mydb";
//	private final String PASS = "1234";
	
//	test용
	private final String HOST = "jdbc:mysql://chhak.or.kr:3306/cesiya3";
	private final String USER = "cesiya3";
	private final String PASS = "1234";
	
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		return conn;
	}
}