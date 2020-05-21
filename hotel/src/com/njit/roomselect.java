package com.njit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

import db.db;
import entity.roomEntity;

public class roomselect extends JFrame {
	private JTable table;
	private MyTableModel tablemodel;
	private MyTableModel tableModel;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JToolBar tool;

	public roomselect() {
		this.setSize(600, 300);
		this.setTitle("�ͷ���Ϣ");
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
				roomadd radd = new roomadd();
				radd.setVisible(true);
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
					String sql = "update room set state=?,type=?,roomprice=? where roomNo=?";
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
							presta.setString(4, table.getValueAt(index, 0).toString());
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
						java.sql.PreparedStatement presta = dbcon.PreparedStatement("delete from room  where roomNo=?");
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

		// ���뷿��״̬��ѯ
		JPanel panel = new JPanel();
		JLabel label = new JLabel("����״̬");
		JTextField sta = new JTextField(10);
		JButton button = new JButton("��ѯ");
		JButton button1 = new JButton("����");
		panel.add(label);
		panel.add(sta);
		panel.add(button);
		panel.add(button1);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String state = sta.getText().toString();
				System.out.println(state);
				String sql = "select * from room where state='" + state + "'";
				db dbconn = new db();
				try {
					ResultSet rs = dbconn.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					int column = rsmd.getColumnCount();
                 System.out.println(column);
					tableModel = new MyTableModel();
					for (int i = 1; i <= column; i++)
						tableModel.addColumn(rsmd.getColumnName(i));

					// ��ȡ��ѯ�����Ԫ�棬�����ģ����
					ArrayList<roomEntity> v = new ArrayList();
					if (rs.next()) {
						roomEntity room = new roomEntity();
						room.setRoomNo(rs.getString("roomNO"));
						room.setState(rs.getString("state"));
						room.setType(rs.getString("type"));
						room.setRoomprice(rs.getString("roomprice"));
						v.add(room);
					}else{
						JOptionPane.showMessageDialog(null, "�����ڸ�״̬�ķ���");
					}
					
					rs.close();

					for (int m = 0; m < v.size(); m++) {
						tableModel.addRow(new Object[] { v.get(m).getRoomNo(), v.get(m).getState(), v.get(m).getType(),
								v.get(m).getRoomprice() });

					}
					
					dbconn.closeConn();
					table.setModel(tableModel);

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
			ResultSet rs = dbcon.executeQuery("select * from room");
			// ��ȡ��ѯ����������������ģ����
			ResultSetMetaData rsmd = rs.getMetaData();
			int Colnum = rsmd.getColumnCount();
			int i;
			for (i = 1; i <= Colnum; i++)
				tableModel.addColumn(rsmd.getColumnName(i));

			// ��ȡ��ѯ����е�Ԫ�飬�����ģ����
			ArrayList<roomEntity> v = new ArrayList<roomEntity>();
			while (rs.next()) {
				roomEntity room = new roomEntity();
				room.setRoomNo(rs.getString("roomNO"));
				room.setState(rs.getString("state"));
				room.setType(rs.getString("type"));
				room.setRoomprice(rs.getString("roomprice"));
				v.add(room);

			}

			rs.close();

			for (i = 0; i < v.size(); i++) {
				tableModel.addRow(new Object[] { v.get(i).getRoomNo(), v.get(i).getState(), v.get(i).getType(),
						v.get(i).getRoomprice() });

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
		roomselect w = new roomselect();
		w.setVisible(true);
	}

}
