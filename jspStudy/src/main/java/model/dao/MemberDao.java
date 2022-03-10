package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.DBConfig;
import vo.MemberVo;

public class MemberDao {
	
	// ΩÃ±€≈Ê ∞¥√º
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	private MemberDao() {}
	
	//±‚∫ª CRUD ∏ﬁº≠µÂ
	public void insertUser(MemberVo vo) {
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement("INSERT INTO `Member`VALUES(?, ?, ?, ?, ?, NOW())");
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getHp());
			psmt.setString(4, vo.getPos());
			psmt.setString(5, vo.getDep());
			psmt.setString(6, vo.getRdate());
			
			psmt.executeUpdate();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public MemberVo selectUser(String uid) {
		
		MemberVo user = new MemberVo();
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement("SELECT * FROM `Member` WHERE `uid`=?");
			psmt.setString(1, uid);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				user.setUid(rs.getString(1));
				user.setName(rs.getString(2));
				user.setHp(rs.getString(3));
				user.setPos(rs.getString(4));
				user.setDep(rs.getString(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	public List<MemberVo> selectUsers() {
		List<MemberVo> users = new ArrayList<>();
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `Member`");
		
		while(rs.next()) {
			MemberVo vo = new MemberVo();
			vo.setUid(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setHp(rs.getString(3));
			vo.setPos(rs.getString(4));
			vo.setDep(rs.getString(5));
			
			users.add(vo);
		}
		conn.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	public void updateUser(MemberVo vo) {
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement("UPDATE `Member` SET `name`=?, `hp`=?, `pos`=?, `dep=? WHERE `uid`=?");
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getHp());
			psmt.setString(3, vo.getUid());
			psmt.setString(4, vo.getPos());
			psmt.setString(5, vo.getDep());
			psmt.executeUpdate();
			
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String uid) {
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement("DELETE FROM `Member` WHERE `uid`=?");
			psmt.setString(1, uid);
			psmt.executeUpdate();
			
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}