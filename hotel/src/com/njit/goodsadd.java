package com.njit;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import db.db;

public class goodsadd extends JFrame {
	private JTextField goodsNo, goodsName, goodsStock, goodsprice;
	private JButton ok, cancel;

	public goodsadd() {
		super();
		this.setSize(350, 300);
		this.setTitle("Login");
		this.setLocationRelativeTo(getOwner()); // 居中
		// 设置组件布局
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(5, 2));
		// 添加组件
		// -----------begin---------

		// 货品编号
		cont.add(new JLabel("货品编号"));
		goodsNo = new JTextField(10);
		cont.add(goodsNo);
		// 货品名称
		cont.add(new JLabel("货品名称"));
		goodsName = new JTextField(10);
		cont.add(goodsName);
		// 货品存货
		cont.add(new JLabel("货品存货"));
		goodsStock = new JTextField(10);
		cont.add(goodsStock);
		// 货品价格
		cont.add(new JLabel("货品价格"));
		goodsStock = new JTextField(10);
		cont.add(goodsStock);
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
					String sql = "insert into goods values(?,?,?,?)";
					PreparedStatement prestate = dbcon.PreparedStatement(sql);
					prestate.setString(1, goodsNo.getText());
					prestate.setString(2, goodsName.getText());
					prestate.setString(3, goodsName.getText());
					prestate.setString(4, goodsName.getText());
					prestate.executeUpdate();

					JOptionPane.showMessageDialog(null, "插入成功！");
					dispose();
					goodsselect psel = new goodsselect();
					psel.setVisible(true);

				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsselect G= new goodsselect();
				G.setVisible(true);
				dispose();
			}
		});
		// ---------end-----------------
	}

	public static void main(String[] args) {
		goodsadd w = new goodsadd();
		w.setVisible(true);
	}

}
