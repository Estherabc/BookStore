package com.njit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import db.db;

public class roomadd extends JFrame {
	private JTextField roomNo;
	private JComboBox state;
	private JTextField type, roomprice;
	private JButton ok, cancel;

	public roomadd() {
		super();
		this.setSize(350, 300);
		this.setTitle("Login");
		this.setLocationRelativeTo(getOwner()); // 居中
		// 设置组件布局
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(7, 2));
		// 添加组件
		// -----------begin---------

		// 房间号
		cont.add(new JLabel("房间号"));
		roomNo = new JTextField(10);
		cont.add(roomNo);
		// 房间状态
		cont.add(new JLabel("房间状态"));
		state = new JComboBox();
		state.addItem("空闲");
		state.addItem("预定");
		state.addItem("入住");
		cont.add(state);
		// 房间类型
		cont.add(new JLabel("房间类型"));
		type = new JTextField(10);
		cont.add(type);
		// 房间价格
		cont.add(new JLabel("房间价格"));
		roomprice = new JTextField(10);
		cont.add(roomprice);
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
					String sql = "insert into room values(?,?,?,?)";
					PreparedStatement prestate = dbcon.PreparedStatement(sql);
					prestate.setString(1, roomNo.getText());
					prestate.setString(2, state.getSelectedItem().toString());
					prestate.setString(3, type.getText());
					prestate.setString(4, roomprice.getText());
					prestate.executeUpdate();

					JOptionPane.showMessageDialog(null, "插入成功！");
					dispose();
					roomselect psel = new roomselect();
					psel.setVisible(true);

				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomselect P = new roomselect();
				P.setVisible(true);
				dispose();
			}
		});
		// ---------end-----------------
	}

	public static void main(String[] args) {
		roomadd w = new roomadd();
		w.setVisible(true);
	}
}
