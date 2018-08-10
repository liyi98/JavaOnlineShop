package com.liyi.shop.small.activity;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.liyi.shop.activities.ActivityManageOrder;
import com.liyi.shop.model.Order;
import com.liyi.shop.model.OrderItem;
import com.liyi.shop.model.Staff;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class EditOrder extends JFrame{
	private JTable tableItem;
	private JTextField txtAddress;
	private JComboBox comboBox;
	private JButton btnSave;
	private String[] columnName = {"No", "Name", "Quantity"};
	private Object[][] data;
	
	public EditOrder(Order order, JFrame parent , Staff staff) {
		data = new Object[order.getAllOrderItem().size()][3];
		for(int row = 0; row < data.length ; row++) {
			OrderItem item = order.getAllOrderItem().get(row);
			data[row][0] = row + 1 ;
			data[row][1] = item.getProduct().getName();
			data[row][2] = item.getQuantity();
		}
		setResizable(false);
		setTitle("Edit Order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(419,530);
		getContentPane().setLayout(null);
		Color bk = new Color(255, 235, 238);
		getContentPane().setBackground(bk);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblCustomerId.setBounds(25, 30, 100, 20);
		getContentPane().add(lblCustomerId);
		
		JLabel lblID = new JLabel(order.getCustomer().getId());
		lblID.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblID.setBounds(175, 30, 180, 20);
		getContentPane().add(lblID);
		
		JLabel lblName = new JLabel("Customer Name");
		lblName.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblName.setBounds(25, 60, 100, 20);
		getContentPane().add(lblName);
		
		JLabel lblCustomerName = new JLabel(order.getCustomer().getName());
		lblCustomerName.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblCustomerName.setBounds(175, 61, 100, 20);
		getContentPane().add(lblCustomerName);
		
		JLabel lblOrder = new JLabel("Oder ID");
		lblOrder.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblOrder.setBounds(25, 91, 100, 20);
		getContentPane().add(lblOrder);
		
		JLabel lblOrderID = new JLabel(Integer.toString(order.getOrderID()));
		lblOrderID.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblOrderID.setBounds(175, 91, 100, 20);
		getContentPane().add(lblOrderID);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblDate.setBounds(25, 122, 100, 20);
		getContentPane().add(lblDate);
		
		JLabel lblOrderDate = new JLabel(order.getDate().toString());
		lblOrderDate.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblOrderDate.setBounds(175, 122, 100, 20);
		getContentPane().add(lblOrderDate);
		
		tableItem = new JTable(data, columnName);
		tableItem.setBounds(25, 169, 363, 198);
		getContentPane().add(tableItem);
		tableItem.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableItem.getColumnModel().getColumn(2).setPreferredWidth(1);
		JScrollPane pane = new JScrollPane(tableItem);
		pane.setBounds(25, 169, 363, 198);

		getContentPane().add(pane);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblAddress.setBounds(25, 388, 100, 20);
		getContentPane().add(lblAddress);
		
		txtAddress = new JTextField(order.getCustomer().getAddress1());
		txtAddress.setBounds(104, 389, 284, 20);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblStatus.setBounds(25, 426, 100, 20);
		getContentPane().add(lblStatus);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"UnSucessFul", "Process", "Delivering", "Delivered", "Cancel"}));
		comboBox.setBounds(104, 427, 114, 20);
		getContentPane().add(comboBox);
		
		for(int i = 0 ; i < comboBox.getItemCount(); i ++) {
		if(order.getStatus().equals(comboBox.getItemAt(i))) {
			comboBox.setSelectedIndex(i);
		}
		}
		btnSave = new JButton("Save");
		btnSave.setBounds(299, 465, 89, 23);
		btnSave.setBackground(new Color(236, 64, 122));
		btnSave.setForeground(Color.WHITE);
		getContentPane().add(btnSave);
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				order.setStatus(String.valueOf(comboBox.getSelectedItem()));
				dispose();
				parent.dispose();
				new ActivityManageOrder(staff);
			}
		});
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
