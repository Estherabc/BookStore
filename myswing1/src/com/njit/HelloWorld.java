package com.njit;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class HelloWorld extends JFrame {
	public HelloWorld() {
		super();
		this.setSize(400, 300);
		this.setTitle("Hellowworld");
		this.setLocationRelativeTo(getOwner()); // ����
		// ������
		// ---------begin----------
		// ������ϵͳ���˵�
		menu1 = new JMenu("ϵͳ");
		m11 = new JMenuItem("�û�����");
		m12 = new JMenuItem();
		m12.setText("�˳�");
		menu1.add(m11);
		menu1.add(m12);

		// ���������ݲ������˵�
		menu2 = new JMenu("���ݲ���");
		m21 = new JMenuItem("��ѯ");
		m22 = new JMenuItem("���");
		m23 = new JMenuItem("�޸�");
		m24 = new JMenuItem("ɾ��");
		menu2.add(m21);
		menu2.add(m22);
		menu2.add(m23);
		menu2.add(m24);

		// �����˵�������ӡ�ϵͳ"�˵��������ݲ������˵�
		menubar = new JMenuBar();
		menubar.add(menu1);
		menubar.add(menu2);

		// ��Ӳ˵���������
		setJMenuBar(menubar);

		// ��������ѯ��������ӡ���ť
		b1 = new JButton("��ѯ");
		b1.setToolTipText("��ѯ");
		b1.setFocusable(false);
		b1.setHorizontalTextPosition(SwingConstants.CENTER);
		b1.setVerticalTextPosition(SwingConstants.BOTTOM);
		b2 = new JButton("���");
		b2.setToolTipText("���");
		b2.setFocusable(false);
		b2.setHorizontalTextPosition(SwingConstants.CENTER);
		b2.setVerticalTextPosition(SwingConstants.BOTTOM);

		// ��������������Ӱ�ť
		tool = new JToolBar();
		tool.add(b1);
		tool.add(b2);
		tool.setRollover(true);

		// ��ӹ�����
		getContentPane().add(tool, BorderLayout.PAGE_START);
		// ---------end------------
	}

	private JMenuBar menubar;
	private JMenu menu1;
	private JMenuItem m11;
	private JMenuItem m12;
	private JMenu menu2;
	private JMenuItem m21;
	private JMenuItem m22;
	private JMenuItem m23;
	private JMenuItem m24;

	private JButton b1;
	private JButton b2;
	private JToolBar tool;

	public static void main(String[] args) {
		HelloWorld w = new HelloWorld();
		w.setVisible(true);
	}

}
