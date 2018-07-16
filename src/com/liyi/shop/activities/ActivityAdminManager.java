package com.liyi.shop.activities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.liyi.shop.small.activity.AddManagerPage;

public class ActivityAdminManager extends Template2 {
	public ActivityAdminManager() {
	}
	private JTextField txtSearch;
	@Override
	public void start() {
		setTitle("Admin Panel - Manager");
		JButton btnAddManager = new JButton("+ Add New Manager");
		btnAddManager.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		btnAddManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddManager.setBounds(585, 60, 177, 28);
		getContentPane().add(btnAddManager);
		
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
		
		btnAddManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddManagerPage();
				
			}
		});
		
	}

}
