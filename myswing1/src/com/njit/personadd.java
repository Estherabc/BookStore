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
		this.setLocationRelativeTo(getOwner()); // ����
		// �����������
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(7, 2));
		// ������
		// -----------begin---------
		// �û���
		cont.add(new JLabel("Ա����"));
		userid = new JTextField(10);
		cont.add(userid);
		// �û���
		cont.add(new JLabel("����"));
		username = new JTextField(10);
		cont.add(username);
		// �Ա�
		cont.add(new JLabel("�Ա�"));
		sexmale = new JRadioButton("��", true);
		sexfemale = new JRadioButton("Ů");
		ButtonGroup bg = new ButtonGroup();
		bg.add(sexmale);
		bg.add(sexfemale);
		sex = new JPanel(new GridLayout(1, 2));
		sex.add(sexmale);
		sex.add(sexfemale);
		cont.add(sex);
		// ��������
		cont.add(new JLabel("��������"));
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
		// ְ��
		cont.add(new JLabel("ְ��"));
		prof = new JComboBox();
		prof.addItem("����");
		prof.addItem("�м�");
		prof.addItem("�߼�");
		cont.add(prof);
		// ����
		cont.add(new JLabel("����"));
		dept = new JTextField(10);
		cont.add(dept);
		// ��ť
		ok = new JButton("���");
		cancel = new JButton("ȡ��");
		cont.add(ok);
		cont.add(cancel);
		// ע�������
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// ok�¼�����
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

					JOptionPane.showMessageDialog(null, "����ɹ���");
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
