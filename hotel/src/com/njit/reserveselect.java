package com.njit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import db.db;
import entity.PersonEntity;

public class reserveselect extends JFrame {
	private JTable table;
	private MyTableModel tablemodel;
	private MyTableModel tableModel;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JToolBar tool;
	private JComboBox choice;
	
	public reserveselect() {
		this.setSize(600, 300);
		this.setTitle("Ԥ����Ϣ");
		this.setLocationRelativeTo(getOwner()); // ����

		// ��ȡ���ģ�ͣ����ݣ����������JTable
		tablemodel = getModel();
		table = new JTable(tablemodel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 250));
		JScrollPane scroll = new JScrollPane(table);
		getContentPane().add(scroll, BorderLayout.CENTER);

		// ������������
		// -----------begin--------------
		// ��������ӡ������޸ġ�����ɾ������ť
		b1 = new JButton("���");
		b1.setToolTipText("���");
		b1.setFocusable(false);
		b1.setHorizontalTextPosition(SwingConstants.CENTER);
		b1.setVerticalTextPosition(SwingConstants.BOTTOM);
		b2 = new JButton("�޸�");
		b2.setToolTipText("�޸�");
		b2.setFocusable(false);
		b2.setHorizontalTextPosition(SwingConstants.CENTER);
		b2.setVerticalTextPosition(SwingConstants.BOTTOM);
		b3 = new JButton("ɾ��");
		b3.setToolTipText("ɾ��");
		b3.setHorizontalTextPosition(SwingConstants.CENTER);
		b3.setVerticalTextPosition(SwingConstants.BOTTOM);
		b4 = new JButton("���ز˵�");
		b4.setToolTipText("���ز˵�");
		b4.setHorizontalTextPosition(SwingConstants.CENTER);
		b4.setVerticalTextPosition(SwingConstants.BOTTOM);

