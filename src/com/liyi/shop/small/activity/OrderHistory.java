package com.liyi.shop.small.activity;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.liyi.shop.activities.Template1;
import com.liyi.shop.model.Order;

public class OrderHistory extends JFrame {
	private Object[] column = {"No", "Order ID", "Order Status", "Total", "Date"};
	private Object[][] array;
	private JTable historyTable;
	
	public OrderHistory() {
		setTitle("Order History");
		setResizable(false);
		setSize(460,320);
		
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		getContentPane().setLayout(null);
		array = new Object[Template1.c.getAllOrder().size()][5];
		for(int row = 0; row < array.length; row++) {
			Order order = Template1.c.getAllOrder().get(row);
			array[row][0] = row + 1;
			array[row][1] = order.getOrderID();
			array[row][2] = order.getStatus();
			String sum = new DecimalFormat("RM#,##0.00").format(order.getSum());
			array[row][3] = sum;
			array[row][4] = order.getDate();
			
		}
		    historyTable= new JTable(array, column);
		    historyTable.setBounds(0,0,460,300);
		    historyTable.setBackground(bk);
		    historyTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		    JScrollPane jpane = new JScrollPane(historyTable);
		    jpane.setBounds(0,0,460,300);
		    getContentPane().add(jpane);
		    
		    setLocationRelativeTo(null);
		    setVisible(true);
		    
	}
}
