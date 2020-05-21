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

import javax.swing.ImageIcon;
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

public class personselect extends JFrame {
	private JTable table;
	private MyTableModel tablemodel;
	private MyTableModel tableModel;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JToolBar tool;
	private JComboBox choice;
	
	public personselect() {
		this.setSize(1000, 400);
		this.setTitle("顾客信息");
		this.setLocationRelativeTo(getOwner()); // 居中

		// 获取表格模型（数据），创建组件Jable
		tablemodel = getModel();
		table = new JTable(tablemodel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 250));
		JScrollPane scroll = new JScrollPane(table);
		getContentPane().add(scroll, BorderLayout.CENTER);

		// 可添加其他组件
		// -----------begin--------------
		// 创建“添加”、“修改”、“删除”按钮
		b1 = new JButton("添加");
		b1.setToolTipText("添加");
		b1.setFocusable(false);
		b1.setHorizontalTextPosition(SwingConstants.CENTER);
		b1.setVerticalTextPosition(SwingConstants.BOTTOM);
		b2 = new JButton("修改");
		b2.setToolTipText("修改");
		b2.setFocusable(false);
		b2.setHorizontalTextPosition(SwingConstants.CENTER);
		b2.setVerticalTextPosition(SwingConstants.BOTTOM);
		b3 = new JButton("删除");
		b3.setToolTipText("删除");
		b3.setHorizontalTextPosition(SwingConstants.CENTER);
		b3.setVerticalTextPosition(SwingConstants.BOTTOM);
		b4 = new JButton("返回菜单");
		b4.setToolTipText("返回菜单");
		b4.setHorizontalTextPosition(SwingConstants.CENTER);
		b4.setVerticalTextPosition(SwingConstants.BOTTOM);

		// 创建工具栏，添加按钮
		tool = new JToolBar();
		tool.add(b1);
		tool.add(b2);
		tool.add(b3);
		tool.add(b4);
		tool.setRollover(true);
		// 添加工具栏
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
					String sql = "update hotel set Cname=?,Cphone=?,roomNo=?,comedate=?,day=?,deposit=?,goodsprice=?,catering=?,laundry=?,roomprice=?,state=?,staffNo=?,account=? where Cid=?";
					PreparedStatement presta = dbcon.PreparedStatement(sql);
					
					/*String sql3 = "select roomNo from hotel where state='入住' and roomNo='" + roomNo+ "'";
					PreparedStatement pr = dbcon.PreparedStatement(sql3);
					ResultSet rs = pr.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "该房间已经入住！");
						JOptionPane.showMessageDialog(null, "修改失败！");
						personselect s = new personselect();
						s.setVisible(true);
						dispose();
					} else{}*/
					
					
					// 获得JTable中所修改的行数
					count = tablemodel.getEditedIndex().size();
				   // 获得JTable中所修改的行的数据，更新数据库
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
							presta.setString(8, table.getValueAt(index, 8).toString());
							presta.setString(9, table.getValueAt(index, 9).toString());
							presta.setString(10, table.getValueAt(index, 10).toString());
							presta.setString(11, table.getValueAt(index, 12).toString());
							presta.setString(12, table.getValueAt(index, 13).toString());
							presta.setString(13, table.getValueAt(index, 14).toString());
							presta.setString(14, table.getValueAt(index, 0).toString());
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
						// 获得JTable中选中行的序列
						int[] selRowIndexs = table.getSelectedRows();
						java.sql.PreparedStatement presta = dbcon.PreparedStatement("delete from hotel where Cid=?");
						for (int i = 0; i < selRowIndexs.length; i++) {
							presta.setString(1, table.getValueAt(selRowIndexs[i], 0).toString());
							presta.addBatch();
						}
						
						// 删除数据库中相应记录
						presta.executeBatch();
						
				/*	  //删除后更新room
						String sql2 = "update room set state='空闲' where room.roomNo in (select roomNo from hotel where hotel.Cid=i)";
						PreparedStatement pres= dbcon.PreparedStatement(sql2);
						pres.executeUpdate();*/
						
						
						// 重新加载数据到JTable
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

