package com.liyi.shop.activities;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.liyi.shop.model.Staff;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;
import javax.swing.JButton;

public abstract class Template2 extends JFrame{
	public static Staff staff;
	public Template2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(800,600);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		
		JLabel lblLogout = new JLabel("Log Out");
		lblLogout.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblLogout.setBounds(697, 16, 60, 15);
		getContentPane().add(lblLogout);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		btnCustomer.setBounds(26, 13, 90, 23);
		getContentPane().add(btnCustomer);
		
		JButton btnManager = new JButton("Manager");
		btnManager.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		btnManager.setBounds(153, 13, 90, 23);
		getContentPane().add(btnManager);
		btnCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ActivityAdminCustomer();
				dispose();
				
			}
		});
		
		btnManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ActivityAdminManager();
				dispose();
				
			}
		});
		start();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public abstract void start();
}
