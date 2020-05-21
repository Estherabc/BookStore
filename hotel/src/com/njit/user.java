package com.njit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import db.db;
import entity.userEntity;

public class user extends JFrame {
	private JTable table;
	private MyTableModel tablemodel;
	private MyTableModel tableModel;
	private JButton b4;
	private JToolBar tool;
	public user() {
		this.setSize(600, 300);
		this.setTitle("管理员信息");
		this.setLocationRelativeTo(getOwner()); // 居中

		// 获取表格模型（数据），创建组件JTable
		tablemodel = getModel();
		table = new JTable(tablemodel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 250));
		JScrollPane scroll = new JScrollPane(table);
		getContentPane().add(scroll, BorderLayout.CENTER);

		
		b4 = new JButton("返回菜单");
		b4.setToolTipText("返回菜单");
		b4.setHorizontalTextPosition(SwingConstants.CENTER);
		b4.setVerticalTextPosition(SwingConstants.BOTTOM);
		tool = new JToolBar();
	
		tool.add(b4);
		tool.setRollover(true);
		getContentPane().add(tool, BorderLayout.NORTH);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelloWorld H = new HelloWorld();
				H.setVisible(true);
				dispose();
			}
		});
		// 可添加其他组件
		// -----------begin--------------

	}

	private MyTableModel getModel() {
		// 实例化自己的表格模型类
		MyTableModel tableModel = new MyTableModel();

		db dbcon;
		try {
			// 连接数据库，执行查询语句
			dbcon = new db();
			ResultSet rs = dbcon.executeQuery("select * from [user]");
			// 获取查询结果中列名，填充表格模型列
			ResultSetMetaData rsmd = rs.getMetaData();
			int Colnum = rsmd.getColumnCount();
			int i;
			for (i = 1; i <= Colnum; i++)
				tableModel.addColumn(rsmd.getColumnName(i));

			// 获取查询结果中的元组，填充表格模型行
			ArrayList<userEntity> v = new ArrayList<userEntity>();
			while (rs.next()) {
				userEntity U = new userEntity();
				U.setUname(rs.getString("Uname"));
				U.setUpwd(rs.getString("Upwd"));
		
				v.add(U);

			}

			rs.close();

			for (i = 0; i < v.size(); i++) {
				tableModel.addRow(new Object[] { v.get(i).getUname(), v.get(i).getUpwd()});

			}

			dbcon.closeConn();
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tableModel;
	}

	public static void main(String[] args) {
		user w = new user();
		w.setVisible(true);
	}
}
