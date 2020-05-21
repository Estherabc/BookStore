package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Db1;
import valuebean.PublishSingle;
import valuebean.WordSingle;

public class WordDao {
	public List<WordSingle> getAllwords() { // ��ѯ������Ϣ
		List<WordSingle> wordlist = new ArrayList<WordSingle>(); // ��������
		Connection conn = Db1.getConnection();
		String sql = "select * from words"; // SQL��ѯ���
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				WordSingle word = new WordSingle();
				word.setUserName(rs.getString("userName")); // 
				word.setUserId(rs.getString("userId"));
				word.setTime(rs.getString("time"));
				word.setContent(rs.getString("content"));
				wordlist.add(word);
			}
			rs.close(); // �ر�
			pst.close(); // �ر�
		} catch (SQLException e) {
			e.printStackTrace(); // �׳��쳣
		}
		return wordlist; // ����һ������
	}

	public boolean deleteword(String userId) { // ɾ��
		String sql = "delete from words where userId = ?"; // ɾ����SQL��䣬����IDɾ��
		Connection conn = Db1.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userId);
			int count = pst.executeUpdate();
			pst.close();
			return count > 0 ? true : false; // �Ƿ�ɾ�����ж�
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<WordSingle> selectWord(String keyword) { 
		Connection conn = Db1.getConnection();
		List<WordSingle> wordlist = new ArrayList<WordSingle>();
		String sql = "select * from words where userId like "+"'%" + keyword+"%'"
		+ "select * from words where userName like "+"'%"+keyword+"%'"+ "select * from words where contend like "+"'%"+keyword+"%'";
		WordSingle word = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				word = new WordSingle();
				word.setUserName(rs.getString("userName"));
				word.setUserId(rs.getString("userid"));
				word.setTime(rs.getString("time"));
				word.setContent(rs.getString("content"));
		     	wordlist.add(word);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wordlist; // ����
	}
}

