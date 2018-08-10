package com.liyi.shop.activities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.liyi.shop.component.CustomTextField;
import com.liyi.shop.component.TableButton;
import com.liyi.shop.model.Customer;
import com.liyi.shop.model.Staff;
import com.liyi.shop.small.activity.AddCustomerPage;
import com.liyi.shop.small.activity.EditCustomer;

public class ActivityAdminCustomer extends JFrame{
	private static final long serialVersionUID = 1L;
	private CustomTextField txtSearch;
	public static Staff staff;
	private JTable table_1;
	private String[] columnName = {"ID", "Name", "Email", "Phone", "Action", "Action"};	
	private Object[][] array ;

	public ActivityAdminCustomer(Staff staff) {
		Color btn = new Color(240, 248, 255);
		array = new Object[Customer.customers.size()][6];
		for(int row = 0; row < array.length; row++) {
			Customer current = Customer.customers.get(row);
			array[row][0] = current.getId();
			array[row][1] = current.getName();
			array[row][2] = current.getEmail();
			array[row][3] = current.getPhone();
			array[row][4] = "Edit";
			array[row][5] = "Delete";
		}
		Template2 menubar = new Template2(staff, this);
		getContentPane().add(menubar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(800,600);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		setTitle("Admin Panel - Customer ");
		
		JButton btnAddCustomer = new JButton("+ Add New Customer");
		btnAddCustomer.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddCustomer.setBounds(585, 60, 177, 28);
		btnAddCustomer.setBackground(btn);
		getContentPane().add(btnAddCustomer);
		
		txtSearch = new CustomTextField("Search...");
		txtSearch.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtSearch.setBounds(26, 115, 670, 30);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		
		JButton btnSearch = new JButton("GO!");
		btnSearch.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		btnSearch.setBounds(698, 115, 64, 30);
		btnSearch.setBackground(btn);
		getContentPane().add(btnSearch);
	
		table_1 = new JTable(array, columnName);
		table_1.setDefaultEditor(Object.class, null);
		table_1.setRowHeight(25);
		table_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		table_1.setBounds(26, 204, 736, 276);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(35);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(35);
		new TableButton(table_1, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new EditCustomer(Customer.customers.get(Integer.parseInt(e.getActionCommand())));
				}catch (ParseException e1) {
				
				}
				
			}
		}, 4);

		new TableButton(table_1, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Warning", 0) == 0) {
					Customer.delCustomer(Integer.parseInt(e.getActionCommand()));
					dispose();
					new ActivityAdminCustomer(staff);
				}else{
					
				};
			}
		}, 5);
		getContentPane().add(table_1);
		Color ivory = new Color(255, 235, 238);
		JScrollPane scroll1 = new JScrollPane(table_1);
		scroll1.setBackground(ivory);
		scroll1.setBounds(26, 178, 736, 343);
		scroll1.getVerticalScrollBar().setPreferredSize(new Dimension(4,2));
		getContentPane().add(scroll1);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh(Customer.searchCustomer(txtSearch.getText()));
				
			}
		});
		btnAddCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCustomerPage(ActivityAdminCustomer.this,staff);
			
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void refresh(ArrayList<Customer> result) {
	
		table_1.setModel(new DefaultTableModel(columnName,result.size()));
		
		new TableButton(table_1, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new EditCustomer(result.get(Integer.parseInt(e.getActionCommand())));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
				}
				
			}
		}, 4);
		new TableButton(table_1, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Customer.delCustomer(Integer.parseInt(e.getActionCommand()));
				dispose();
				new ActivityAdminCustomer(staff);
			}
		}, 5);
		for (int row = 0; row < result.size(); row++) {
			Customer current = result.get(row);
			table_1.getModel().setValueAt(current.getId(), row, 0);
			table_1.getModel().setValueAt(current.getName(), row, 1);
			table_1.getModel().setValueAt(current.getEmail(), row, 2);
			table_1.getModel().setValueAt(current.getPhone(), row, 3);
			table_1.getModel().setValueAt("Edit", row, 4);
			table_1.getModel().setValueAt("Delete", row, 5);

		}
	}
}
