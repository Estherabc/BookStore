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
import entity.goodsEntity;

public class goodsselect extends JFrame{
	private JTable table;
	private MyTableModel tablemodel;
	private MyTableModel tableModel;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JToolBar tool;

	public goodsselect() {
		this.setSize(600, 300);
		this.setTitle("��Ʒ��Ϣ");
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
				goodsadd gadd = new goodsadd();
				gadd.setVisible(true);
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
					String sql = "update goods set goodsName=? ,goodsStock=? ,goodsprice=? where goodsNo=?";
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
							presta.setString(3, table.getValueAt(index, 0).toString());
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
						java.sql.PreparedStatement presta = dbcon.PreparedStatement("delete from goods where goodsNo=?");
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

		// �����Ʒ�����ѯ
		JPanel panel = new JPanel();
		JLabel label = new JLabel("��Ʒ���");
		JTextField num= new JTextField(10);
		JButton button = new JButton("��ѯ");
		JButton button1 = new JButton("����");
		panel.add(label);
		panel.add(num);
		panel.add(button);
		panel.add(button1);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String goodsNo = num.getText().toString();
				System.out.println(goodsNo);
				String sql = "select * from goods where goodsNo=" +goodsNo;
				db dbconn = new db();
				try {
					ResultSet rs = dbconn.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					int column = rsmd.getColumnCount();

					tableModel = new MyTableModel();
					for (int i = 1; i <= column; i++)
						tableModel.addColumn(rsmd.getColumnName(i));

					// ��ȡ��ѯ�����Ԫ�棬�����ģ����
					ArrayList<goodsEntity> v = new ArrayList();
					if(rs.next()) {
						goodsEntity goods = new goodsEntity();
						goods.setGoodsNo(rs.getString("goodsNO"));
						goods.setGoodsName(rs.getString("goodsName"));
						goods.setGoodsStock(rs.getString("goodsStock"));
						goods.setGoodsprice(rs.getString("goodsprice"));
						v.add(goods);
					}else{
						JOptionPane.showMessageDialog(null, "�����ڸû�Ʒ���");
					}

					rs.close();

					for (int i = 0; i < v.size(); i++) {
						tableModel.addRow(new Object[] { v.get(i).getGoodsNo(), v.get(i).getGoodsName(), v.get(i).getGoodsStock(), v.get(i).getGoodsprice() });

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
			ResultSet rs = dbcon.executeQuery("select * from goods");
			// ��ȡ��ѯ����������������ģ����
			ResultSetMetaData rsmd = rs.getMetaData();
			int Colnum = rsmd.getColumnCount();
			int i;
			for (i = 1; i <= Colnum; i++)
				tableModel.addColumn(rsmd.getColumnName(i));

			// ��ȡ��ѯ����е�Ԫ�飬�����ģ����
			ArrayList<goodsEntity> v = new ArrayList<goodsEntity>();
			while (rs.next()) {
				goodsEntity goods = new goodsEntity();
				goods.setGoodsNo(rs.getString("goodsNO"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setGoodsStock(rs.getString("goodsStock"));
				goods.setGoodsprice(rs.getString("goodsprice"));
				v.add(goods);

			}

			rs.close();

			for (i = 0; i < v.size(); i++) {
				tableModel.addRow(new Object[] { v.get(i).getGoodsNo(), v.get(i).getGoodsName(), v.get(i).getGoodsStock(), v.get(i).getGoodsprice()  });

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
		goodsselect w = new goodsselect();
		w.setVisible(true);
	}

}
