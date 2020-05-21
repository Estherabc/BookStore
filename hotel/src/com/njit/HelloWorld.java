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
		this.setTitle("��ţ���Ǽ��Ƶ����ϵͳ");
		this.setLocationRelativeTo(getOwner()); // ����
		// ������ϵͳ���˵�
		menu1 = new JMenu("ϵͳ����");
		m11 = new JMenuItem("����Ա��Ϣ");
		m12 = new JMenuItem();
		m12.setText("�˳����µ�½");
		menu1.add(m11);
		menu1.add(m12);
		menubar = new JMenuBar();
		menubar.add(menu1);

		// ��Ӳ˵���������
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
		
	// ������ť
		b1 = new JButton("hotel�����");
		b1.setToolTipText("hotel�����");
		b1.setFocusable(false);
		b1.setHorizontalTextPosition(SwingConstants.CENTER);
		b1.setVerticalTextPosition(SwingConstants.BOTTOM);
		b2 = new JButton("room�����");
		b2.setToolTipText("room�����");
		b2.setFocusable(false);
		b2.setHorizontalTextPosition(SwingConstants.CENTER);
		b2.setVerticalTextPosition(SwingConstants.BOTTOM);
		b3 = new JButton("staff�����");
		b3.setToolTipText("staff�����");
		b3.setFocusable(false);
		b3.setHorizontalTextPosition(SwingConstants.CENTER);
		b3.setVerticalTextPosition(SwingConstants.BOTTOM);
		b4 = new JButton("goods�����");
		b4.setToolTipText("goods�����");
		b4.setFocusable(false);
		b4.setHorizontalTextPosition(SwingConstants.CENTER);
		b4.setVerticalTextPosition(SwingConstants.BOTTOM);
		b5 = new JButton("reserve�����");
		b5.setToolTipText("reserve�����");
		b5.setFocusable(false);
		b5.setHorizontalTextPosition(SwingConstants.CENTER);
		b5.setVerticalTextPosition(SwingConstants.BOTTOM);
		// ��������������Ӱ�ť
		tool = new JToolBar();
		tool.add(b1);
		tool.add(b2);
		tool.add(b3);
		tool.add(b4);
		tool.add(b5);
		tool.setRollover(true);

		// ��ӹ�����
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
