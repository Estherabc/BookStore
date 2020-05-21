package com.njit;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import db.db;

public class staffadd extends JFrame{
	private JTextField staffNo,staffName;
	private JButton ok, cancel;

	public staffadd() {
		super();
		this.setSize(350, 300);
		this.setTitle("Login");
		this.setLocationRelativeTo(getOwner()); // 居中
		// 设置组件布局
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(5, 2));
		// 添加组件
		// -----------begin---------

		//员工号
		cont.add(new JLabel("员工号"));
		staffNo = new JTextField(10);
		cont.add(staffNo);
		// 员工姓名
		cont.add(new JLabel("员工姓名"));
		staffName= new JTextField(10);
		cont.add(staffName);
		// 按钮
		ok = new JButton("添加");
		cancel = new JButton("取消");
		cont.add(ok);
		cont.add(cancel);
		// 注册监听器
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// ok事件处理：
				db dbcon = new db();
				try {
					String sql = "insert into staff values(?,?)";
					PreparedStatement prestate = dbcon.PreparedStatement(sql);
					prestate.setString(1, staffNo.getText());
					prestate.setString(2, staffName.getText());
					prestate.executeUpdate();

					JOptionPane.showMessageDialog(null, "插入成功！");
					dispose();
					staffselect psel = new staffselect();
					psel.setVisible(true);

				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffselect S = new staffselect();
				S.setVisible(true);
				dispose();
			}
		});
		// ---------end-----------------
	}

	public static void main(String[] args) {
		staffadd w = new staffadd();
		w.setVisible(true);
	}

}
