package com.njit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class HelloWorld extends JFrame {
	public HelloWorld() {
		super();
		this.setSize(500, 300);
		this.setTitle("大牛七星级酒店管理系统");
		this.setLocationRelativeTo(getOwner()); // 居中
		// 创建“系统”菜单
		menu1 = new JMenu("系统管理");
		m11 = new JMenuItem("管理员信息");
		m12 = new JMenuItem();
		m12.setText("退出重新登陆");
		menu1.add(m11);
		menu1.add(m12);
		menubar = new JMenuBar();
		menubar.add(menu1);

		// 添加菜单栏到窗口
		setJMenuBar(menubar);
		m11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user use= new user();
				use.setVisible(true);
				dispose();
			}
		});
		m12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginframe log = new loginframe();
				log.setVisible(true);
				dispose();
			}
		});
		
	// 创建按钮
		b1 = new JButton("hotel表操作");
		b1.setToolTipText("hotel表操作");
		b1.setFocusable(false);
		b1.setHorizontalTextPosition(SwingConstants.CENTER);
		b1.setVerticalTextPosition(SwingConstants.BOTTOM);
		b2 = new JButton("room表操作");
		b2.setToolTipText("room表操作");
		b2.setFocusable(false);
		b2.setHorizontalTextPosition(SwingConstants.CENTER);
		b2.setVerticalTextPosition(SwingConstants.BOTTOM);
		b3 = new JButton("staff表操作");
		b3.setToolTipText("staff表操作");
		b3.setFocusable(false);
		b3.setHorizontalTextPosition(SwingConstants.CENTER);
		b3.setVerticalTextPosition(SwingConstants.BOTTOM);
		b4 = new JButton("goods表操作");
		b4.setToolTipText("goods表操作");
		b4.setFocusable(false);
		b4.setHorizontalTextPosition(SwingConstants.CENTER);
		b4.setVerticalTextPosition(SwingConstants.BOTTOM);
		b5 = new JButton("reserve表操作");
		b5.setToolTipText("reserve表操作");
		b5.setFocusable(false);
		b5.setHorizontalTextPosition(SwingConstants.CENTER);
		b5.setVerticalTextPosition(SwingConstants.BOTTOM);
		// 创建工具栏，添加按钮
		tool = new JToolBar();
		tool.add(b1);
		tool.add(b2);
		tool.add(b3);
		tool.add(b4);
		tool.add(b5);
		tool.setRollover(true);

		// 添加工具栏
		getContentPane().add(tool, BorderLayout.PAGE_START);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personselect psel = new personselect();
				psel.setVisible(true);
				dispose();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomselect rsel = new roomselect();
				rsel.setVisible(true);
				dispose();
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffselect ssel = new staffselect();
				ssel.setVisible(true);
				dispose();
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsselect gsel = new goodsselect();
				gsel.setVisible(true);
				dispose();
			}
		});	
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserveselect gsel = new reserveselect();
				gsel.setVisible(true);
				dispose();
			}
		});
	}	
	private JMenuBar menubar;
	private JMenu menu1;
	private JMenuItem m11;
	private JMenuItem m12;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JToolBar tool;

	public static void main(String[] args) {
		HelloWorld w = new HelloWorld();
		w.setVisible(true);
	}

}
