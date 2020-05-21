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
		this.setLocationRelativeTo(getOwner()); // ����
		// �����������
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(9, 4));
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
		// Ѻ��
		cont.add(new JLabel("Ѻ��"));
		deposit = new JTextField(10);
		cont.add(deposit);
		// ��Ʒ����
		cont.add(new JLabel("��Ʒ����"));
		goodsprice = new JTextField(10);
		cont.add(goodsprice);
		// ������
		cont.add(new JLabel("������"));
		catering = new JTextField(10);
		cont.add(catering);
		// ϴ�·�
		cont.add(new JLabel("ϴ�·�"));
		laundry = new JTextField(10);
		cont.add(laundry);
		// ����۸�
		cont.add(new JLabel("����۸�"));
		roomprice = new JTextField(10);
		cont.add(roomprice);
		// ����״̬
		cont.add(new JLabel("����״̬"));
		state = new JComboBox();
		state.addItem("��ס");
		// state.addItem("Ԥ��");
		state.addItem("����");
		cont.add(state);
		// ����Ա����
		cont.add(new JLabel("����Ա����"));
		staffNo = new JTextField(10);
		cont.add(staffNo);
		// �Ƿ����
		cont.add(new JLabel("�Ƿ����"));
		no = new JRadioButton("δ����", true);
		yes = new JRadioButton("�ѽ���");
		ButtonGroup bg = new ButtonGroup();
		bg.add(no);
		bg.add(yes);
		account = new JPanel(new GridLayout(1, 2));
		account.add(no);
		account.add(yes);
		cont.add(account);
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
					String sql = "insert into hotel values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement prestate = dbcon.PreparedStatement(sql);

					String sql3 = "select roomNo from hotel where state='��ס' and roomno='" + roomNo.getText() + "'";
					PreparedStatement pr = dbcon.PreparedStatement(sql3);
					ResultSet rs = pr.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "�÷����Ѿ���ס��");
						JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
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
						JOptionPane.showMessageDialog(null, "����ɹ���");
						dispose();
						personselect psel = new personselect();
						psel.setVisible(true);
					}

					String sql2 = "update room set state='��ס' where room.roomNo in (select roomNo from hotel where hotel.state='��ס')";
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
