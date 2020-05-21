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
		this.setLocationRelativeTo(getOwner()); // ����
		// �����������
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(9, 2));
		// ������
		// -----------begin---------
		// �ͻ����֤��
		cont.add(new JLabel("�ͻ����֤��"));
		Cid = new JTextField(10);
		cont.add(Cid);
		// �ͻ�����
		cont.add(new JLabel("����"));
		Cname = new JTextField(10);
		cont.add(Cname);
		// �ͻ��ֻ�����
		cont.add(new JLabel("�ͻ��ֻ�����"));
		Cphone = new JTextField(10);
		cont.add(Cphone);
		// �����
		cont.add(new JLabel("�����"));
		roomNo = new JTextField(10);
		cont.add(roomNo);
		// ��ס����
		cont.add(new JLabel("��ס����"));
		comedate = new JTextField(10);
		cont.add(comedate);
		// ��סʱ��
		cont.add(new JLabel("��סʱ��"));
		day = new JTextField(10);
		cont.add(day);
		// ����״̬
		cont.add(new JLabel("����״̬"));
		state = new JComboBox();
		state.addItem("Ԥ��");
		cont.add(state);
		// ����Ա����
		cont.add(new JLabel("����Ա����"));
		staffNo = new JTextField(10);
		cont.add(staffNo);
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

					JOptionPane.showMessageDialog(null, "����ɹ���");
					dispose();
					reserveselect psel = new reserveselect();
					psel.setVisible(true);
			    //String sql2 = "update room set state='Ԥ��' where room.roomNo in (select roomNo from reserve where reserve.state='Ԥ��')";
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
