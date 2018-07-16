package com.liyi.shop.activities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

import com.liyi.shop.small.activity.AddCustomerPage;

public class ActivityAdminCustomer extends Template2{
	private JTextField txtSearch;
	public ActivityAdminCustomer() {
	
	}

	@Override
	public void start() {
		setTitle("Admin Panel - Customer ");
		JButton btnAddCustomer = new JButton("+ Add New Customer");
		btnAddCustomer.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddCustomer.setBounds(585, 60, 177, 28);
		getContentPane().add(btnAddCustomer);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtSearch.setBounds(26, 115, 670, 30);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("GO!");
		btnSearch.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		btnSearch.setBounds(698, 115, 64, 30);
		getContentPane().add(btnSearch);
		
		btnAddCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCustomerPage();
			}
		});
		
	}
}
