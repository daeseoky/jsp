package kr.co.board1.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	
	//�̱��� ��ü
	private static DBConfig instance = new DBConfig();

	public static DBConfig getInstance() {
		return instance;
	}
	
	private DBConfig() {}
	
	private final String HOST = "jdbc:mysql://54.180.150.241:3306/mydb"; //�Ƹ��� ����
	private final String USER = "mydb";
	private final String PASS = "1234";
	
	public Connection getConnection() throws Exception {
		//1�ܰ�
		Class.forName("com.mysql.jdbc.Driver");
		//2�ܰ�
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		return conn;
	
	}
}
