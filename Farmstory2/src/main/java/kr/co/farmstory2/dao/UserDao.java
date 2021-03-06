package kr.co.farmstory2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.co.farmstory2.config.DBConfig;
import kr.co.farmstory2.config.Sql;
import kr.co.farmstory2.vo.TermsVo;
import kr.co.farmstory2.vo.UserVo;

public class UserDao {
	
	// ?̱??? ??ü
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
		
	private UserDao() {}
	
	// ?⺻ CRUD
	public void insertUser(UserVo vo) {
		try{
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_USER);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getNick());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getHp());
			psmt.setString(7, vo.getZip());
			psmt.setString(8, vo.getAddr1());
			psmt.setString(9, vo.getAddr2());
			psmt.setString(10, vo.getRegip());
			psmt.executeUpdate();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public TermsVo selectTerms() {
		
		TermsVo tv = new TermsVo();
		
		try {
			Connection conn= DBConfig.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_TERMS);
			
			if(rs.next()) {
				tv.setTerms(rs.getString(1));
				tv.setPrivacy(rs.getString(2));
			}
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tv;
	}
	
	public int selectCountUid(String uid) {
		
		int count = 0;
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_UID);
			psmt.setString(1, uid);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int selectCountNick(String nick) {
		
		int count = 0;
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_NICK);
			psmt.setString(1, nick);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int selectCountEmail(String email) {
		
		int count = 0;
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_EMAIL);
			psmt.setString(1, email);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int selectCountHp(String hp) {
		
		int count = 0;
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_HP);
			psmt.setString(1, hp);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public UserVo selectUser(String uid, String pass) {
		
		UserVo user = null; // ????
				
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_USER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVo(); // ????
				user.setUid(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setName(rs.getString(3));
				user.setNick(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setHp(rs.getString(6));
				user.setGrade(rs.getInt(7));
				user.setZip(rs.getString(8));
				user.setAddr1(rs.getString(9));
				user.setAddr2(rs.getString(10));
				user.setRegip(rs.getString(11));
				user.setRdate(rs.getString(12));
			}
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}
	
}