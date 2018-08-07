package com.liyi.shop.activities;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class CustomerProfile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAddress1;
	private JTextField txtAddress2;

	public CustomerProfile() {
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("My Profile- Account Settings");
		setResizable(false);
		setSize(800,600);
		Color bk = new Color(255, 235, 238);
		getContentPane().setBackground(bk);
		
		Template1 menubar = new Template1(this);
		getContentPane().add(menubar);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 16));
		lblName.setBounds(250, 100, 100, 20);
		getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(371, 100, 200, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEmail.setBounds(250, 150, 100, 20);
		getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPhone.setBounds(250, 200, 100, 20);
		getContentPane().add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address1");
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAddress.setBounds(250, 250, 100, 20);
		getContentPane().add(lblAddress);
		
		JLabel lblAddress2 = new JLabel("Address2");
		lblAddress2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAddress2.setBounds(250, 300, 100, 20);
		getContentPane().add(lblAddress2);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(371, 150, 200, 20);
		getContentPane().add(txtEmail);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(371, 200, 200, 20);
		getContentPane().add(txtPhone);
		
		txtAddress1 = new JTextField();
		txtAddress1.setColumns(10);
		txtAddress1.setBounds(371, 250, 200, 20);
		getContentPane().add(txtAddress1);
		
		txtAddress2 = new JTextField();
		txtAddress2.setColumns(10);
		txtAddress2.setBounds(371, 300, 200, 20);
		getContentPane().add(txtAddress2);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
