package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Db1;

import valuebean.PublishSingle;

public class PublishDao {
	public List<PublishSingle> getAllPublish() { // 查询所有信息
		List<PublishSingle> publishlist = new ArrayList<PublishSingle>(); // 创建集合
		Connection conn = Db1.getConnection();
		String sql = "select * from publishhouse"; // SQL查询语句
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				PublishSingle publish = new PublishSingle();
				publish.setPublishName(rs.getString("publishName")); 
				publish.setPublishPlace(rs.getString("publishPlace"));
				publish.setPublishNumber(rs.getString("publishNumber"));
				publish.setInsertDate(rs.getString("insertDate"));
				publish.setBooks(rs.getString("books"));
				publishlist.add(publish);
			}
			rs.close(); // 关闭
			pst.close(); // 关闭
		} catch (SQLException e) {
			e.printStackTrace(); // 抛出异常
		}
		return publishlist; // 返回一个集合
	}

	public boolean addPublish(PublishSingle publish) { // 添加信息
		String sql = "insert into [publishhouse] values (?,?,?,?,?)"; // 添加的SQL语句
		Connection conn = Db1.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, publish.getPublishName());
			ps.setString(2, publish.getPublishPlace());
			ps.setString(3, publish.getPublishNumber());
			ps.setString(4, publish.getInsertDate());
			ps.setString(5, publish.getBooks());

			int count = ps.executeUpdate();
			ps.close();
			return count > 0 ? true : false; // 是否添加的判断
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatePublish(PublishSingle publish) { // 修改
		String sql = "update [publishhouse]  set publishName=?,publishPlace=? ,PublishNumber=? ,insertDate=?,books=? where publishName = ?"; // 修改的SQL语句，根据ID修改
		Connection conn = Db1.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, publish.getPublishPlace());
			pst.setString(2, publish.getPublishNumber());
			pst.setString(3, publish.getInsertDate());
			pst.setString(4, publish.getBooks());
			pst.setString(5, publish.getPublishName());

			int count = pst.executeUpdate();
			pst.close(); // 关闭
			return count > 0 ? true : false; // 是否修改的判断
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePublish(String publishName) { // 删除
		String sql = "delete from publishhouse where publishName = ?";
		Connection conn = Db1.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, publishName);
			int count = pst.executeUpdate();
			pst.close();
			return count > 0 ? true : false; // 是否删除的判断
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public PublishSingle selectPublishByName(String publishName) { 
		Connection conn = Db1.getConnection();
		String sql = "select * from publish where publishName = " + publishName;
		PublishSingle publish = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				publish = new PublishSingle();
				publish.setPublishName(rs.getString("publishName"));
				publish.setPublishPlace(rs.getString("publishPlace"));
				publish.setPublishNumber(rs.getString("publishNumber"));
				publish.setInsertDate(rs.getString("insertDate"));
				publish.setBooks(rs.getString("books"));
			
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publish; 
	}
	public List<PublishSingle> selectPublish(String keyword) {
		List<PublishSingle> publishlist = new ArrayList<PublishSingle>();
		Connection conn = Db1.getConnection();
		String sql = "select * from publishhouse where publishName like'%" + keyword + 
				"%'"+"select * from publishhouse where publishPlace like'%" + keyword + 
				"%'"+"select * from publishhouse where insresDate like'%" + keyword + 
				"%'"+"select * from publishhouse where books like'%" + keyword + "%'";
		PublishSingle publish = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				publish = new PublishSingle();
				publish.setPublishName(rs.getString("publishName"));
				publish.setPublishPlace(rs.getString("publishPlace"));
				publish.setPublishNumber(rs.getString("publishNumber"));
				publish.setInsertDate(rs.getString("insertDate"));
				publish.setBooks(rs.getString("books"));
				publishlist.add(publish);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publishlist; // 返回
	}
}
