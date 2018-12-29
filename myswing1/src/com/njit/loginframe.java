package com.njit;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.db;

public class loginframe extends JFrame {
	db dbconn;
	private JTextField username;
	private JPasswordField password;
	private JButton login, register;

	public loginframe() {
		super();
		this.setSize(300, 200);
		this.setTitle("Login");
		this.setLocationRelativeTo(getOwner());

		// 设置组件布局——3行2列表格
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(3, 2));

		// ------------begin----------
		// 添加“用户名”，“密码”
		cont.add(new JLabel("username"));
		username = new JTextField(10);
		cont.add(username);
		cont.add(new JLabel("password"));
		password = new JPasswordField(10);
		cont.add(password);

		// 添加“登陆”、“注册”按钮
		login = new JButton("enter");
		register = new JButton("register");
		cont.add(login);
		cont.add(register);

	
		// 注册监听器
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dbconn = new db();
				String upwd = "", pass = new String(password.getPassword());
				String name = new String(username.getText());
				System.out.println(name);
				String sql = "select * from pay.dbo.[user] where Uname=" + "'" + name + "'";
				System.out.println(sql);
				try {
					ResultSet rs = dbconn.executeQuery(sql);
					if (rs.next()) {
						upwd = rs.getString("Upwd");
						upwd = upwd.trim();
					} else {
						JOptionPane.showMessageDialog(null, "你输入的账户有误");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (pass.equals(upwd)) {
					HelloWorld hello = new HelloWorld();
					hello.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "你输入的密码有误");
				}
			}
		});
		register.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				registerframe rf = new registerframe();
				rf.setVisible(true);
			}
		});
		cont.add(login);
		cont.add(register);

		
		// ----------------------------end--------------------------------
	}

	public static void main(String[] args) {
		loginframe w = new loginframe();
		w.setVisible(true);
	}

}
