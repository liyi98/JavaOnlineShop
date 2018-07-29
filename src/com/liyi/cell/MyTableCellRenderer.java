package com.liyi.cell;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyTableCellRenderer implements TableCellRenderer {
	JButton button  = new JButton();
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int column) {
		// TODO Auto-generated method stub
		button.setText("Edit");
		return button;
	}

}