		// 查询
		JPanel panel = new JPanel();
		JLabel label = new JLabel("查询");
		JTextField id = new JTextField(10);
		JButton button = new JButton("按身份证号查询");
		JButton button0 = new JButton("按房间号查询");
		JButton button1 = new JButton("退房");
		JButton button2 = new JButton("返回");
		panel.add(label);
		panel.add(id);
		panel.add(button);
		panel.add(button0);
		panel.add(button1);
		panel.add(button2);
		//按身份证号查询
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Cid = id.getText().toString();
				System.out.println(Cid);
				String sql = "select Cid,roomNo,plus from hotel where Cid=" + Cid;
				db dbconn = new db();
				try {
					ResultSet rs = dbconn.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					int column = rsmd.getColumnCount();

					tableModel = new MyTableModel();
					for (int i = 1; i <= column; i++)
						tableModel.addColumn(rsmd.getColumnName(i));

					// 获取查询结果的元祖，填充表格模型行
					ArrayList<PersonEntity> v = new ArrayList();
					if (rs.next()) {
						PersonEntity hotel = new PersonEntity();
						hotel.setCid(rs.getString("Cid"));
						hotel.setRoomNo(rs.getString("roomNo"));
						hotel.setPlus(rs.getString("plus"));
						v.add(hotel);
					} else {
						JOptionPane.showMessageDialog(null, "没有该客户");
					}
					rs.close();

					for (int i = 0; i < v.size(); i++) {
						tableModel.addRow(new Object[] { v.get(i).getCid(),v.get(i).getRoomNo(), v.get(i).getPlus() });
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
		//按房间号查询
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roomNo = id.getText().toString();
				System.out.println(roomNo);
				String sql = "select Cid,roomNo,plus from hotel where roomNo=" + roomNo;
				db dbconn = new db();
				try {
					ResultSet rs = dbconn.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					int column = rsmd.getColumnCount();

					tableModel = new MyTableModel();
					for (int i = 1; i <= column; i++)
						tableModel.addColumn(rsmd.getColumnName(i));

					// 获取查询结果的元祖，填充表格模型行
					ArrayList<PersonEntity> v = new ArrayList();
					if (rs.next()) {
						PersonEntity hotel = new PersonEntity();
						hotel.setCid(rs.getString("Cid"));
						hotel.setRoomNo(rs.getString("roomNo"));
						hotel.setPlus(rs.getString("plus"));
						v.add(hotel);
					} else {
						JOptionPane.showMessageDialog(null, "该房间号未入住");
					}
					rs.close();

					for (int i = 0; i < v.size(); i++) {
						tableModel.addRow(new Object[] { v.get(i).getCid(),v.get(i).getRoomNo(), v.get(i).getPlus() });
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
		//退房
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roomNo = id.getText().toString();
				System.out.println(roomNo);
				String sql = "update hotel set state='空闲',account='已结账' where roomNo='" + roomNo+"'";
				db dbcon = new db();
				try {

					int n = dbcon.executeUpdate(sql);
					tablemodel = getModel();
					table.setModel(tablemodel);
					JOptionPane.showMessageDialog(null, "退房成功");
					getContentPane().add(scroll, BorderLayout.CENTER);

				} catch (SQLException sqle) {
					System.out.println(sqle.toString());
				}
			
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getContentPane().add(scroll, BorderLayout.CENTER);
			}
		});
		getContentPane().add(panel, BorderLayout.SOUTH);

	}

	private MyTableModel getModel() {
		// 实例化自己的表格模型类
		MyTableModel tableModel = new MyTableModel();

		db dbcon;
		try {
			// 连接数据库，执行查询语句
			dbcon = new db();
			ResultSet rs = dbcon.executeQuery("select * from hotel");
			// 获取查询结果中列名，填充表格模型列
			ResultSetMetaData rsmd = rs.getMetaData();
			int Colnum = rsmd.getColumnCount();
			int i;
			for (i = 1; i <= Colnum; i++)
				tableModel.addColumn(rsmd.getColumnName(i));

			// 获取查询结果中的元组，填充表格模型行
			ArrayList<PersonEntity> v = new ArrayList<PersonEntity>();
			while (rs.next()) {
				PersonEntity hotel = new PersonEntity();
				hotel.setCid(rs.getString("Cid"));
				hotel.setCname(rs.getString("Cname"));
				hotel.setCphone(rs.getString("Cphone"));
				hotel.setRoomNo(rs.getString("roomNo"));
				hotel.setComedate(rs.getDate("comedate"));
				hotel.setDay(rs.getString("day"));
				hotel.setDeposit(rs.getString("deposit"));
				hotel.setGoodsprice(rs.getString("goodsprice"));
				hotel.setCatering(rs.getString("catering"));
				hotel.setLaundry(rs.getString("laundry"));
				hotel.setRoomprice(rs.getString("roomprice"));
				hotel.setPlus(rs.getString("plus"));
				hotel.setState(rs.getString("state"));
				hotel.setStaffNo(rs.getString("staffNo"));
				hotel.setAccount(rs.getString("account"));
				v.add(hotel);

			}
			rs.close();
			for (i = 0; i < v.size(); i++) {
				tableModel.addRow(new Object[] { v.get(i).getCid(), v.get(i).getCname(), v.get(i).getCphone(),
						v.get(i).getRoomNo(), v.get(i).getComedate(), v.get(i).getDay(), v.get(i).getDeposit(),
						v.get(i).getGoodsprice(), v.get(i).getCatering(), v.get(i).getLaundry(),
						v.get(i).getRoomprice(), v.get(i).getPlus(), v.get(i).getState(), v.get(i).getStaffNo(),
						v.get(i).getAccount() });

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
		personselect w = new personselect();
		w.setVisible(true);
	}
}