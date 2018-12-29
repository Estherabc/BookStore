package com.njit;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import db.db;

public class personadd extends JFrame {
	private JTextField userid, username;
	private JRadioButton sexfemale, sexmale;
	private JPanel sex, birth;
	private JTextField year, dept;
	private JComboBox month, day, prof;
	private JButton ok, cancel;

	public personadd() {
		super();
		this.setSize(350, 300);
		this.setTitle("Login");
		this.setLocationRelativeTo(getOwner()); // 居中
		// 设置组件布局
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(7, 2));
		// 添加组件
		// -----------begin---------
		// 用户名
		cont.add(new JLabel("员工号"));
		userid = new JTextField(10);
		cont.add(userid);
		// 用户名
		cont.add(new JLabel("姓名"));
		username = new JTextField(10);
		cont.add(username);
		// 性别
		cont.add(new JLabel("性别"));
		sexmale = new JRadioButton("男", true);
		sexfemale = new JRadioButton("女");
		ButtonGroup bg = new ButtonGroup();
		bg.add(sexmale);
		bg.add(sexfemale);
		sex = new JPanel(new GridLayout(1, 2));
		sex.add(sexmale);
		sex.add(sexfemale);
		cont.add(sex);
		// 出生日期
		cont.add(new JLabel("出生日期"));
		year = new JTextField(4);
		month = new JComboBox();
		int i;
		for (i = 1; i <= 22; i++)
			month.addItem(i);
		day = new JComboBox();
		for (i = 1; i <= 31; i++)
			day.addItem(i);
		birth = new JPanel();
		birth.add(year);
		birth.add(new JLabel("-"));
		birth.add(month);
		birth.add(new JLabel("-"));
		birth.add(day);
		birth.add(new JLabel("-"));
		cont.add(birth);
		// 职称
		cont.add(new JLabel("职称"));
		prof = new JComboBox();
		prof.addItem("初级");
		prof.addItem("中级");
		prof.addItem("高级");
		cont.add(prof);
		// 部门
		cont.add(new JLabel("部门"));
		dept = new JTextField(10);
		cont.add(dept);
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
					String sql = "insert into person values(?,?,?,?,?,?)";
					PreparedStatement prestate = dbcon.PreparedStatement(sql);
					prestate.setString(1, userid.getText());
					prestate.setString(2, username.getText());
					prestate.setString(3, (sexmale.isSelected() ? sexmale.getText() : sexfemale.getText()));
					prestate.setString(4, year.getText() + "-" + month.getSelectedItem() + "-" + day.getSelectedItem());
					prestate.setString(5, prof.getSelectedItem().toString());
					prestate.setString(6, dept.getText());

					prestate.executeUpdate();

					JOptionPane.showMessageDialog(null, "插入成功！");
					dispose();
					personselect psel = new personselect();
					psel.setVisible(true);

				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}
		});
		// ---------end-----------------
	}

	public static void main(String[] args) {
		personadd w = new personadd();
		w.setVisible(true);
	}
}