		// ��������������Ӱ�ť
		tool = new JToolBar();
		tool.add(b1);
		tool.add(b2);
		tool.add(b3);
		tool.add(b4);
		tool.setRollover(true);
		// ��ӹ�����
		getContentPane().add(tool, BorderLayout.NORTH);
		// -----------------------end-------------------

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personadd padd = new personadd();
				padd.setVisible(true);
				dispose();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i, index = 0, count;
				db dbcon = new db();
				if (table.getCellEditor() != null) {
					table.getCellEditor().stopCellEditing();
				}
				try {
					String sql = "update reserve set Cname=?,Cphone=?,roomNo=?,comedate=?,day=?,state=?,staffNo=? where Cid=?";
					PreparedStatement presta = dbcon.PreparedStatement(sql);
					// ���JTable�����޸ĵ�����
					count = tablemodel.getEditedIndex().size();
					// ���JTable�����޸ĵ��е����ݣ��������ݿ�
					if (count > 0) {
						for (i = 0; i < count; i++) {
							index = tablemodel.getEditedIndex().get(i);
							presta.setString(1, table.getValueAt(index, 1).toString());
							presta.setString(2, table.getValueAt(index, 2).toString());
							presta.setString(3, table.getValueAt(index, 3).toString());
							presta.setString(4, table.getValueAt(index, 4).toString());
							presta.setString(5, table.getValueAt(index, 5).toString());
							presta.setString(6, table.getValueAt(index, 6).toString());
							presta.setString(7, table.getValueAt(index, 7).toString());
							presta.setString(8, table.getValueAt(index, 0).toString());
							presta.addBatch();
						}
					}
					presta.executeBatch();
				} catch (SQLException sqle) {
					System.out.println(sqle.toString());
				}
			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db dbcon = new db();
				try {
					if (table.getSelectedRows().length > 0) {
						// ���JTable��ѡ���е�����
						int[] selRowIndexs = table.getSelectedRows();
						java.sql.PreparedStatement presta = dbcon.PreparedStatement("delete from reserve where Cid=?");
						for (int i = 0; i < selRowIndexs.length; i++) {
							presta.setString(1, table.getValueAt(selRowIndexs[i], 0).toString());
							presta.addBatch();
						}

						// ɾ�����ݿ�����Ӧ��¼
						presta.executeBatch();
						// ���¼������ݵ�JTable
						tablemodel = getModel();
						table.setModel(tablemodel);
					}
				} catch (SQLException sqle) {
					System.out.println(sqle.toString());
				}
			}
		});
	
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelloWorld H = new HelloWorld();
				H.setVisible(true);
				dispose();
			}
		});

      // �����ѯ
		JPanel panel = new JPanel();
		JLabel label = new JLabel("���֤��");
		JTextField id = new JTextField(10);
		JButton button = new JButton("��ѯ");
		JButton button1 = new JButton("����");
		panel.add(label);
		panel.add(id);
		panel.add(button);
		panel.add(button1);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String Cid = id.getText().toString();
				System.out.println(Cid);
				String sql = "select * from reserve where Cid=" + Cid;
				db dbconn = new db();
				try {
					ResultSet rs = dbconn.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					int column = rsmd.getColumnCount();

					tableModel = new MyTableModel();
					for (int i = 1; i <= column; i++)
						tableModel.addColumn(rsmd.getColumnName(i));

					// ��ȡ��ѯ�����Ԫ�棬�����ģ����
					ArrayList<PersonEntity> v = new ArrayList();
					if (rs.next()) {
						PersonEntity hotel = new PersonEntity();
						hotel.setCid(rs.getString("Cid"));
						hotel.setCname(rs.getString("Cname"));
						hotel.setCphone(rs.getString("Cphone"));
						hotel.setRoomNo(rs.getString("roomNo"));
						hotel.setComedate(rs.getDate("comedate"));
						hotel.setDay(rs.getString("day"));
						hotel.setState(rs.getString("state"));
						hotel.setStaffNo(rs.getString("staffNo"));
						v.add(hotel);
					}else{
						JOptionPane.showMessageDialog(null, "��Ǹ�������֤��û��Ԥ������");
					}

					rs.close();

					for (int i = 0; i < v.size(); i++) {
						tableModel.addRow(new Object[] { v.get(i).getCid(), v.get(i).getCname(), v.get(i).getCphone(),
								v.get(i).getRoomNo(), v.get(i).getComedate(), v.get(i).getDay(), v.get(i).getState(),
								v.get(i).getStaffNo() });

					}

					dbconn.closeConn();

				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				table = new JTable(tableModel);
				table.setPreferredScrollableViewportSize(new Dimension(500, 250));
				getContentPane().remove(scroll);
				JScrollPane scrol = new JScrollPane(table);
				getContentPane().add(scrol, BorderLayout.CENTER);
				getContentPane().validate();

			};
		});
		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				getContentPane().add(scroll, BorderLayout.CENTER);
			}
		});
		getContentPane().add(panel, BorderLayout.SOUTH);

	}

	private MyTableModel getModel() {
		// ʵ�����Լ��ı��ģ����
		MyTableModel tableModel = new MyTableModel();

		db dbcon;
		try {
			// �������ݿ⣬ִ�в�ѯ���
			dbcon = new db();
			ResultSet rs = dbcon.executeQuery("select * from reserve");
			// ��ȡ��ѯ����������������ģ����
			ResultSetMetaData rsmd = rs.getMetaData();
			int Colnum = rsmd.getColumnCount();
			int i;
			for (i = 1; i <= Colnum; i++)
				tableModel.addColumn(rsmd.getColumnName(i));

			// ��ȡ��ѯ����е�Ԫ�飬�����ģ����
			ArrayList<PersonEntity> v = new ArrayList<PersonEntity>();
			while (rs.next()) {
				PersonEntity hotel = new PersonEntity();
				hotel.setCid(rs.getString("Cid"));
				hotel.setCname(rs.getString("Cname"));
				hotel.setCphone(rs.getString("Cphone"));
				hotel.setRoomNo(rs.getString("roomNo"));
				hotel.setComedate(rs.getDate("comedate"));
				hotel.setDay(rs.getString("day"));
				hotel.setState(rs.getString("state"));
				hotel.setStaffNo(rs.getString("staffNo"));
				v.add(hotel);

			}
			rs.close();
			for (i = 0; i < v.size(); i++) {
				tableModel.addRow(new Object[] { v.get(i).getCid(), v.get(i).getCname(), v.get(i).getCphone(),
						v.get(i).getRoomNo(), v.get(i).getComedate(), v.get(i).getDay(), v.get(i).getState(),
						v.get(i).getStaffNo() });

			}
			dbcon.closeConn();
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tableModel;
	}

	public static void main(String[] args) {
		reserveselect w = new reserveselect();
		w.setVisible(true);
	}

}
