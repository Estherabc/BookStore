package com.njit;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private JTextField Cid, Cname, Cphone, roomNo, comedate, day, deposit, goodsprice, catering, laundry, roomprice;
	private JComboBox state;
	private JTextField staffNo;
	private JPanel account;
	private JRadioButton no, yes;
	private JButton ok, cancel;

	public personadd() {
		super();
		this.setSize(550, 500);
		this.setTitle("Login");
		this.setLocationRelativeTo(getOwner()); // 居中
		// 设置组件布局
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(9, 4));
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
		// 押金
		cont.add(new JLabel("押金"));
		deposit = new JTextField(10);
		cont.add(deposit);
		// 货品消费
		cont.add(new JLabel("货品消费"));
		goodsprice = new JTextField(10);
		cont.add(goodsprice);
		// 餐饮费
		cont.add(new JLabel("餐饮费"));
		catering = new JTextField(10);
		cont.add(catering);
		// 洗衣费
		cont.add(new JLabel("洗衣服"));
		laundry = new JTextField(10);
		cont.add(laundry);
		// 房间价格
		cont.add(new JLabel("房间价格"));
		roomprice = new JTextField(10);
		cont.add(roomprice);
		// 房间状态
		cont.add(new JLabel("房间状态"));
		state = new JComboBox();
		state.addItem("入住");
		// state.addItem("预定");
		state.addItem("空闲");
		cont.add(state);
		// 负责员工号
		cont.add(new JLabel("负责员工号"));
		staffNo = new JTextField(10);
		cont.add(staffNo);
		// 是否结账
		cont.add(new JLabel("是否结账"));
		no = new JRadioButton("未结账", true);
		yes = new JRadioButton("已结账");
		ButtonGroup bg = new ButtonGroup();
		bg.add(no);
		bg.add(yes);
		account = new JPanel(new GridLayout(1, 2));
		account.add(no);
		account.add(yes);
		cont.add(account);
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
					String sql = "insert into hotel values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement prestate = dbcon.PreparedStatement(sql);

					String sql3 = "select roomNo from hotel where state='入住' and roomno='" + roomNo.getText() + "'";
					PreparedStatement pr = dbcon.PreparedStatement(sql3);
					ResultSet rs = pr.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "该房间已经入住！");
						JOptionPane.showMessageDialog(null, "插入失败！");
						personadd k = new personadd();
						k.setVisible(true);
						dispose();
					} else {
						prestate.setString(1, Cid.getText());
						prestate.setString(2, Cname.getText());
						prestate.setString(3, Cphone.getText());
						prestate.setString(4, roomNo.getText());
						prestate.setString(5, comedate.getText());
						prestate.setString(6, day.getText());
						prestate.setString(7, deposit.getText());
						prestate.setString(8, goodsprice.getText());
						prestate.setString(9, catering.getText());
						prestate.setString(10, laundry.getText());
						prestate.setString(11, roomprice.getText());
						prestate.setString(12, state.getSelectedItem().toString());
						prestate.setString(13, staffNo.getText());
						prestate.setString(14, (no.isSelected() ? no.getText() : yes.getText()));

						prestate.executeUpdate();
						JOptionPane.showMessageDialog(null, "插入成功！");
						dispose();
						personselect psel = new personselect();
						psel.setVisible(true);
					}

					String sql2 = "update room set state='入住' where room.roomNo in (select roomNo from hotel where hotel.state='入住')";
					PreparedStatement pres = dbcon.PreparedStatement(sql2);
					pres.executeUpdate();

				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personselect P = new personselect();
				P.setVisible(true);
				dispose();
			}
		});
		// ---------end-----------------
	}

	public static void main(String[] args) {
		personadd w = new personadd();
		w.setVisible(true);
	}
}
