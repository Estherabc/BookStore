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

import com.njit.reserveselect;

import db.db;

public class reserveadd extends JFrame{
	private JTextField Cid, Cname, Cphone, roomNo, comedate, day;
	private JComboBox state;
	private JTextField staffNo;
	private JButton ok, cancel;

	public reserveadd() {
		super();
		this.setSize(450, 400);
		this.setTitle("Login");
		this.setLocationRelativeTo(getOwner()); // 居中
		// 设置组件布局
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(9, 2));
		// 添加组件
		// -----------begin---------
		// 客户身份证号
		cont.add(new JLabel("客户身份证号"));
		Cid = new JTextField(10);
		cont.add(Cid);
		// 客户姓名
		cont.add(new JLabel("姓名"));
		Cname = new JTextField(10);
		cont.add(Cname);
		// 客户手机号码
		cont.add(new JLabel("客户手机号码"));
		Cphone = new JTextField(10);
		cont.add(Cphone);
		// 房间号
		cont.add(new JLabel("房间号"));
		roomNo = new JTextField(10);
		cont.add(roomNo);
		// 入住日期
		cont.add(new JLabel("入住日期"));
		comedate = new JTextField(10);
		cont.add(comedate);
		// 入住时长
		cont.add(new JLabel("入住时长"));
		day = new JTextField(10);
		cont.add(day);
		// 房间状态
		cont.add(new JLabel("房间状态"));
		state = new JComboBox();
		state.addItem("预定");
		cont.add(state);
		// 负责员工号
		cont.add(new JLabel("负责员工号"));
		staffNo = new JTextField(10);
		cont.add(staffNo);
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
					String sql = "insert into reserve values(?,?,?,?,?,?,?,?)";
					PreparedStatement prestate = dbcon.PreparedStatement(sql);
					prestate.setString(1, Cid.getText());
					prestate.setString(2, Cname.getText());
					prestate.setString(3, Cphone.getText());
					prestate.setString(4, roomNo.getText());
					prestate.setString(5, comedate.getText());
					prestate.setString(6, day.getText());
					prestate.setString(7, state.getSelectedItem().toString());
					prestate.setString(8, staffNo.getText());

					prestate.executeUpdate();

					JOptionPane.showMessageDialog(null, "插入成功！");
					dispose();
					reserveselect psel = new reserveselect();
					psel.setVisible(true);
			    //String sql2 = "update room set state='预定' where room.roomNo in (select roomNo from reserve where reserve.state='预定')";
				//	PreparedStatement pres= dbcon.PreparedStatement(sql2);
				//	pres.executeUpdate();
				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserveselect P = new reserveselect();
				P.setVisible(true);
				dispose();
			}
		});
		// ---------end-----------------
	}

	public static void main(String[] args) {
		reserveadd w = new reserveadd();
		w.setVisible(true);
	}
	

}
