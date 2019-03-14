package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class TestRenderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {    
		// super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		setBackground(Color.BLACK);
		return this;
	}
}
