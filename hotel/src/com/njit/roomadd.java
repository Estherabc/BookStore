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
		this.setLocationRelativeTo(getOwner()); // ����
		// �����������
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(7, 2));
		// ������
		// -----------begin---------

		// �����
		cont.add(new JLabel("�����"));
		roomNo = new JTextField(10);
		cont.add(roomNo);
		// ����״̬
		cont.add(new JLabel("����״̬"));
		state = new JComboBox();
		state.addItem("����");
		state.addItem("Ԥ��");
		state.addItem("��ס");
		cont.add(state);
		// ��������
		cont.add(new JLabel("��������"));
		type = new JTextField(10);
		cont.add(type);
		// ����۸�
		cont.add(new JLabel("����۸�"));
		roomprice = new JTextField(10);
		cont.add(roomprice);
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
					String sql = "insert into room values(?,?,?,?)";
					PreparedStatement prestate = dbcon.PreparedStatement(sql);
					prestate.setString(1, roomNo.getText());
					prestate.setString(2, state.getSelectedItem().toString());
					prestate.setString(3, type.getText());
					prestate.setString(4, roomprice.getText());
					prestate.executeUpdate();

					JOptionPane.showMessageDialog(null, "����ɹ���");
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
