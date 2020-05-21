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
		this.setLocationRelativeTo(getOwner()); // ����
		// �����������
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(5, 2));
		// ������
		// -----------begin---------

		// ��Ʒ���
		cont.add(new JLabel("��Ʒ���"));
		goodsNo = new JTextField(10);
		cont.add(goodsNo);
		// ��Ʒ����
		cont.add(new JLabel("��Ʒ����"));
		goodsName = new JTextField(10);
		cont.add(goodsName);
		// ��Ʒ���
		cont.add(new JLabel("��Ʒ���"));
		goodsStock = new JTextField(10);
		cont.add(goodsStock);
		// ��Ʒ�۸�
		cont.add(new JLabel("��Ʒ�۸�"));
		goodsStock = new JTextField(10);
		cont.add(goodsStock);
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
					String sql = "insert into goods values(?,?,?,?)";
					PreparedStatement prestate = dbcon.PreparedStatement(sql);
					prestate.setString(1, goodsNo.getText());
					prestate.setString(2, goodsName.getText());
					prestate.setString(3, goodsName.getText());
					prestate.setString(4, goodsName.getText());
					prestate.executeUpdate();

					JOptionPane.showMessageDialog(null, "����ɹ���");
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
