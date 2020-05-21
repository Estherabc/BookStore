package com.njit;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	private ArrayList<Integer> editedIndex = new ArrayList<Integer>();

	public MyTableModel() {
		super();
	}

	public void setValueAt(Object aValue, int row, int column) {
		super.setValueAt(aValue, row, column);
		int i, count = editedIndex.size();
		if (count == 0)
			editedIndex.add(row);
		else {
			for (i = 0; i < count; i++) {
				if (editedIndex.get(i).intValue() > row) {
					editedIndex.add(i + 1, row);
					break;
				}
			}
			if (i >= count)
				editedIndex.add(row);
		}
	} // ���ģ�������޸ĺ󣬼�¼���к�

	public ArrayList<Integer> getEditedIndex() {
		return editedIndex;
	} // �Զ��巽������ȡ���ģ���޸ĵ������к��б�
}
